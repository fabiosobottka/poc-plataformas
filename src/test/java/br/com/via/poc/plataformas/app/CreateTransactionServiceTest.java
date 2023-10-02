package br.com.via.poc.plataformas.app;

import br.com.via.poc.plataformas.app.converter.TransactionToEventConverter;
import br.com.via.poc.plataformas.domain.Transactions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateTransactionServiceTest {

    @Mock
    private Transactions transactions;

    @Mock
    private TransactionEventSender sender;

    @Mock
    private TransactionToEventConverter converter;

    @Test
    void shouldCreateTransaction() {

    }
}