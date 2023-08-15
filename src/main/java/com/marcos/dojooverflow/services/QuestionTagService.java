package com.marcos.dojooverflow.services;

import com.marcos.dojooverflow.models.TagQuestion;
import com.marcos.dojooverflow.repositories.TagQuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionTagService{
    private final TagQuestionRepository questionTagRepository;

    public QuestionTagService(TagQuestionRepository questionTagRepository) {
        this.questionTagRepository = questionTagRepository;
    }

    public TagQuestion guardadQuestionTag(TagQuestion tagQuestion){
        return questionTagRepository.save(tagQuestion);
    }
}
