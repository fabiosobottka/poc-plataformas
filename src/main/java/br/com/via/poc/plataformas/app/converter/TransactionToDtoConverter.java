package br.com.via.poc.plataformas.app.converter;

import br.com.via.poc.plataformas.domain.Transaction;
import br.com.via.poc.plataformas.domain.TransactionStatus;
import br.com.via.poc.plataformas.domain.User;
import br.com.via.poc.plataformas.ui.transaction.dto.GetTransactionsResponse;
import br.com.via.poc.plataformas.ui.transaction.dto.TransactionDto;
import br.com.via.poc.plataformas.ui.transaction.dto.UserDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionToDtoConverter {

    public GetTransactionsResponse convert(List<Transaction> data) {

        List<TransactionDto> transactions = data.stream()
                .map(this::convert)
                .collect(Collectors.collectingAndThen(
                    Collectors.toList(),
                    Collections::unmodifiableList
                ));

        return new GetTransactionsResponse(transactions);
    }


    public TransactionDto convert(final Transaction data) {

        final String id = data.getId();
        final UserDto user = new UserDto(data.getUserRegistrationNumber(), data.getUserName());
        final BigDecimal value = data.getValue();
        final String description = data.getDescription();
        final LocalDateTime date = data.getDate();

        return new TransactionDto(id, user, value, description, date);
    }
}
