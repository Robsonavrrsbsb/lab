package com.example.graphql.demo.adapters.graphql;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExtractItem {
    private Integer code;
    private String description;
    private Float value;
}
