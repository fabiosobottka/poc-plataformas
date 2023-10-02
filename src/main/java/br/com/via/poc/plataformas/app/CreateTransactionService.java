package br.com.via.poc.plataformas.app;

import br.com.via.poc.plataformas.app.converter.TransactionToEventConverter;
import br.com.via.poc.plataformas.app.dto.OperationDto;
import br.com.via.poc.plataformas.domain.Transaction;
import br.com.via.poc.plataformas.domain.Transactions;
import br.com.via.poc.plataformas.infra.KafkaTransactionSender;
import br.com.via.poc.plataformas.ui.transaction.dto.TransactionDto;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionService {

    private final Transactions transactions;

    private final TransactionEventSender sender;

    private final TransactionToEventConverter converter;

    public CreateTransactionService(Transactions transactions, KafkaTransactionSender sender, TransactionToEventConverter converter) {
        this.transactions = transactions;
        this.sender = sender;
        this.converter = converter;
    }

    public String execute(final TransactionDto data) {
        final Transaction transaction = data.buildTransaction();
        sender.sendEvent(converter.convert(OperationDto.CREATE, transactions.insert(transaction)));
        return transaction.getId();
    }
}
