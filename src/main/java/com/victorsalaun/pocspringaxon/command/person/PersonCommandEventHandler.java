package com.victorsalaun.pocspringaxon.command.person;

import com.victorsalaun.pocspringaxon.query.person.Person;
import com.victorsalaun.pocspringaxon.query.person.PersonDocument;
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
        Person person = personCommandRepository.save(new Person(event.getLastname(), event.getFirstname()));
        PersonDocument personCommandDocument = personCommandSearchRepository.save(new PersonDocument(person.getId(), event.getLastname(), event.getFirstname()));
    }

}
