package com.example.graphql.demo.adapters.graphql;

import lombok.Data;

@Data
public class TransactionRequest {
    private Integer transactionCode;
    private Float transactionValue;
}
