package com.marcos.dojooverflow.repositories;

import com.marcos.dojooverflow.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepostory extends JpaRepository<Question, Long>{
}
