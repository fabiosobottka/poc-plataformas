package br.com.via.poc.plataformas.infra;

import br.com.via.poc.plataformas.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface SpringDataTransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByUser_RegistrationNumber(Long registrationNumber);
}
