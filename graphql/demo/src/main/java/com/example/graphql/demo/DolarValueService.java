package com.example.graphql.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Service
public class DolarValueService {
    
     private ConnectableFlux<DolarValue> dolarValuePublisher;
     private final List<DolarValue> dolarValues = new ArrayList<>();
     private FluxSink<DolarValue> dolarValuesStream;


    @PostConstruct
    private void createDolarValues() {


        Flux<DolarValue> publisher = Flux.create(emitter -> {
            dolarValuesStream = emitter;
        });

        dolarValuePublisher = publisher.publish();
        dolarValuePublisher.connect();

    }


     public Publisher<DolarValue> getDolarValuePublisher() {
        return dolarValuePublisher;
     }

     public List<DolarValue> addDolarValue(DolarValue dolarValue){
        dolarValues.add(dolarValue);
        dolarValuesStream.next(dolarValue);
    
        return dolarValues;
     }
}
