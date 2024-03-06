package io.github.joshy56.transaction;

import io.github.joshy56.currency.Currency;
import io.github.joshy56.response.Response;
import io.github.joshy56.subject.Subject;

import java.util.Set;
import java.util.UUID;

/**
 * @author joshy56
 * @since 12/2/2024
 */
public interface TransactionHandler {

    /**
     *
     * @param subject
     * @param currencyName
     * @return
     */
    Response<Double> balance(UUID subject, String currencyName);

    /**
     *
     * @param subject
     * @param currencyName
     * @param amount
     * @return
     */
    Response<Boolean> withdraw(UUID subject, String currencyName, double amount);

    /**
     *
     * @param subject
     * @param currencyName
     * @param amount
     * @return
     */
    Response<Boolean> deposit(UUID subject, String currencyName, double amount);

    /**
     *
     * @param subject
     * @param currencyName
     * @param amount
     * @return
     */
    Response<Boolean> enoughMoney(UUID subject, String currencyName, double amount);

    /**
     *
     * @param subjectIdentifier
     * @return
     */
    Response<Set<Currency>> currenciesOf(UUID subjectIdentifier);

    /**
     *
     * @param currencyName
     * @return
     */
    Response<Set<Subject>> subjectsOf(String currencyName);
}
