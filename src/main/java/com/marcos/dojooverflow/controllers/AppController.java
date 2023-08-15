package com.marcos.dojooverflow.controllers;

import com.marcos.dojooverflow.models.Answer;
import com.marcos.dojooverflow.models.Question;
import com.marcos.dojooverflow.models.Tag;
import com.marcos.dojooverflow.models.TagQuestion;
import com.marcos.dojooverflow.services.AnswerService;
import com.marcos.dojooverflow.services.QuestionService;
import com.marcos.dojooverflow.services.QuestionTagService;
import com.marcos.dojooverflow.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import java.util.List;

@Controller
public class AppController{
    private final AnswerService answerServices;
    private final QuestionService questionServices;
    private final TagService tagServices;
    private final QuestionTagService questionTagServices;

    public AppController(AnswerService answerServices, QuestionService questionServices, TagService tagServices, QuestionTagService questionTagServices) {
        this.answerServices = answerServices;
        this.questionServices = questionServices;
        this.tagServices = tagServices;
        this.questionTagServices = questionTagServices;
    }


    @GetMapping("/")
    public String renderIndex(){
        return "index";
    }

    @GetMapping("/questions")
    public String listQuestions(Model model) {
        List<Question> listQuestions = (List<Question>) questionServices.getAllQuestions();
        model.addAttribute("questions",listQuestions);
        return "questions";
    }

    @GetMapping("/questions/new")
    public String renderNewQuestion(@ModelAttribute("questionTagObject") TagQuestion tg){
        return "newQuestion";
    }

    @PostMapping("/questions/new")
    public String sendFormNewQuestion(@Valid @ModelAttribute("questionTagObject") TagQuestion tg, BindingResult result){
        if(result.hasErrors()){
            return "newQuestion";
        }else{
            Question questionForm = tg.getQuestion();
            Tag tagForm = tg.getTag();

            questionForm.getTags().add(tagForm);
            tagForm.getQuestions().add(questionForm);
            
            questionServices.createQuestion(questionForm);
            tagServices.createTag(tagForm);
            questionTagServices.guardadQuestionTag(tg);


            return "redirect:/questions";
        }
    }
    
    @GetMapping("/questions/{id}")
    public String questionDetails(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("answerForm") Answer answerForm){
        Question questionDetail = questionServices.getQuestionById(id);
        viewModel.addAttribute("questionDetail", questionDetail);
        List<Answer> listAnswers = answerServices.getAnswerByQuestion(id);

        viewModel.addAttribute("listAnswers", listAnswers);

        return "detailsQuestion";
    }

    @PostMapping("/questions/{id}")
    public String postAnswer(@PathVariable Long id,@Valid @ModelAttribute("answerForm") Answer answerForm, BindingResult result){

        if(result.hasErrors()){
            return  "detailsQuestion";
        }else{
            Question questionDetail = questionServices.getQuestionById(id);

            Answer newAnswer = new Answer();
            newAnswer.setQuestion(questionDetail);
            newAnswer.setAnswerText(answerForm.getAnswerText());
            answerServices.createAnswer(newAnswer);

            return "redirect:/questions/"+id;
        }
    }

}
