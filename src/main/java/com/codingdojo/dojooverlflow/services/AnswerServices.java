package com.codingdojo.dojooverlflow.services;

import com.codingdojo.dojooverlflow.models.Answer;
import com.codingdojo.dojooverlflow.models.Question;
import com.codingdojo.dojooverlflow.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServices {
    private final AnswerRepository answerRepository;
    public AnswerServices(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    public Answer crearAnswer(Answer answer){
        return answerRepository.save(answer);
    }

    public List<Answer> traerAnswersPorQuestion(Long questionId){
        return answerRepository.findAllByQuestionId(questionId);
    }
}
