package com.codegym.picture.validate;

import com.codegym.picture.entity.BadWord;
import com.codegym.picture.entity.Comment;
import com.codegym.picture.repo.BadWordRepo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class CommentValidator implements Validator {

    public CommentValidator() {

    }

    private static List<BadWord> badWordList = new ArrayList();

    static {
        badWordList.add(new BadWord(1, "fuck"));
        badWordList.add(new BadWord(2, "motherfucker"));
        badWordList.add(new BadWord(3, "fuck"));
        badWordList.add(new BadWord(4, "fuck"));
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        if (!(target instanceof Comment)) {
            return;
        }

        Comment comment = (Comment) target;
        for (BadWord word : badWordList) {
            if (comment.getFeedback().contains(word.getWord())) {
                errors.rejectValue("feedback", "bad word", "Content is informal!");
                break;
            }
        }

        if (comment.getFeedback().equals("")) {
            errors.rejectValue("feedback", "not blank", "Content is not blank!");
        }

        if (!comment.getAuthor().matches("[A-Z][a-z0-9]+")) {
            errors.rejectValue("author", "bad word", "Name has the first upper letter!");
        }
    }
}
