package br.com.via.poc.plataformas.domain;

import java.util.List;
import java.util.Optional;

public interface Transactions {

    Transaction insert(Transaction transaction);

    Transaction update(Transaction transaction);

    Optional<Transaction> findById(String id);

    List<Transaction> findByUserRegistrationNumber(Long registrationNumber);

}
