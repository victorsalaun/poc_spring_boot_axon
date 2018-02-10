package com.victorsalaun.pocspringaxon.person.query;

import com.victorsalaun.pocspringaxon.person.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonQueryRepository extends JpaRepository<PersonEntity, Long> {
}
