package br.com.via.poc.plataformas.app;

import br.com.via.poc.plataformas.app.converter.TransactionToEventConverter;
import br.com.via.poc.plataformas.app.dto.OperationDto;
import br.com.via.poc.plataformas.domain.Transaction;
import br.com.via.poc.plataformas.domain.TransactionStatus;
import br.com.via.poc.plataformas.domain.Transactions;
import br.com.via.poc.plataformas.ui.transaction.dto.update.UpdateTransactionStatusDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateTransactionStatusService {

    private final Transactions transactions;

    private final TransactionToEventConverter converter;

    public UpdateTransactionStatusService(Transactions transactions, TransactionToEventConverter converter) {
        this.transactions = transactions;
        this.converter = converter;
    }

    public void execute(String id, final UpdateTransactionStatusDto request) {
        Transaction transaction = transactions.findById(id).orElseThrow(RuntimeException::new);
        transaction.updateStatus(TransactionStatus.valueOf(request.status().name()));
        transaction.updateAt(LocalDateTime.now());

        converter.convert(OperationDto.UPDATE, transactions.update(transaction));
    }

}
