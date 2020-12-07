/**
 * This package includes all of the exceptions that can be thrown by Kahoot4J.<br>
 * Although, I suppose you can throw them too (if you want.)
 *
 * <ul>
 *     <li>{@link dev.tvanderb.kahoot4j.api.exception.CouldNotConnectException CouldNotConnectException}<br>
 *         is thrown when a {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} couldn't connect<br>
 *         to a Kahoot game.
 *     </li>
 *     <li>{@link dev.tvanderb.kahoot4j.api.exception.InvalidGamePinException InvalidGamePinException}<br>
 *         is thrown when a {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} finds that no<br>
 *         game exists with that pin.
 *     </li>
 *     <li>{@link dev.tvanderb.kahoot4j.api.exception.InvalidUsernameException InvalidUsernameException}<br>
 *         is thrown when a username exceeds Kahoot's fifteen character limit.
 *     </li>
 * </ul>
 */
package dev.tvanderb.kahoot4j.api.exception;