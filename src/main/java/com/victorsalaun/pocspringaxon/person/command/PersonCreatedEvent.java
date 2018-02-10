package com.victorsalaun.pocspringaxon.person.command;

final class PersonCreatedEvent {

    private final String identifier;

    private final String lastname;
    private final String firstname;

    PersonCreatedEvent(String identifier, String lastname, String firstname) {
        this.identifier = identifier;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

}
