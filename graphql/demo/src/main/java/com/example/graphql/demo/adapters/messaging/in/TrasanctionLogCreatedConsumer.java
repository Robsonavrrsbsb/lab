package com.example.graphql.demo.adapters.messaging.in;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TrasanctionLogCreatedConsumer {


    @KafkaListener(topics = { "${topic.input.transactionlog-created}" }, properties = {"spring.json.value.default.type=com.example.graphql.demo.adapters.messaging.in.TransactionLogCreated"})
    public void consume(@Payload TransactionLogCreated messLogCreated) 
    {
        log.info(messLogCreated.toString());
    }


 
}
