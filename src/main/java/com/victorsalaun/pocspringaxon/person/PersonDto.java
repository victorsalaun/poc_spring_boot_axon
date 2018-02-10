package com.victorsalaun.pocspringaxon.person;

public class PersonDto {

    public String lastname;

    public String firstname;

    @Override
    public String toString() {
        return "PersonDto{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

}
