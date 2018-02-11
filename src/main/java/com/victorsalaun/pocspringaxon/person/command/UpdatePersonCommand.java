package com.victorsalaun.pocspringaxon.person.command;

import com.victorsalaun.pocspringaxon.person.PersonDto;
import org.hibernate.validator.constraints.NotBlank;

final class UpdatePersonCommand {

    @NotBlank
    private final Long id;

    @NotBlank
    private final String lastname;

    @NotBlank
    private final String firstname;

    UpdatePersonCommand(Long id, PersonDto personDto) {
        this.id = id;
        this.lastname = personDto.lastname;
        this.firstname = personDto.firstname;
    }

    public Long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

}
