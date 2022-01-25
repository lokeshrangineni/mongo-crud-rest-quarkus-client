package com.redhat.database.benchmark.mongo.crud;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    @Inject
    FruitService fruitService;

    @POST
    public void add(Fruit fruit) {
        fruit.setUuid(UUID.randomUUID().toString());
        fruitService.add(fruit);
    }
}