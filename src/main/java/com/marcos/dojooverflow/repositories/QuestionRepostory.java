package com.marcos.dojooverflow.repositories;

import com.marcos.dojooverflow.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepostory extends CrudRepository {
    List<Question> findAll();
}
