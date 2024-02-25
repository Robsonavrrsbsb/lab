package com.example.graphql.demo.domain;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.graphql.demo.domain.model.Transaction;
import com.example.graphql.demo.domain.ports.TransactionInitilizer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionManager {
    
    private TransactionInitilizer transactionInitilizer;

    public UUID transactionStart(Transaction transaction) {
        transaction.setId(UUID.randomUUID());
        transactionInitilizer.sendMessageForCreated(transaction);
        return transaction.getId();
    }
}
