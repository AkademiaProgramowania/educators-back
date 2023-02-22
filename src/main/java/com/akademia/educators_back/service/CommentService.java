package com.akademia.educators_back.service;

import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    CommentRepository commentRepository;

    public void addCommentToDB(CommentEntity comment) {
        commentRepository.save(comment);
    }

    public void deleteProblemFromDB(CommentEntity comment) {commentRepository.delete(comment);
    }

    public void updateComment(Long id, String newAnswer) {
        CommentEntity commentEntity = commentRepository.findById(id).orElseThrow(NullPointerException::new);
        commentEntity.setAnswer(newAnswer);
        commentRepository.save(commentEntity);
    }
}
