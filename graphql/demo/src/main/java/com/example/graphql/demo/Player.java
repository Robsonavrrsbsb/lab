package com.example.graphql.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private Integer id;
    private String name;
}
