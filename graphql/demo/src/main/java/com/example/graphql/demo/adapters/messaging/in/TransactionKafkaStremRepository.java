package com.example.graphql.demo.adapters.messaging.in;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Component;

import com.example.graphql.demo.domain.model.Transaction;
import com.example.graphql.demo.domain.ports.TransactionRepository;

@Component
public class TransactionKafkaStremRepository implements TransactionRepository{


    @Value("${topic.output.transactionlog-created}")
    private String transactionLogCreatedTopic;

    @Autowired
    private StreamsBuilderFactoryBean kafkaStreamsFactory;

    @Override
    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        ReadOnlyKeyValueStore<String, TransactionLogCreated> store = kafkaStreamsFactory
                .getKafkaStreams()
                .store(StoreQueryParameters.fromNameAndType(
                    "tabela",
                        QueryableStoreTypes.keyValueStore()));

        KeyValueIterator<String, TransactionLogCreated> it = store.all();
        it.forEachRemaining(kv -> transactions.add(Transaction.builder().description(kv.value.getDescription()).value(kv.value.getTransactionValue()).id(UUID.fromString(kv.value.getTransactionId())).build()));
        return transactions;
    }
}