package br.com.via.poc.plataformas.infra.configuration;

import br.com.via.poc.plataformas.app.dto.TransactionEvent;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
class SpringKafkaConfiguration {

    @Value("${backoffice.kafka.broker}")
    private String kafkaBroker;

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBroker);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("transactions")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public ProducerFactory<Integer, TransactionEvent> producerFactory() {
        return new DefaultKafkaProducerFactory<>(senderConfig());
    }

    private Map<String, Object> senderConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBroker);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    public KafkaTemplate<Integer, TransactionEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
