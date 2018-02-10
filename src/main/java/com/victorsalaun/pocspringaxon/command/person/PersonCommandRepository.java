package com.victorsalaun.pocspringaxon.command.person;

        import com.victorsalaun.pocspringaxon.query.person.Person;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface PersonCommandRepository extends JpaRepository<Person, String> {
}
