package com.victorsalaun.pocspringaxon.command.person;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/person", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonCommandResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonCommandResource.class);

    private final CommandGateway commandGateway;

    @Autowired
    public PersonCommandResource(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public void createPerson(@RequestBody PersonDto person) {
        LOGGER.debug("Received POST request on /sprints");
        String identifier = commandGateway.sendAndWait(new CreatePersonCommand(person));
    }

}
