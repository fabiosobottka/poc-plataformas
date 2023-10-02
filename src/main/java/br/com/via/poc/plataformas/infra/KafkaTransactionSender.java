package br.com.via.poc.plataformas.infra;

import br.com.via.poc.plataformas.app.TransactionEventSender;
import br.com.via.poc.plataformas.app.dto.TransactionEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTransactionSender implements TransactionEventSender {

    private static final String topic = "transactions";

    private final KafkaTemplate<Integer, TransactionEvent> kafkaTemplate;

    public KafkaTransactionSender(KafkaTemplate<Integer, TransactionEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendEvent(TransactionEvent data) {
        this.kafkaTemplate.send(topic, data);
    }

}
