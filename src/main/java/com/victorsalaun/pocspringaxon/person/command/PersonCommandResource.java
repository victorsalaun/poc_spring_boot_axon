package com.victorsalaun.pocspringaxon.person.command;

import com.victorsalaun.pocspringaxon.person.PersonDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/person", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonCommandResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonCommandResource.class);

    private final CommandGateway commandGateway;

    @Autowired
    public PersonCommandResource(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createPerson(@RequestBody PersonDto person) {
        LOGGER.debug("Received POST request on /person {}", person.toString());
        commandGateway.sendAndWait(new CreatePersonCommand(person));
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable Long id) {
        LOGGER.debug("Received DELETE request on /person #{}", id);
        commandGateway.sendAndWait(new DeletePersonCommand(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updatePerson(@PathVariable Long id, @RequestBody PersonDto person) {
        LOGGER.debug("Received PUT request on /person #{}: {}", person.toString());
        commandGateway.sendAndWait(new UpdatePersonCommand(id, person));
    }

}
