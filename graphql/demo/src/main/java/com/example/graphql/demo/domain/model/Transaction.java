package com.example.graphql.demo.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Transaction {
    private UUID id;
    private Integer code;
    private String description;
    private Float value;
   
}
