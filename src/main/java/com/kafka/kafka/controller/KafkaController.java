package com.kafka.kafka.controller;

import com.kafka.kafka.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaProducer kafkaProducer1;

    @Autowired
    KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer1 = kafkaProducer;
    }

    @PostMapping(value = "/create")
    public void sendMessageToKafkaTopic(@RequestBody String client) {
        logger.info("KafkaController KafkaController {}", client.toString());
        this.kafkaProducer1.sendMessage(client);
        //return Mono.just(client);
    }



}