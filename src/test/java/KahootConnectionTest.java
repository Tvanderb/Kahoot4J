import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.KahootClientBuilder;
import dev.tvanderb.kahoot4j.api.entities.Game;
import dev.tvanderb.kahoot4j.api.exception.CouldNotConnectException;
import dev.tvanderb.kahoot4j.api.exception.InvalidGamePinException;
import dev.tvanderb.kahoot4j.api.exception.InvalidUsernameException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class KahootConnectionTest {

    @Test
    public void test() {
        int gamePin = 9880197;

        KahootClient client;
        try {
            client = new KahootClientBuilder()
                    .setUsername("tvanderb")
                    .build();
        } catch (InvalidUsernameException e) {
            Assert.fail("An invalid username was provided to the KahootClientBuilder.");
            return;
        }

        Game game;
        try {
            game = client.connect(gamePin);
        } catch (IOException e) {
            Assert.fail("An IOException was thrown by KahootClient#connect.");
            return;
        } catch (InvalidGamePinException e) {
            Assert.fail("An invalid game pin was provided to the KahootClient.");
            return;
        } catch (CouldNotConnectException e) {
            Assert.fail("The KahootClient couldn't connect to the game.");
            return;
        }

        Assert.assertNotNull("The resulting Game object from KahootClient#connect is null.", game);
    }

}
