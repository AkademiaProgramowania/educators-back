package com.akademia.educators_back.validator;

import com.akademia.educators_back.exception.CommentDoesNotExistException;
import com.akademia.educators_back.exception.TextLengthException;
import com.akademia.educators_back.repository.CommentRepository;
import com.akademia.educators_back.to.CommentTo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentValidator {
    private final int MIN_COMMENT_LENGTH = 3;
    private final int MAX_COMMENT_LENGTH = 5000;
    private CommentRepository commentRepository;

    public void commentExists(CommentTo commentTo) {
        if (commentRepository.existsByAnswer(commentTo.getAnswer())) {
            throw new CommentDoesNotExistException(commentTo.getAnswer());
        }
    }

    public void commentLengthCheck(CommentTo commentTo) {
        int commentLength = commentTo.getAnswer().length();
        if (commentLength < MIN_COMMENT_LENGTH || commentLength > MAX_COMMENT_LENGTH) {
            throw new TextLengthException("Provided answer has incorrect length.");
        }
    }

    public void validation(CommentTo commentTo) {
        commentExists(commentTo);
        commentLengthCheck(commentTo);
    }
}
