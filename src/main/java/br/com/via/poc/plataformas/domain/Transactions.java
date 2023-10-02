package br.com.via.poc.plataformas.domain;

import java.util.Optional;

public interface Transactions {

    Transaction insert(Transaction transaction);

    Transaction update(Transaction transaction);

    Optional<Transaction> findById(String id);

    Optional<Transaction> findByUserRegistrationNumber(Long registrationNumber);

}
