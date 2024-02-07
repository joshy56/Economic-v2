package io.github.joshy56;

import io.github.joshy56.currency.Currency;
import io.github.joshy56.response.Response;
import io.github.joshy56.subject.Subject;

import java.util.Set;
import java.util.UUID;

/**
 * @author joshy56
 * @since 6/2/2024
 */
public interface TransactionRepository {

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
     * @param currency
     * @return
     */
    Response<Double> balance(UUID subject, Currency currency);

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
     * @param currency
     * @param amount
     * @return
     */
    Response<Boolean> withdraw(UUID subject, Currency currency, double amount);

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
     * @param currency
     * @param amount
     * @return
     */
    Response<Boolean> deposit(UUID subject, Currency currency, double amount);

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
     * @param subject
     * @param currency
     * @param amount
     * @return
     */
    Response<Boolean> enoughMoney(UUID subject, Currency currency, double amount);

    /**
     *
     * @param subject
     * @return
     */
    Response<Set<Currency>> currenciesOf(UUID subject);

    /**
     *
     * @param currency
     * @return
     */
    Response<Set<Subject>> subjectsOf(Currency currency);
}
