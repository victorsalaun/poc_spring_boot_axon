package com.victorsalaun.pocspringaxon.person.command;

final class PersonDeletedEvent {

    private final String identifier;

    private final Long id;

    PersonDeletedEvent(String identifier, Long id) {
        this.identifier = identifier;
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Long getId() {
        return id;
    }

}
