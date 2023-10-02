package br.com.via.poc.plataformas.ui.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDto(@JsonProperty("registration_number") Long registrationNumber,
                      @JsonProperty("name") String name) { }
