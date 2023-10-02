package br.com.via.poc.plataformas.app;

import br.com.via.poc.plataformas.app.converter.TransactionToEventConverter;
import br.com.via.poc.plataformas.app.dto.TransactionEvent;
import br.com.via.poc.plataformas.domain.Transaction;
import br.com.via.poc.plataformas.domain.Transactions;
import br.com.via.poc.plataformas.domain.User;
import br.com.via.poc.plataformas.ui.transaction.dto.TransactionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTransactionServiceTest {

    @Mock
    private Transactions transactions;

    @Mock
    private TransactionEventSender sender;

    @Mock
    private TransactionToEventConverter converter;

    private CreateTransactionService subject;

    @BeforeEach
    public void beforeEach() {
        subject = new CreateTransactionService(transactions, sender, converter);
    }

    @Test
    void shouldCreateTransactionAndSendEvent() {

        User user = mock(User.class);
        TransactionDto transaction = mock(TransactionDto.class);
        TransactionEvent event = mock(TransactionEvent.class);

        when(converter.convert(any(), any())).thenReturn(event);
        when(transaction.buildTransaction()).thenReturn(new Transaction("id-qualquer", user, new BigDecimal("200.0"), "Description teste", LocalDateTime.now()));

        subject.execute(transaction);

        verify(sender, times(1)).sendEvent(event);
        verify(converter, times(1)).convert(any(), any());
    }

}