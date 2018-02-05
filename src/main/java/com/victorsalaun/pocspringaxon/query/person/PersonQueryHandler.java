package com.victorsalaun.pocspringaxon.query.person;

import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonQueryHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonQueryHandler.class);

    private final PersonQueryRepository personQueryRepository;

    @Autowired
    public PersonQueryHandler(PersonQueryRepository personQueryRepository) {
        this.personQueryRepository = personQueryRepository;
    }

    @QueryHandler(queryName = "PersonsList")
    public List<Person> handlePersonsList() {
        LOGGER.debug("Handling query PersonsList");
        return personQueryRepository.findAll();
    }

    @QueryHandler(queryName = "PersonById")
    public Person handlePersonById(String id) {
        LOGGER.debug("Handling query PersonById #{}", id);
        return personQueryRepository.findOne(id);
    }

}
