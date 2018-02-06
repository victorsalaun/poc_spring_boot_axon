package com.victorsalaun.pocspringaxon.command.person;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.common.IdentifierFactory;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Person {

    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    @AggregateIdentifier
    private String identifier;

    Person() {
        // no-args constructor required by Axon
    }

    @CommandHandler
    public Person(CreatePersonCommand createPersonCommand) {
        String lastname = createPersonCommand.getLastname();
        String firstname = createPersonCommand.getFirstname();

        String identifier = IdentifierFactory.getInstance().generateIdentifier();

        LOGGER.debug("Applying PersonCreatedEvent: {}", identifier);
        apply(new PersonCreatedEvent(identifier, lastname, firstname));
    }

    @EventSourcingHandler
    private void handle(PersonCreatedEvent event) {

        identifier = event.getIdentifier();
        LOGGER.debug("Handling PersonCreatedEvent: {}", identifier);
    }

}