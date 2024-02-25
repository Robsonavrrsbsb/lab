package com.example.graphql.demo.domain.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Extract {
    private List<Transaction> transactions;
}
