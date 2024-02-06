package io.github.joshy56;

import java.util.List;
import java.util.Set;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public interface CurrencyRespository {
    Response<Currency> get(String name);
    Response<TransactionalCurrency> get(String name, CurrencyAttributes... needed);
    Response<List<Currency>> getThey(Set<String> names);
    Response<List<TransactionalCurrency>> getThey(Set<String> names, CurrencyAttributes... needed);
    Response<List<Currency>> getAll();
    Response<List<TransactionalCurrency>> getAll(CurrencyAttributes... needed);
    Response<Boolean> delete(String name);
    Response<Boolean> deleteThey(Set<String> names);
    Response<Boolean> deleteAll();
    Response<Boolean> set(Currency currency);
    Response<Boolean> setAll(Set<Currency> currencies);
}
