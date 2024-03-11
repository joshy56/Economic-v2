package io.github.joshy56.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public record Response<T>(@NotNull ResponseCode responseCode, Optional<Throwable> message, Optional<T> response) {
    public static <V> Response<V> OK(@Nullable V response) {
        return new Response<>(ResponseCode.OK, Optional.empty(), Optional.ofNullable(response));
    }

    public static Response<Void> EMPTY() {
        return new Response<>(ResponseCode.OK, Optional.empty(), Optional.empty());
    }

    public static <V> Response<V> ERROR(@Nullable Throwable throwable) {
        return new Response<>(ResponseCode.ERROR, Optional.ofNullable(throwable), Optional.empty());
    }

    public static Response<Void> NOT_IMPLEMENTED() {
        return new Response<>(ResponseCode.NOT_IMPLEMENTED, Optional.empty(), Optional.empty());
    }

    public boolean failed() {
        return (responseCode.equals(ResponseCode.NOT_IMPLEMENTED) || responseCode.equals(ResponseCode.ERROR));
    }

    public boolean success() {
        return responseCode.equals(ResponseCode.OK);
    }

    public T getOrThrow() throws Throwable {
        return response.orElseThrow(() -> message.orElse(new NullPointerException("No response available.")));
    }
}
