package com.marcos.dojooverflow.repositories;

import com.marcos.dojooverflow.models.TagQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagQuestionRepository extends CrudRepository<TagQuestion, Long> {
}
