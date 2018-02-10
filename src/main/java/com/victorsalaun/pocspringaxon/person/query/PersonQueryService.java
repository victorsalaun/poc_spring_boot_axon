package com.victorsalaun.pocspringaxon.person.query;

import com.victorsalaun.pocspringaxon.person.PersonEntity;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class PersonQueryService {

    private final QueryGateway queryGateway;

    @Autowired(required = false)
    public PersonQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<PersonEntity> findAll() {
        CompletableFuture<List> personsList = queryGateway.send("", "PersonsList", List.class);
        try {
            return (List<PersonEntity>) personsList.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonEntity findOne(String id) {
        CompletableFuture<PersonEntity> person = queryGateway.send(id, "PersonById", PersonEntity.class);
        try {
            return person.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PersonEntity> search(String lastname, String firstname) {
        CompletableFuture<List> personsList = queryGateway.send(new PersonByLastnameAndFirstnameQuery(lastname, firstname), "PersonsSearch", List.class);
        try {
            return (List<PersonEntity>) personsList.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
