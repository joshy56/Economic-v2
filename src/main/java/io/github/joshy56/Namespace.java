package io.github.joshy56;

import org.jetbrains.annotations.NotNull;

/**
 * @author joshy56
 * @since 5/3/2024
 */
public record Namespace(@NotNull String key, @NotNull String name) {
    /**
     * Give the join or formatted value of key and name.
     * @return A formatted tuple of key and name.
     */
    @NotNull String join() {
        if(key().isEmpty()) throw new IllegalArgumentException("Namespace.join() | Can't join because key is empty.");
        if(name().isEmpty()) throw new IllegalArgumentException("Namespace.join() | Can't join because name is empty.");
        return key().toLowerCase().concat(":").concat(name().toLowerCase());
    }
}
