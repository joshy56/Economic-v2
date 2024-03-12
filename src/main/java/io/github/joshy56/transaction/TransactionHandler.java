package io.github.joshy56.transaction;

import io.github.joshy56.currency.Currency;
import io.github.joshy56.response.Response;
import io.github.joshy56.subject.Subject;

import java.util.Set;

/**
 * @author joshy56
 * @since 12/2/2024
 */
public interface TransactionHandler {

    /**
     * @param subject
     * @param currency
     * @return
     */
    Response<Double> balance(Subject subject, Currency currency);

    /**
     * @param subject
     * @param currency
     * @param amount
     * @return
     */
    Response<Boolean> withdraw(Subject subject, Currency currency, double amount);

    /**
     * @param subject
     * @param currency
     * @param amount
     * @return
     */
    Response<Boolean> deposit(Subject subject, Currency currency, double amount);

    /**
     * @param subject
     * @param currency
     * @param amount
     * @return
     */
    Response<Boolean> enoughMoney(Subject subject, Currency currency, double amount);

    /**
     * @param subject
     * @return
     */
    Response<Set<Currency>> currenciesOf(Subject subject);

    /**
     * @param currency
     * @return
     */
    Response<Set<Subject>> subjectsOf(Currency currency);
}
