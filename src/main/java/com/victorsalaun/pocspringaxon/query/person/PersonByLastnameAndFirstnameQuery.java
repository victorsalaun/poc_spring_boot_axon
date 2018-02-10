package com.victorsalaun.pocspringaxon.query.person;

final class PersonByLastnameAndFirstnameQuery {

    private final String lastname;

    private final String firstname;

    PersonByLastnameAndFirstnameQuery(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

}
