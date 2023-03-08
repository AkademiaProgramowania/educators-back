package com.akademia.educators_back.service;

import com.akademia.educators_back.service.impl.CommentService;
import com.akademia.educators_back.to.CommentTo;
import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.exception.CommentDoesNotExistException;
import com.akademia.educators_back.mapper.CommentMapper;
import com.akademia.educators_back.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private CommentMapper commentMapper;
    private CommentEntity commentEntity;


    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public void addCommentToDB(CommentTo commentTo) {
        commentRepository.save(commentMapper.toCommentEntity(commentTo));
    }

    public void deleteProblemFromDB(CommentTo commentTo) {
        commentRepository.delete(commentMapper.toCommentEntity(commentTo));
    }

    public void updateComment(CommentTo commentTo) {
        CommentEntity commentEntity;
        commentEntity = commentMapper.toCommentEntity(commentTo);
        commentEntity = commentRepository.findById(commentTo.getId()).orElseThrow(() -> new CommentDoesNotExistException("Comment does not exist"));
        commentEntity.setAnswer(commentTo.getAnswer());
        commentRepository.save(commentEntity);
    }

    public List<CommentTo> getComments() {
        List<CommentTo> commentToList = new ArrayList<>();
        List<CommentEntity> comments = commentRepository.findAll();
        for (CommentEntity comment : comments) {
            commentToList.add(commentMapper.toCommentTO(comment));
        }
        return commentToList;
    }

    public CommentTo getCommentById(Long id){
        Optional<CommentEntity> commentOptional = commentRepository.findById(id);
        CommentEntity comment = commentOptional.orElseThrow();
        CommentTo commentToById = commentMapper.toCommentTO(comment);
        return commentToById;
    }

}
