package com.example.graphql.demo.adapters.graphql;

import java.util.UUID;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

import lombok.AllArgsConstructor;

@DgsComponent
@AllArgsConstructor
public class TransactionEndpoint {

    private TransactionFacade transactionFacade;

    @DgsMutation
    public TransactionResponse doTransaction(@InputArgument(name = "newTransaction") TransactionRequest transactionRequest){
        TransactionResponse response = new TransactionResponse();
        response.setId(transactionFacade.doTransaction(transactionRequest).toString());
        return response;
    }

}
