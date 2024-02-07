package io.github.joshy56.economic;

import java.util.Optional;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public record TransactionalCurrency(Optional<String> name, Optional<String> displayName, Optional<String> displayNamePlural, Optional<String> abbreviation, Optional<Character> symbol) {
}
