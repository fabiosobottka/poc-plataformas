package br.com.via.poc.plataformas.ui.transaction.dto.update;

import br.com.via.poc.plataformas.domain.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateTransactionStatusDto(@JsonProperty("transaction_status") TransactionStatusDto status) {
    public Transaction buildTransaction() {
        return null;
    }
}
