package br.com.via.poc.plataformas.ui.transaction.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateTransactionResponse(@JsonProperty("id") String id) {
}
