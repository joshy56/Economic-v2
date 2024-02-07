package io.github.joshy56.response;

import java.util.Optional;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public record Response<T>(ResponseCode responseCode, Optional<Throwable> message, Optional<T> response) {
    public boolean failed() {
        return (responseCode.equals(ResponseCode.NOT_IMPLEMENTED) || responseCode.equals(ResponseCode.ERROR));
    }

    public boolean success() {
        return responseCode.equals(ResponseCode.OK);
    }
}
