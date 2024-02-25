package com.example.graphql.demo.adapters.messaging.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.graphql.demo.domain.model.Transaction;
import com.example.graphql.demo.domain.ports.TransactionInitilizer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionInitializerMessageProducer implements TransactionInitilizer {

  @Value("${topic.output.transactionlog-created}")
  private String transactionLogCreatedTopic;

  @Autowired
  private KafkaTemplate<String, TransactionLogCreated> kafkaTemplate;

  @Override
  public void sendMessageForCreated(Transaction transaction) {
    TransactionLogCreated transactionLogCreated = TransactionLogCreated.builder()
        .description(transaction.getDescription())
        .transactionValue(transaction.getValue())
        .transactionId(transaction.getId().toString())
        .build();
    kafkaTemplate.send(transactionLogCreatedTopic, transactionLogCreated);
    log.info(transaction.toString());
  }

}
