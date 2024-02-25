package com.example.graphql.demo;

import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Publisher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.DgsSubscription;
import com.netflix.graphql.dgs.InputArgument;

import reactor.core.publisher.Flux;

@DgsComponent
public class PlayerGrahQLController {

    private DolarValueService dolarValueService;

    public PlayerGrahQLController(DolarValueService dolarValueService){
        this.dolarValueService = dolarValueService;
    }

    @DgsQuery
    Flux<Player> getAllPlayers() {
        List<Player> players = new ArrayList<Player>();
        players.add(Player.builder().id(1000).name("teste").build());
        players.add(Player.builder().id(1001).name("teste 1").build());
        return Flux.fromIterable(players);

    }


    @DgsMutation
    public List<DolarValue> addDolarValue(@InputArgument SubmmitedDolarValue submmitedDolarValue){
        DolarValue dolar = new DolarValue(submmitedDolarValue.getId(), submmitedDolarValue.getValue());
        return dolarValueService.addDolarValue(dolar);
    }

    @DgsSubscription
    public Publisher<DolarValue> dolarValues() {
        return dolarValueService.getDolarValuePublisher();
        
        
}




}
