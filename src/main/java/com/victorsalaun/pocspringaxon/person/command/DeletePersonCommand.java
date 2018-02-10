package com.victorsalaun.pocspringaxon.person.command;

import org.hibernate.validator.constraints.NotBlank;

final class DeletePersonCommand {

    @NotBlank
    private final Long id;

    DeletePersonCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
