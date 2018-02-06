package com.victorsalaun.pocspringaxon.command.person;

import org.hibernate.validator.constraints.NotBlank;

final class CreatePersonCommand {

    @NotBlank
    private final String lastname;

    @NotBlank
    private final String firstname;

    CreatePersonCommand(PersonDto personDto) {
        this.lastname = personDto.lastname;
        this.firstname = personDto.firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

}
