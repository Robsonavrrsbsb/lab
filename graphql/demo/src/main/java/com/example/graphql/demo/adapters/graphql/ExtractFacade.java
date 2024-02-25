package com.example.graphql.demo.adapters.graphql;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.graphql.demo.domain.ExtractManager;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ExtractFacade {

    private ExtractManager extractManager;

    public List<ExtractItem> getExtract() {

        List<ExtractItem> itens = extractManager.getExtract().getTransactions().stream()
                .map(a -> ExtractItem.builder().code(a.getCode()).description(a.getDescription()).value(a.getValue()).build())
                                 .collect(Collectors.toList());
        return itens;
    }
    
}
