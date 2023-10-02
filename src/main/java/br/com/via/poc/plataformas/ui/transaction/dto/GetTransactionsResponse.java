package br.com.via.poc.plataformas.ui.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GetTransactionsResponse(@JsonProperty("transactions") List<TransactionDto> transactions) { }
