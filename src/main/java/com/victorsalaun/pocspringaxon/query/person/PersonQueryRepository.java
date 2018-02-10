package com.victorsalaun.pocspringaxon.query.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonQueryRepository extends JpaRepository<Person, Long> {
}
