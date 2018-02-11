package com.victorsalaun.pocspringaxon.person.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.common.IdentifierFactory;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class PersonAggregate {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonAggregate.class);

    @AggregateIdentifier
    private String identifier;

    PersonAggregate() {
        // no-args constructor required by Axon
    }

    @CommandHandler
    public PersonAggregate(CreatePersonCommand createPersonCommand) {
        String lastname = createPersonCommand.getLastname();
        String firstname = createPersonCommand.getFirstname();

        String identifier = IdentifierFactory.getInstance().generateIdentifier();

        LOGGER.debug("Applying PersonCreatedEvent: {}", identifier);
        apply(new PersonCreatedEvent(identifier, lastname, firstname));
    }

    @CommandHandler
    public PersonAggregate(DeletePersonCommand deletePersonCommand) {
        Long id = deletePersonCommand.getId();

        String identifier = IdentifierFactory.getInstance().generateIdentifier();

        LOGGER.debug("Applying DeletePersonCommand: {}", identifier);
        apply(new PersonDeletedEvent(identifier, id));
    }

    @CommandHandler
    public PersonAggregate(UpdatePersonCommand updatePersonCommand) {
        Long id = updatePersonCommand.getId();
        String lastname = updatePersonCommand.getLastname();
        String firstname = updatePersonCommand.getFirstname();

        String identifier = IdentifierFactory.getInstance().generateIdentifier();

        LOGGER.debug("Applying PersonUpdatedEvent: {}", identifier);
        apply(new PersonUpdatedEvent(identifier, id, lastname, firstname));
    }

    @EventSourcingHandler
    private void handlePersonCreatedEvent(PersonCreatedEvent event) {
        identifier = event.getIdentifier();
        LOGGER.debug("Handling PersonCreatedEvent: {}", identifier);
    }

    @EventSourcingHandler
    private void handlePersonDeletedEvent(PersonDeletedEvent event) {
        identifier = event.getIdentifier();
        LOGGER.debug("Handling PersonDeletedEvent: {}", identifier);
    }

    @EventSourcingHandler
    private void handlePersonUpdatedEvent(PersonUpdatedEvent event) {
        identifier = event.getIdentifier();
        LOGGER.debug("Handling PersonUpdatedEvent: {}", identifier);
    }

}
