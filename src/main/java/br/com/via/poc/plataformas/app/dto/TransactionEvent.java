package br.com.via.poc.plataformas.app.dto;

import br.com.via.poc.plataformas.ui.transaction.dto.TransactionDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionEvent(@JsonProperty("operation") OperationDto operation,
                               @JsonProperty("transaction") TransactionDto transaction) { }
