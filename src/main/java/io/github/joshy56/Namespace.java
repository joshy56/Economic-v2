package io.github.joshy56;

import lombok.NonNull;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * @author joshy56
 * @since 5/3/2024
 */
@Value(staticConstructor = "of")
public class Namespace {
    @With
    @NonNull String key, name;

    public static @NonNull Namespace ofFormatted(@NotNull String value) {
        return Optional.of(value)
                .map(str -> str.indexOf(':'))
                .filter(index -> index > 0)
                .map(index -> new Namespace(value.substring(0, index - 1), value.substring(index)))
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Give the join or formatted value of key and name.
     *
     * @return A formatted tuple of key and name.
     */
    public @NotNull String join() {
        if (getKey().isEmpty())
            throw new IllegalArgumentException("Namespace.join() | Can't join because key is empty.");
        if (getName().isEmpty())
            throw new IllegalArgumentException("Namespace.join() | Can't join because name is empty.");
        return getKey().concat(":").concat(getName());
    }
}
