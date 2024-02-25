package com.example.graphql.demo.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.graphql.demo.domain.model.Extract;
import com.example.graphql.demo.domain.model.Transaction;
import com.example.graphql.demo.domain.ports.TransactionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExtractManager {

    private TransactionRepository transactionRepository;

    public Extract getExtract() {
        List<Transaction> transactions =  new ArrayList<>();
        transactions.addAll(transactionRepository.getTransactions());
        return Extract.builder().transactions(transactions).build();
    }

    
}
