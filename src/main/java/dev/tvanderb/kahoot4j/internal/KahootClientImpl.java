package dev.tvanderb.kahoot4j.internal;

import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.entities.Game;
import dev.tvanderb.kahoot4j.api.events.IEventManager;
import dev.tvanderb.kahoot4j.api.exception.CouldNotConnectException;
import dev.tvanderb.kahoot4j.api.exception.InvalidGamePinException;
import dev.tvanderb.kahoot4j.internal.entities.GameImpl;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * Implementation of {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient}.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class KahootClientImpl implements KahootClient {

    private static final String USER_AGENT = "Kahoot4J-Client/v1.0-ALPHA";
    private static final String RESERVATION_ENDPOINT = "https://kahoot.it/reserve/session/%d/?%d";

    private final HashMap<Integer, Game> games = new HashMap<>();

    private ClientStatus status = ClientStatus.PRE_INITIALIZATION;

    private final IEventManager eventManager;
    private final String username;

    /**
     * Create a new default {@link dev.tvanderb.kahoot4j.internal.KahootClientImpl KahootClient} implementation.
     */
    public KahootClientImpl(@NotNull String username, @NotNull IEventManager eventManager) {
        this.username = username;
        this.eventManager = eventManager;
    }

    @Override
    @NotNull
    public ClientStatus getCurrentStatus() {
        return status;
    }

    @Override
    @NotNull
    public String getUsername() {
        return username;
    }

    @Override
    @NotNull
    public IEventManager getEventManager() {
        return eventManager;
    }

    @Override
    @NotNull
    public Game connect(int gamePin) throws IOException, InvalidGamePinException, CouldNotConnectException {
        URL handshakeUrl = null;
        try {
            handshakeUrl = new URL(String.format(RESERVATION_ENDPOINT, gamePin, System.currentTimeMillis()));
        } catch (MalformedURLException ignore) {}

        HttpURLConnection handshakeConn = (HttpURLConnection) handshakeUrl.openConnection();

        handshakeConn.setRequestProperty("User-Agent", USER_AGENT);
        handshakeConn.setRequestProperty("Accept-Encoding", "\"\"");

        if (handshakeConn.getResponseCode() == 404) {
            throw new InvalidGamePinException(this, gamePin, "Could not find game by pin \"" + gamePin + "\"!");
        }

        String handshakePayload = "";

        InputStreamReader isr = new InputStreamReader(handshakeConn.getInputStream(), StandardCharsets.UTF_8);

        int d = isr.read();
        while (d != -1) {
            handshakePayload += (char) d;
            d = isr.read();
        }

        String challenge;
        try {
            challenge = new JSONObject(handshakePayload).getString("challenge");
        } catch (JSONException ignore) {
            throw new IOException("An error occurred connecting to the Kahoot Game.");
        }

        String sessionToken = handshakeConn.getHeaderField("X-Kahoot-Session-Token");

        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");

        challenge = challenge.replace("\t", "");
        challenge = challenge.replace("\u0000", "");
        challenge = challenge.replaceAll("[^\\x00-\\x7F]", "");
        challenge = challenge.replace("  ", " ");

        challenge = challenge.replace("offset ", "offset");
        challenge = challenge.replace("( ", "(");

        challenge = challenge.replaceAll("if\\(this(.)+angular(.)+isString(.)+offset\\)\\)", "if(true)");
        challenge = challenge.replaceAll("if\\(this(.)+angular(.)+isObject(.)+offset\\)\\)", "if(true)");
        challenge = challenge.replaceAll("if\\(this(.)+angular(.)+isDate(.)+offset\\)\\)", "if(true)");
        challenge = challenge.replaceAll("if\\(this(.)+angular(.)+isArray(.)+offset\\)\\)", "if(true)");

        challenge = challenge.replaceAll("return(.)+_(.+)?\\.(.+)?replace(.+)?\\(message,", "return message.replace(");
        challenge = challenge.replaceAll("(\\)| )?console(.+)?\\.(.+)?log", "$1");

        String sessionId = "";
        try {
            String ans = (String) nashorn.eval(challenge);

            byte[] challengeBytes = ans.getBytes();
            byte[] tokenBytes = Base64.getDecoder().decode(sessionToken.getBytes());

            ByteBuffer b = ByteBuffer.allocate(tokenBytes.length);

            for (short i = 0; i < tokenBytes.length; i++) {
                b.put((byte) (tokenBytes[i] ^ challengeBytes[i % challengeBytes.length]));
            }

            sessionId = new String(b.array());
        } catch (ScriptException ignore) {
            ignore.printStackTrace();
            throw new CouldNotConnectException(gamePin, "Could not connect to game.");
        }

        return new GameImpl(this, gamePin, sessionId);
    }

    private static final class KahootWebsocketHandler {

        private final Game game;

        public KahootWebsocketHandler(Game game) {
            this.game = game;
        }

    }

}
