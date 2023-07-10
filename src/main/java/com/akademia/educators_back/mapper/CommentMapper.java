package com.akademia.educators_back.mapper;

import com.akademia.educators_back.to.CommentTo;
import com.akademia.educators_back.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentEntity toCommentEntity(CommentTo commentTo) {
        if (commentTo.getId() <= 0) {
            throw new IllegalArgumentException("Invalid id: " + commentTo.getId());
        }
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(commentTo.getId());
        commentEntity.setAnswer(commentTo.getAnswer());
        return commentEntity;
    }

    public CommentTo toCommentTO(CommentEntity commentEntity) {
        if (commentEntity.getAnswer() == null) {
            throw new NullPointerException("Answer attribute is not provided");
        }
        CommentTo commentTo = new CommentTo();
        commentTo.setId(commentEntity.getId());
        commentTo.setAnswer(commentEntity.getAnswer());
        commentTo.setUserId(commentEntity.getUserEntity() != null ? commentEntity.getUserEntity().getId() : null);
        commentTo.setProblemToId(commentEntity.getProblemEntity() != null ? commentEntity.getProblemEntity().getId() : null);
        return commentTo;
    }

}
