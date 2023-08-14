package com.marcos.dojooverflow.services;

import com.marcos.dojooverflow.models.Question;
import com.marcos.dojooverflow.models.Tag;
import com.marcos.dojooverflow.repositories.QuestionRepostory;
import com.marcos.dojooverflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionTagService{
    private final QuestionRepostory questionRepository;
    private final TagRepository tagRepository;


    public QuestionTagService(QuestionRepostory questionRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
    }

    public void addTagToQuestion(Long questionId, Long tagId) {
        Question question = (Question) questionRepository.findById(questionId).orElse(null);
        Tag tag = (Tag) tagRepository.findById(tagId).orElse(null);

        if (question != null && tag != null) {
            question.getTags().add(tag);
            questionRepository.save(question);
        }
    }
}

