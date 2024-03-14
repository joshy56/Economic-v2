package io.github.joshy56.transaction;

import lombok.NonNull;
import lombok.Value;
import lombok.With;

import java.util.UUID;

/**
 * @author joshy56
 * @since 12/2/2024
 */
@Value(staticConstructor = "of")
public class Transaction {
    @With
    @NonNull UUID subjectIdentifier;
    @With
    @NonNull String currencyName;
    @With
    double amount;
}
