package com.example.graphql.demo.adapters.graphql;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.graphql.demo.domain.TransactionManager;
import com.example.graphql.demo.domain.model.Transaction;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionFacade {
    
    private TransactionManager transactionManager;

    public UUID doTransaction(TransactionRequest transactionRequest){

        Transaction newTransaction = Transaction.builder().code(transactionRequest.getTransactionCode())
            .description("teste")
            .value(transactionRequest.getTransactionValue()).build();

        return transactionManager.transactionStart(newTransaction);


    }
}
