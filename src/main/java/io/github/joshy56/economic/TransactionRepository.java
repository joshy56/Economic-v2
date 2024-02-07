package io.github.joshy56.economic;

import io.github.joshy56.economic.currency.Currency;
import io.github.joshy56.economic.response.Response;
import io.github.joshy56.economic.subject.Subject;

import java.util.Set;
import java.util.UUID;

/**
 * @author joshy56
 * @since 6/2/2024
 */
public interface TransactionRepository {
    Response<Double> balance(UUID subject, String currencyName);
    Response<Double> balance(UUID subject, Currency currency);
    Response<Boolean> balance(UUID subject, String currencyName, double amount);
    Response<Boolean> balance(UUID subject, Currency currency, double amount);
    Response<Boolean> withdraw(UUID subject, String currencyName, double amount);
    Response<Boolean> withdraw(UUID subject, Currency currency, double amount);
    Response<Boolean> deposit(UUID subject, String currencyName, double amount);
    Response<Boolean> deposit(UUID subject, Currency currency, double amount);
    Response<Boolean> enoughMoney(UUID subject, String currencyName, double amount);
    Response<Boolean> enoughMoney(UUID subject, Currency currency, double amount);
    Response<Set<Currency>> currenciesOf(UUID subject);
    Response<Set<Subject>> subjectsOf(Currency currency);
}
