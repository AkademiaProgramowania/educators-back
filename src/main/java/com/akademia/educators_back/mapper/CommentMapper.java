package com.akademia.educators_back.mapper;

import com.akademia.educators_back.to.CommentTo;
import com.akademia.educators_back.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentEntity toCommentEntity(CommentTo commentTo){
        CommentEntity commentEntity = new CommentEntity();
        if(commentTo != null){
            commentEntity.setId(commentTo.getId());
        }
        commentEntity.setAnswer(commentTo.getAnswer());
        return commentEntity;
    }

    public CommentTo toCommentTO(CommentEntity commentEntity){
        CommentTo commentTo = new CommentTo();
        if(commentEntity != null){
            commentTo.setId(commentEntity.getId());
        }
        commentTo.setAnswer(commentEntity.getAnswer());
        return commentTo;
    }
}
