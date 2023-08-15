package com.marcos.dojooverflow.services;

import com.marcos.dojooverflow.models.Question;
import com.marcos.dojooverflow.repositories.QuestionRepostory;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepostory questionRepostory;

    public QuestionService(QuestionRepostory questionRepostory) {
        this.questionRepostory = questionRepostory;
    }
    public Iterable<Question> getAllQuestions() {
        return questionRepostory.findAll();
    }

    public Question createQuestion(Question question) {
       return (Question) questionRepostory.save(question);
    }

    public Question getQuestionById(Long id) {
        return (Question) questionRepostory.findById(id).orElse(null);
    }
}
