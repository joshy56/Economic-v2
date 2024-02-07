package io.github.joshy56.currency;

import io.github.joshy56.response.Response;

import java.util.Set;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public interface CurrencyRepository {

    /**
     *
     * @param name
     * @return
     */
    Response<Currency> get(String name);

    /**
     *
     * @param name
     * @param needed
     * @return
     */
    Response<TransactionalCurrency> get(String name, CurrencyAttributes... needed);

    /**
     *
     * @param names
     * @return
     */
    Response<Set<Currency>> getThey(Set<String> names);

    /**
     *
     * @param names
     * @param needed
     * @return
     */
    Response<Set<TransactionalCurrency>> getThey(Set<String> names, CurrencyAttributes... needed);

    /**
     *
     * @return
     */
    Response<Set<Currency>> getAll();

    /**
     *
     * @param needed
     * @return
     */
    Response<Set<TransactionalCurrency>> getAll(CurrencyAttributes... needed);

    /**
     *
     * @param name
     * @return
     */
    Response<Boolean> delete(String name);

    /**
     *
     * @param names
     * @return
     */
    Response<Boolean> deleteThey(Set<String> names);

    /**
     *
     * @return
     */
    Response<Boolean> deleteAll();

    /**
     *
     * @param currency
     * @return
     */
    Response<Boolean> set(Currency currency);

    /**
     *
     * @param currencies
     * @return
     */
    Response<Boolean> setAll(Set<Currency> currencies);
}
