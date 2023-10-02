package br.com.via.poc.plataformas.app.converter;

import br.com.via.poc.plataformas.app.dto.OperationDto;
import br.com.via.poc.plataformas.app.dto.TransactionEvent;
import br.com.via.poc.plataformas.domain.Transaction;
import br.com.via.poc.plataformas.ui.transaction.dto.TransactionDto;
import br.com.via.poc.plataformas.ui.transaction.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionToEventConverter {
    public TransactionEvent convert(final OperationDto operation, final Transaction transaction) {

        final TransactionDto transactionEvent = new TransactionDto(transaction.getId(), new UserDto(transaction.getUserRegistrationNumber(), transaction.getUserName()),
                transaction.getValue(), transaction.getDescription(), transaction.getDate());

        return new TransactionEvent(operation, transactionEvent);
    }
}
