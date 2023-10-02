package br.com.via.poc.plataformas.infra;

import br.com.via.poc.plataformas.domain.Transaction;
import br.com.via.poc.plataformas.domain.Transactions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
class DataSourceTransactionRepository implements Transactions {

    private final SpringDataTransactionRepository repository;

    DataSourceTransactionRepository(SpringDataTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction insert(Transaction transaction) {
        return repository.insert(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public Optional<Transaction> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Transaction> findByUserRegistrationNumber(Long registrationNumber) {
        return repository.findByUser_RegistrationNumber(registrationNumber);
    }
}
