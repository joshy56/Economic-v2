package io.github.joshy56.transaction;

import io.github.joshy56.Namespace;
import io.github.joshy56.Repository;
import io.github.joshy56.response.Response;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.UUID;

/**
 * @author joshy56
 * @since 6/2/2024
 */
public interface TransactionRepository extends Repository<Namespace, Transaction> {
    /**
     * Get all transactions associated with the given subject.
     *
     * @param subjectId Subject identifier.
     * @return A response that can contain a set of transactions.
     */
    @NotNull Response<Set<Transaction>> getAllOfSubject(UUID subjectId);

    /**
     * Get all transactions associated with the given currency.
     *
     * @param currencyName Name of currency.
     * @return A response that can contain a set of transactions.
     */
    @NotNull Response<Set<Transaction>> getAllOfCurrency(String currencyName);
}
