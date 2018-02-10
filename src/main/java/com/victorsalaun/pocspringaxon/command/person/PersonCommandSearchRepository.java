package com.victorsalaun.pocspringaxon.command.person;

import com.victorsalaun.pocspringaxon.query.person.PersonDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCommandSearchRepository extends ElasticsearchRepository<PersonDocument, Long> {
}
