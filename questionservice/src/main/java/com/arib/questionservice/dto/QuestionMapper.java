package com.arib.questionservice.dto;

import com.arib.questionservice.entities.QuestionsEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuestionMapper implements Function<QuestionsEntity, QuestionsEntityWrapper> {

    @Override
    public QuestionsEntityWrapper apply(QuestionsEntity q) {
        return new QuestionsEntityWrapper(q.getQues_id(), q.getQuestiontext(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
    }
}
