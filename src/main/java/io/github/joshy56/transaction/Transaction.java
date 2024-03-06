package io.github.joshy56.transaction;

import java.util.UUID;

/**
 * @author joshy56
 * @since 12/2/2024
 */
public record Transaction(String currencyName, UUID subjectIdentifier, double amount) {
}
