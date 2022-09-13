package com.kafka.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String client) {
        /*Client newCliente= Client.builder()
                .idClient(client.getIdClient())
                .name(client.getName())
                .documentNumber(client.getDocumentNumber())
                .documentType(client.getDocumentType())
                .typeClient(client.getTypeClient())
                .build();*/

        LOGGER.info("Producing message {}", client);
        this.kafkaTemplate.send("TOPIC-DEMO", client);
    }
}
