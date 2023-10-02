package br.com.via.poc.plataformas.ui.transaction.dto;

import br.com.via.poc.plataformas.domain.Transaction;
import br.com.via.poc.plataformas.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDto(@JsonProperty("id") String id,
                             @JsonProperty("user") UserDto user,
                             @JsonProperty("value") BigDecimal value,
                             @JsonProperty("description") String description,
                             @JsonProperty("transaction_date") @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime date) {
    public Transaction buildTransaction() {
        final User userDomain = new User(user.name(), user.registrationNumber());
        return new Transaction(id, userDomain, value, description, date);
    }
}
