package br.com.via.poc.plataformas.infra;

import br.com.via.poc.plataformas.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

interface SpringDataTransactionRepository extends MongoRepository<Transaction, String> {
    Optional<Transaction> findByUserRegistrationNumber(Long registrationNumber);
}
