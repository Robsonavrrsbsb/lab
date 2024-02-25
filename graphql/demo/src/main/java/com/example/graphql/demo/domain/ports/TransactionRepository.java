package com.example.graphql.demo.domain.ports;

import java.util.List;

import com.example.graphql.demo.domain.model.Transaction;

public interface TransactionRepository {
    
    List<Transaction> getTransactions();
}
