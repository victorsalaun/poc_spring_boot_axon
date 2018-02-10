package com.victorsalaun.pocspringaxon.person.command;

import com.victorsalaun.pocspringaxon.person.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCommandRepository extends JpaRepository<PersonEntity, Long> {
}
