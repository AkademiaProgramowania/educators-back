package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.to.CommentTo;

import java.util.List;

public interface CommentService {
    void addCommentToDB(CommentTo commentTo);
    void deleteProblemFromDB(CommentTo commentTo);
    void updateComment(CommentTo commentTo);
    List<CommentTo> getComments();
    CommentTo getCommentById(Long id);

}
