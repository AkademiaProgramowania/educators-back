package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.service.Comment;
import com.akademia.educators_back.to.CommentTo;
import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.exception.CommentDoesNotExistException;
import com.akademia.educators_back.mapper.CommentMapper;
import com.akademia.educators_back.repository.CommentRepository;
import com.akademia.educators_back.valicators.CommentValidator;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements Comment {

    private CommentRepository commentRepository;
    private CommentMapper commentMapper;
    private CommentEntity commentEntity;

    private CommentValidator commentValidator;

    public void addCommentToDB(CommentTo commentTo) {
        commentEntity = commentMapper.toCommentEntity(commentTo);
        commentRepository.save(commentEntity);
    }

    @Override
    public void deleteteCommentFromDB(CommentTo commentTo) {
        commentEntity = commentMapper.toCommentEntity(commentTo);
        commentRepository.delete(commentEntity);
    }


    public void updateComment(CommentTo commentTo) {
        commentEntity = commentMapper.toCommentEntity(commentTo);
        commentEntity = commentRepository.findById(commentTo.getId()).orElseThrow(() -> new CommentDoesNotExistException("Comment does not exist"));
        commentEntity.setAnswer(commentTo.getAnswer());
        commentRepository.save(commentEntity);
    }

    public void validationMethod(CommentTo commentTo) {
        commentValidator.commentExists(commentTo);
        commentValidator.commentLengthCheck(commentTo);
    }
}
