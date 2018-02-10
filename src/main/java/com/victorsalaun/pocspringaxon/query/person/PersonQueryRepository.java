package com.victorsalaun.pocspringaxon.query.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonQueryRepository extends JpaRepository<Person, String> {

    List<Person> findByLastname(String lastname);

    List<Person> findByFirstname(String firstname);

    List<Person> findByLastnameAndFirstname(String lastname, String firstname);

}
