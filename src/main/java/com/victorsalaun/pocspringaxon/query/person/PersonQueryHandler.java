package com.victorsalaun.pocspringaxon.query.person;

import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

    @QueryHandler(queryName = "PersonsSearch")
    public List<Person> handlePersonsSearch(PersonByLastnameAndFirstnameQuery query) {
        LOGGER.debug("Handling query PersonsSearch lastname: {}, firstname! {}", query.getLastname(), query.getFirstname());
        if (!StringUtils.isEmpty(query.getLastname()) && !StringUtils.isEmpty(query.getFirstname())) {
            return personQueryRepository.findByLastnameAndFirstname(query.getLastname(), query.getFirstname());
        }
        if (!StringUtils.isEmpty(query.getLastname())) {
            return personQueryRepository.findByLastname(query.getLastname());
        }
        if (!StringUtils.isEmpty(query.getFirstname())) {
            return personQueryRepository.findByFirstname(query.getFirstname());
        }
        return new ArrayList<>();
    }

    @QueryHandler(queryName = "PersonById")
    public Person handlePersonById(String id) {
        LOGGER.debug("Handling query PersonById #{}", id);
        return personQueryRepository.findOne(id);
    }

}
