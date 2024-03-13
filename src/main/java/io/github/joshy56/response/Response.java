package io.github.joshy56.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public final class Response<T> {
    private static final Response<?> EMPTY = new Response<>(ResponseCode.OK, null, null), NOT_IMPLEMENTED = new Response<>(ResponseCode.NOT_IMPLEMENTED, null, null);
    private final T value;
    private final ResponseCode code;
    private final Throwable error;

    private <X extends Throwable> Response(@NotNull ResponseCode code, @Nullable T value, @Nullable X error) {
        this.code = code;
        this.value = value;
        this.error = error;
    }

    public static <T>  @NotNull Response<T> of(@NotNull T value) {
        return new Response<>(ResponseCode.OK, value, null);
    }

    public static <T, X extends Throwable> @NotNull Response<T> ofNullable(@Nullable T value, @Nullable X error) {
        return new Response<>((error == null) ? ResponseCode.OK : ResponseCode.ERROR, value, error);
    }

    @SuppressWarnings("unchecked")
    public static <T> @NotNull Response<T> empty() {
        return (Response<T>) EMPTY;
    }

    @SuppressWarnings("unchecked")
    public static <T> @NotNull Response<T> notImplemented() {
        return (Response<T>) NOT_IMPLEMENTED;
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public @NotNull T orElseThrow() throws Throwable {
        if (isEmpty())
            throw (error == null) ? new NoSuchElementException("No value present") : error;
        return value;
    }

    public @NotNull <X extends Throwable> T orElseThrowSupplied(@NotNull Supplier<X> supplier) throws X {
        if (isEmpty()) throw supplier.get();
        return value;
    }

    public @NotNull T orElse(@NotNull T other) {
        return isPresent() ? value : other;
    }

    public @NotNull T orElseSupplied(@NotNull Supplier<T> supplier) {
        return orElse(supplier.get());
    }

    public void ifPresent(@NotNull BiConsumer<ResponseCode, T> action) {
        if (isPresent()) action.accept(code, value);
    }

    public void ifPresentOrElse(@NotNull BiConsumer<ResponseCode, T> action, @NotNull Consumer<ResponseCode> exceptionally) {
        if (isPresent()) action.accept(code, value);
        else exceptionally.accept(code);
    }

    public @NotNull Response<T> filter(@NotNull BiPredicate<ResponseCode, T> condition) {
        if (isEmpty()) return this;
        return condition.test(code, value) ? this : empty();
    }

    @SuppressWarnings("unchecked")
    public <U> @NotNull Response<U> map(@NotNull BiFunction<ResponseCode, T, U> mapper) {
        if (isEmpty()) return empty();
        try {
            U mappedValue = mapper.apply(code, value);
            return Response.ofNullable(mappedValue, null);
        } catch (Throwable ok) {
            return Response.ofNullable(null, ok);
        }
    }

    @SuppressWarnings("unchecked")
    public <U> @NotNull Response<U> flatMap(@NotNull BiFunction<ResponseCode, T, Response<U>> mapper) {
        if (isEmpty()) return empty();
        return mapper.apply(code, value);
    }

    public @NotNull Response<T> or(@NotNull Supplier<Response<T>> supplier) {
        if (isPresent()) return this;
        return supplier.get();
    }

    public @NotNull Stream<T> stream() {
        return Stream.ofNullable(value);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        return ((obj instanceof Response<?> other) && Objects.equals(code, other.code) && Objects.equals(value, other.value));
    }

    @Override
    public @NotNull String toString() {
        return "Response: {\n   Response code: " +
                code +
                "\n   Value: " +
                (isPresent() ? value : "empty") +
                "\n   Error: " +
                ((error != null) ? (error.getClass().getName() + ": [" + error.getMessage() + "]") : "empty") +
                "\n}";
    }
}
