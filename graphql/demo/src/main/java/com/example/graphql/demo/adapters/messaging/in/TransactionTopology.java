package com.example.graphql.demo.adapters.messaging.in;


import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

@Component
public class TransactionTopology {

    public static final String TRANSACTION_STREAM = "transaction_stream";

    @Value("${topic.output.transactionlog-created}")
    private String transactionLogCreatedTopic;

    @Autowired
    public void process(StreamsBuilder streamsBuilder) {

        KStream<String, TransactionLogCreated> logStreams = streamsBuilder.stream(transactionLogCreatedTopic,
                Consumed.with(Serdes.String(), new JsonSerde<>(TransactionLogCreated.class)))
                .selectKey((key, value) -> value.getTransactionId());

        KTable<String, TransactionLogCreated> convertedTable = logStreams.toTable(Materialized.as("tabela"));

    }

}
