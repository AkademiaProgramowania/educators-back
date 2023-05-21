package com.akademia.educators_back.service;

import com.akademia.educators_back.controller.CommentController;
import com.akademia.educators_back.to.CommentTo;

import java.util.List;

public interface Comment {
    void addComment(CommentTo commentTo);
    void deleteComment(CommentTo commentTo);
    void updateComment(CommentTo commentTo);
    List<CommentTo> getComments();
    CommentTo getCommentById(Long id);
}
