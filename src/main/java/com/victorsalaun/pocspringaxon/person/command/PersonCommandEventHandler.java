package com.victorsalaun.pocspringaxon.person.command;

import com.victorsalaun.pocspringaxon.person.PersonEntity;
import com.victorsalaun.pocspringaxon.person.PersonDocument;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonCommandEventHandler {

    private final PersonCommandRepository personCommandRepository;

    private final PersonCommandSearchRepository personCommandSearchRepository;

    @Autowired
    public PersonCommandEventHandler(PersonCommandRepository personCommandRepository, PersonCommandSearchRepository personCommandSearchRepository) {
        this.personCommandRepository = personCommandRepository;
        this.personCommandSearchRepository = personCommandSearchRepository;
    }

    @EventSourcingHandler
    public void on(PersonCreatedEvent event) {
        PersonEntity person = personCommandRepository.save(new PersonEntity(event.getLastname(), event.getFirstname()));
        PersonDocument personCommandDocument = personCommandSearchRepository.save(new PersonDocument(person.getId(), event.getLastname(), event.getFirstname()));
    }

}
