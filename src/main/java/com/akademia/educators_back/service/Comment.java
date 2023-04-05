package com.akademia.educators_back.service;

import com.akademia.educators_back.to.CommentTo;

public interface Comment {

    void addCommentToDB(CommentTo commentTo);
    void deleteteCommentFromDB(CommentTo commentTo);
    void updateComment(CommentTo commentTo);

}
