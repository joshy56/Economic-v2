package io.github.joshy56.economic;

import java.util.Optional;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public record Response<T>(ResponseCode responseCode, Optional<Throwable> message, Optional<T> response) {
}
