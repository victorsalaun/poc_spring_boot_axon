package com.victorsalaun.pocspringaxon.person.command;

final class PersonUpdatedEvent {

    private final String identifier;

    private final Long id;
    private final String lastname;
    private final String firstname;

    PersonUpdatedEvent(String identifier, Long id, String lastname, String firstname) {
        this.identifier = identifier;
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getIdentifier() {
        return identifier;
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
