package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.to.CommentTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    void shouldMapToEntityWithProperToValues() {
        CommentTo commentTest = CommentTo.builder()
                .id(1L)
                .answer("foo")
                .build();

        CommentEntity commentEntity = commentMapper.toCommentEntity(commentTest);

        assertEquals(1L, commentEntity.getId());
        assertEquals("foo", commentEntity.getAnswer());
    }

    @Test
    void shouldMapToCommentWithProperCommentEntityValues() {

        CommentEntity commentEntity = CommentEntity.builder()
                .id(1L)
                .answer("foo")
                .build();

        CommentTo commentTo = commentMapper.toCommentTO(commentEntity);

        assertEquals(1L, commentEntity.getId());
        assertEquals("foo", commentEntity.getAnswer());
    }
}
