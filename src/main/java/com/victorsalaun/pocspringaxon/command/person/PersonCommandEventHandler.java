package com.victorsalaun.pocspringaxon.command.person;

import com.victorsalaun.pocspringaxon.query.person.Person;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonCommandEventHandler {

    private final PersonCommandRepository personCommandRepository;

    @Autowired
    public PersonCommandEventHandler(PersonCommandRepository personCommandRepository) {
        this.personCommandRepository = personCommandRepository;
    }

    @EventSourcingHandler
    public void on(PersonCreatedEvent event) {
        personCommandRepository.save(new Person(event.getLastname(), event.getFirstname()));
    }

}
