package io.github.joshy56;

import io.github.joshy56.currency.CurrencyRepository;
import io.github.joshy56.response.Response;
import io.github.joshy56.subject.SubjectRepository;
import io.github.joshy56.transaction.TransactionHandler;
import io.github.joshy56.transaction.TransactionRepository;

/**
 * @author joshy56
 * @since 3/2/2024
 * Basarse en cada tipo de dinero como unico
 */
public interface Economic {
    Response<CurrencyRepository> currencies();
    Response<SubjectRepository> subjects();
    Response<TransactionRepository> transactions();
    Response<TransactionHandler> transactionHandler();
}
