package com.example.graphql.demo;

import lombok.Data;

@Data
public class DolarValue {
    private String id;
    private Integer value;

    public DolarValue(String id, Integer value) {
        this.id = id;
        this.value = value;
    }

    public DolarValue(String id) {
        this.id = id;
    }
}

