package dev.tvanderb.kahoot4j.internal.entities;

import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.entities.Game;
import dev.tvanderb.kahoot4j.api.exception.CouldNotConnectException;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSession;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.LongPollingTransport;
import org.cometd.common.JSONContext;
import org.cometd.websocket.client.WebSocketTransport;
import org.eclipse.jetty.client.HttpClient;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.util.HashMap;
import java.util.Map;

public class GameImpl implements Game {

    private static final String WEBSOCKET_ENDPOINT = "wss://kahoot.it/cometd/%d/%s";
    private static final String CONTROLLER = "/service/controller";
    private static final String PLAYER = "/service/player";

    private final Integer gamePin;
    private final String sessionId;
    private final KahootClient kClient;

    private final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    private final WebSocketTransport transport = new WebSocketTransport(null, null, container);
    private final BayeuxClient client;

    private final HttpClient pollClient = new HttpClient();
    private final LongPollingTransport pollTransport = new LongPollingTransport(null, pollClient);

    /**
     * Create a new {@link GameImpl} instance.
     *
     * @param client The client.
     * @param gamePin The pin for the game.
     * @param sessionId The session ID for the game.
     */
    public GameImpl(@NotNull KahootClient client, @NotNull Integer gamePin, @NotNull String sessionId) throws CouldNotConnectException {
        this.kClient = client;
        this.gamePin = gamePin;
        this.sessionId = sessionId;

        this.client = new BayeuxClient(String.format(WEBSOCKET_ENDPOINT, gamePin, sessionId), pollTransport);
        this.client.handshake();

        System.out.println(sessionId);

        boolean connected = this.client.waitFor(10000, BayeuxClient.State.HANDSHAKING);
        if (connected) {
            if (this.client.getChannel(CONTROLLER).subscribe(new WebsocketListener(this))) {
                System.out.println("Controller connected");
            }

            if (this.client.getChannel(PLAYER).subscribe(new WebsocketListener(this))) {
                System.out.println("player connected");
            }
        } else {
            throw new CouldNotConnectException(gamePin, "Timed out connecting to the game.");
        }

        JSONObject jsonScreen = new JSONObject();
        jsonScreen.put("width", 1080);
        jsonScreen.put("height", 720);

        JSONObject jsonDevice = new JSONObject();
        jsonDevice.put("userAgent", "Kahoot4J/v1.0-ALPHA");
        jsonDevice.put("screen", jsonScreen);

        JSONObject jsonContent = new JSONObject();
        jsonContent.put("participantUserId", (String)null);
        jsonContent.put("device", jsonDevice);

        Map<String, Object> data = new HashMap<>(5);
        data.put("type", "login");
        data.put("gameid", gamePin);
        data.put("host", "kahoot.it");
        data.put("name", "P3ni5");
        data.put("content", jsonContent);

        this.client.getChannel(CONTROLLER).publish(data);
    }

    @Override
    public KahootClient getSelf() {
        return kClient;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public int getGamePin() {
        return 0;
    }

    @Override
    public int getQuestionCount() {
        return 0;
    }

    @Override
    public void disconnect() {

    }

    private static final class WebsocketListener implements ClientSessionChannel.MessageListener {

        private final Game g;

        public WebsocketListener(Game g) {
            this.g = g;
        }

        @Override
        public void onMessage(ClientSessionChannel channel, Message message) {
            System.out.println(channel.getId() + " : " + message.getJSON());
        }

    }

}
