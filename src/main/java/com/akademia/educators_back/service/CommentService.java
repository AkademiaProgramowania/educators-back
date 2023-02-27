package com.akademia.educators_back.service;

import com.akademia.educators_back.to.CommentTo;
import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.exception.CommentDoesNotExistException;
import com.akademia.educators_back.mapper.CommentMapper;
import com.akademia.educators_back.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private CommentMapper commentMapper;
    private CommentEntity commentEntity;

    public void addCommentToDB(CommentTo commentTo) {
        commentEntity = commentMapper.toCommentEntity(commentTo);
        commentRepository.save(commentEntity);
    }

    public void deleteProblemFromDB(CommentTo commentTo) {
        commentEntity = commentMapper.toCommentEntity(commentTo);
        commentRepository.delete(commentEntity);
    }

    public void updateComment(CommentTo commentTo) {
        commentEntity = commentMapper.toCommentEntity(commentTo);
        commentEntity = commentRepository.findById(commentTo.getId()).orElseThrow(()->new CommentDoesNotExistException("Such a comment does not exist"));
        commentEntity.setAnswer(commentTo.getAnswer());
        commentRepository.save(commentEntity);
    }
}
