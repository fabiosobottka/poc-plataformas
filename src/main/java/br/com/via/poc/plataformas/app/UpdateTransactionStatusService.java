package br.com.via.poc.plataformas.app;

import br.com.via.poc.plataformas.domain.Transaction;
import br.com.via.poc.plataformas.domain.TransactionStatus;
import br.com.via.poc.plataformas.domain.Transactions;
import br.com.via.poc.plataformas.ui.transaction.dto.update.UpdateTransactionStatusDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateTransactionStatusService {

    private final Transactions transactions;

    public UpdateTransactionStatusService(Transactions transactions) {
        this.transactions = transactions;
    }

    public void execute(String id, final UpdateTransactionStatusDto request) {
        Transaction transaction = transactions.findById(id).orElseThrow(RuntimeException::new);
        transaction.updateStatus(TransactionStatus.valueOf(request.status().name()));
        transaction.updateAt(LocalDateTime.now());
        transactions.update(transaction);
    }

}
