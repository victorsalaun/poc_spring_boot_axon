package com.victorsalaun.pocspringaxon.person.command;

import com.victorsalaun.pocspringaxon.person.PersonDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCommandSearchRepository extends ElasticsearchRepository<PersonDocument, Long> {
}
