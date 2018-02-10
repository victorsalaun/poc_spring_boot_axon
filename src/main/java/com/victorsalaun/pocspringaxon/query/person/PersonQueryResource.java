package com.victorsalaun.pocspringaxon.query.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/person", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonQueryResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonQueryResource.class);

    private final PersonQueryService personQueryService;

    @Autowired
    public PersonQueryResource(PersonQueryService personQueryService) {
        this.personQueryService = personQueryService;
    }

    @GetMapping()
    @ResponseBody
    public List<Person> getPersons(@RequestParam(required = false) String lastname, @RequestParam(required = false) String firstname) {
        if (!StringUtils.isEmpty(lastname) || !StringUtils.isEmpty(firstname)) {
            LOGGER.debug("Search Person lastname: {}, firstname: {}", lastname, firstname);
            return personQueryService.search(lastname, firstname);
        } else {
            LOGGER.debug("Get Persons list");
            return personQueryService.findAll();
        }
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Person getPerson(@PathVariable String id) {
        LOGGER.debug("Get Person #{}", id);
        return personQueryService.findOne(id);
    }

}
