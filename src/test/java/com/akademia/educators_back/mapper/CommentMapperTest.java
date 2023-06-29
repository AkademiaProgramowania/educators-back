package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.CommentEntity;
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
        //given
        CommentTo commentTest = CommentTo.builder()
                .id(1L)
                .answer("foo")
                .build();
       //when
        CommentEntity commentEntity = commentMapper.toCommentEntity(commentTest);
        //then
        assertEquals(1L, commentEntity.getId());
        assertEquals("foo", commentEntity.getAnswer());
    }

    @Test
    public void testToDTO_NullInput() {
        //when
        CommentTo commentDTO = commentMapper.toCommentTO(null);
        //then
        assertNull(commentDTO);
    }

    @Test
    void shouldMapToCommentWithProperCommentEntityValues() {
        //given
        CommentEntity commentEntity = CommentEntity.builder()
                .id(1L)
                .answer("foo")
                .build();
        //when
        CommentTo commentTo = commentMapper.toCommentTO(commentEntity);
        //then
        assertEquals(1L, commentEntity.getId());
        assertEquals("foo", commentEntity.getAnswer());
    }

    @Test
    public void testToEntity_NullInput() {
        //when
        CommentEntity commentEntity = commentMapper.toCommentEntity(null);
        //then
        assertNull(commentEntity);
    }

    @Test
    public void testToEntity_InvalidId() {
        //given
        CommentTo commentDTO = new CommentTo();
        commentDTO.setId(-1L);
        commentDTO.setAnswer("Sample answer");
        //then
        assertThrows(IllegalArgumentException.class, () -> commentMapper.toCommentEntity(commentDTO));
    }

    @Test
    public void testToDTO_InvalidEntityState() {
        // Create a CommentEntity with invalid state (missing required attributes)
        //when
        CommentEntity commentEntity = new CommentEntity();
        //given
        commentEntity.setId(1L);
        //then
        assertThrows(IllegalArgumentException.class, () -> commentMapper.toCommentTO(commentEntity));
    }


}
