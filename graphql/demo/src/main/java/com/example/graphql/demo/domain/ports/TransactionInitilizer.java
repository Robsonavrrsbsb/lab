package com.example.graphql.demo.domain.ports;

import com.example.graphql.demo.domain.model.Transaction;

public interface TransactionInitilizer {
    
    void sendMessageForCreated(Transaction transaction);
}
