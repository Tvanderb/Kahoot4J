/**
 * This is the root package for all Kahoot4J events.
 *
 * <p>You can listen for events by creating a {@link dev.tvanderb.kahoot4j.api.events.KahootEventListener KahootEventListener}<br>
 *    and specifying it when building your {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} with <br>
 *    {@link dev.tvanderb.kahoot4j.api.KahootClientBuilder#addEventListener(dev.tvanderb.kahoot4j.api.events.KahootEventListener)}.<br>
 *    Example:
 *    <code>
 *        public class MyClass {
 *            public static void main(String... args) {
 *                KahootClient client;
 *                try {
 *                    client = new KahootClientBuilder()
 *                            .setUsername("tvanderb")
 *                            .addEventListener(new MyEventListener())
 *                            .build();
 *                } catch (InvalidUsernameException ignore) {}
 *
 *                try {
 *                    client.connect(000000);
 *                } catch (IOException | InvalidGamePinException | CouldNotConnectException e) {
 *                    e.printStackTrace();
 *                }
 *            }
 *
 *            public class MyEventListener implements KahootEventListener {
 *
 *                {@literal @EventHandler(target = {GameConnectedEvent.class})}
 *                public void handleGameConnected(GameConnectedEvent e) {
 *                    System.out.println("Connected to game: " + e.getGamePin());
 *                }
 *
 *            }
 *        }
 *    </code>
 * </p>
 */
package dev.tvanderb.kahoot4j.api.events;