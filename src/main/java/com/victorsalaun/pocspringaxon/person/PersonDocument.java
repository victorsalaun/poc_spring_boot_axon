package com.victorsalaun.pocspringaxon.person;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "persons", type = "persons", shards = 1)
public class PersonDocument {

    private Long id;

    private String lastname;

    private String firstname;

    protected PersonDocument() {
    }

    public PersonDocument(Long id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

}
