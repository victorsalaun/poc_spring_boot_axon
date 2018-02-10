package com.victorsalaun.pocspringaxon.person.query;

import com.victorsalaun.pocspringaxon.person.PersonEntity;
import com.victorsalaun.pocspringaxon.person.PersonDocument;
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

    private final PersonQuerySearchRepository personQuerySearchRepository;

    @Autowired
    public PersonQueryHandler(PersonQueryRepository personQueryRepository, PersonQuerySearchRepository personQuerySearchRepository) {
        this.personQueryRepository = personQueryRepository;
        this.personQuerySearchRepository = personQuerySearchRepository;
    }

    @QueryHandler(queryName = "PersonsList")
    public List<PersonEntity> handlePersonsList() {
        LOGGER.debug("Handling query PersonsList");
        return personQueryRepository.findAll();
    }

    @QueryHandler(queryName = "PersonsSearch")
    public List<PersonDocument> handlePersonsSearch(PersonByLastnameAndFirstnameQuery query) {
        LOGGER.debug("Handling query PersonsSearch lastname: {}, firstname! {}", query.getLastname(), query.getFirstname());
        if (!StringUtils.isEmpty(query.getLastname()) && !StringUtils.isEmpty(query.getFirstname())) {
            return personQuerySearchRepository.findByLastnameAndFirstname(query.getLastname(), query.getFirstname());
        }
        if (!StringUtils.isEmpty(query.getLastname())) {
            return personQuerySearchRepository.findByLastname(query.getLastname());
        }
        if (!StringUtils.isEmpty(query.getFirstname())) {
            return personQuerySearchRepository.findByFirstname(query.getFirstname());
        }
        return new ArrayList<>();
    }

    @QueryHandler(queryName = "PersonById")
    public PersonEntity handlePersonById(Long id) {
        LOGGER.debug("Handling query PersonById #{}", id);
        return personQueryRepository.findOne(id);
    }

}
