package com.victorsalaun.pocspringaxon.person.query;

final class PersonByIdQuery {

    private final Long id;

    PersonByIdQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
