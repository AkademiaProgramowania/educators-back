package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.service.Comment;
import com.akademia.educators_back.to.CommentTo;
import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.exception.CommentDoesNotExistException;
import com.akademia.educators_back.mapper.CommentMapper;
import com.akademia.educators_back.repository.CommentRepository;
import com.akademia.educators_back.valicators.CommentValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements Comment {
    @Autowired
    private CommentRepository commentRepository;
    private CommentMapper commentMapper;

    private CommentValidator commentValidator;

    public void addCommentToDB(CommentTo commentTo) {
        //validationMethod(commentTo);
        CommentEntity commentEntity = commentMapper.toCommentEntity(commentTo);
        commentRepository.save(commentEntity);
    }

    @Override
    public void deleteteCommentFromDB(CommentTo commentTo) {
        CommentEntity commentEntity = commentMapper.toCommentEntity(commentTo);
        commentRepository.delete(commentEntity);
    }


    public void updateComment(CommentTo commentTo) {
        CommentEntity commentEntity = commentMapper.toCommentEntity(commentTo);
        commentEntity = commentRepository.findById(commentTo.getId()).orElseThrow(() -> new CommentDoesNotExistException("Comment does not exist"));
        commentEntity.setAnswer(commentTo.getAnswer());
        commentRepository.save(commentEntity);
    }

    @Override
    public List<CommentTo> getComments() {
        List<CommentTo> commentToList = new ArrayList<>();
        List<CommentEntity> comments = commentRepository.findAll();
        for (CommentEntity comment : comments) {
            commentToList.add(commentMapper.toCommentTO(comment));
        }
        return commentToList;
    }

    @Override
    public CommentTo getCommentById(Long id) {
        Optional<CommentEntity> commentOptional = commentRepository.findById(id);
        CommentEntity comment = commentOptional.orElseThrow();
        CommentTo commentToById = commentMapper.toCommentTO(comment);
        return commentToById;
    }

    public void validationMethod(CommentTo commentTo) {
        commentValidator.commentExists(commentTo);
        commentValidator.commentLengthCheck(commentTo);
    }
}
