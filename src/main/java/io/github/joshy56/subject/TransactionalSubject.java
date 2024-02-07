package io.github.joshy56.subject;

import java.util.Optional;
import java.util.UUID;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public record TransactionalSubject(Optional<UUID> identifier, Optional<String> nickname) {
}
