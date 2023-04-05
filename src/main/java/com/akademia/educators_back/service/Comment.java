package com.akademia.educators_back.service;

import com.akademia.educators_back.to.CommentTo;

import java.util.List;

public interface Comment {

    void addCommentToDB(CommentTo commentTo);
    void deleteteCommentFromDB(CommentTo commentTo);
    void updateComment(CommentTo commentTo);
    List<CommentTo> getComments();
    CommentTo getCommentById(Long id);

}
