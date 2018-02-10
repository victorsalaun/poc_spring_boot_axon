package com.victorsalaun.pocspringaxon.query.person;

public class PersonByLastnameAndFirstnameQuery {

    private final String lastname;

    private final String firstname;

    public PersonByLastnameAndFirstnameQuery(String lastname, String firstname) {
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
