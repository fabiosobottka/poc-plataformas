package br.com.via.poc.plataformas.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TransactionTest {

    @Mock
    private User user;

    private Transaction subject;

    @Test
    void shouldUpdateTransactionStatusWhenValueIsDifferentToCurrentStatus() {

        subject = spy(new Transaction("id-qualquer", user, new BigDecimal("200.0"), "Description teste", LocalDateTime.now()));
        subject.updateStatus(TransactionStatus.PROCESSED);

        var actual = subject.getStatus();
        assertEquals(TransactionStatus.PROCESSED, actual);
    }

    @Test
    void shouldThrowExceptionWhenValueIsEqualToCurrentStatus() {

        subject = spy(new Transaction("id-qualquer", user, new BigDecimal("200.0"), "Description teste", LocalDateTime.now()));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            subject.updateStatus(TransactionStatus.PROCESSING);
        });

        String expected = "Transaction is with the same status";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }

}
