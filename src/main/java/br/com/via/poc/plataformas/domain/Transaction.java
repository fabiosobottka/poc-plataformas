package br.com.via.poc.plataformas.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Document("transaction")
public class Transaction {
    @Id
    private String id;

    private User user;

    @Field(targetType = DECIMAL128)
    private BigDecimal value;

    private String description;

    private LocalDateTime date;

    private TransactionStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Transaction(String id, User user, BigDecimal value, String description, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.value = value;
        this.description = description;
        this.date = date;
        this.createdAt = LocalDateTime.now();
        this.status = TransactionStatus.PROCESSING;
    }

    public void updateStatus(TransactionStatus status) {
        if(this.status.equals(status)) {
            throw new IllegalArgumentException("Transaction is with the same status: " + status.name());
        }

        this.status = status;
    }

    public void updateAtWithCurrentDateTime() {
        this.updatedAt = LocalDateTime.now();
    }

    public String getUserName() {
        return user.getName();
    }

    public Long getUserRegistrationNumber() {
        return user.getRegistrationNumber();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TransactionStatus getStatus() {
        return status;
    }
}
