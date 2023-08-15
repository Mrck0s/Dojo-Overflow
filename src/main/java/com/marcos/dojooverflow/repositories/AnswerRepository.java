package com.marcos.dojooverflow.repositories;

import com.marcos.dojooverflow.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAll();
    List<Answer> findAllByQuestionId(Long questionId);
}
