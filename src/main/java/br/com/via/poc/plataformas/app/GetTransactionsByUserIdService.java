package br.com.via.poc.plataformas.app;

import br.com.via.poc.plataformas.app.converter.TransactionToDtoConverter;
import br.com.via.poc.plataformas.domain.Transactions;
import br.com.via.poc.plataformas.ui.transaction.dto.GetTransactionsResponse;
import org.springframework.stereotype.Service;

@Service
public class GetTransactionsByUserIdService {

    private final Transactions transactions;

    private final TransactionToDtoConverter converter;

    public GetTransactionsByUserIdService(Transactions transactions, TransactionToDtoConverter converter) {
        this.transactions = transactions;
        this.converter = converter;
    }

    public GetTransactionsResponse execute(final Long userRegistrationNumber) {
        return converter.convert(transactions.findByUserRegistrationNumber(userRegistrationNumber));
    }

}
