package com.victorsalaun.pocspringaxon.person.query;

import com.victorsalaun.pocspringaxon.person.PersonDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonQuerySearchRepository extends ElasticsearchRepository<PersonDocument, Long> {

    List<PersonDocument> findByLastname(String lastname);

    List<PersonDocument> findByFirstname(String firstname);

    List<PersonDocument> findByLastnameAndFirstname(String lastname, String firstname);

}
