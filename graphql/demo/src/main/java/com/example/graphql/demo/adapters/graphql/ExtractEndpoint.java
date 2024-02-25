package com.example.graphql.demo.adapters.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import lombok.AllArgsConstructor;

@DgsComponent
@AllArgsConstructor
public class ExtractEndpoint {
    

    private ExtractFacade extractFacade;

    @DgsQuery
    public ExtractResponse getExtract() {
        ExtractResponse extractResponse = new ExtractResponse();
        
        extractResponse.setItens(extractFacade.getExtract());
        
        return extractResponse;

    }
}
