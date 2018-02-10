package com.victorsalaun.pocspringaxon.query.person;

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

    public List<Person> findAll() {
        CompletableFuture<List> personsList = queryGateway.send("", "PersonsList", List.class);
        try {
            return (List<Person>) personsList.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public Person findOne(String id) {
        CompletableFuture<Person> person = queryGateway.send(id, "PersonById", Person.class);
        try {
            return person.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> search(String lastname, String firstname) {
        CompletableFuture<List> personsList = queryGateway.send(new PersonByLastnameAndFirstnameQuery(lastname, firstname), "PersonsSearch", List.class);
        try {
            return (List<Person>) personsList.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
