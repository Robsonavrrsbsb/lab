package com.example.graphql.demo.adapters.messaging.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionLogCreated {

    
    private String transactionId;
    private Integer particionNumber;
    private Float transactionValue;
    private String description;

}
