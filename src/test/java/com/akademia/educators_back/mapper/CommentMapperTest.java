package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.to.CommentTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentMapperTest {
    private final String SAMPLE_ANSWER = "foo";
    private final long SAMPLE_ID = 1L;
    @Autowired
    private CommentMapper commentMapper;

    @Test
    void shouldMapToEntityWithProperToValues() {
        //given
        CommentTo commentTest = CommentTo.builder()
                .id(SAMPLE_ID)
                .answer(SAMPLE_ANSWER)
                .build();
        //when
        CommentEntity commentEntity = commentMapper.toCommentEntity(commentTest);
        //then
        assertEquals(SAMPLE_ID, commentEntity.getId());
        assertEquals(SAMPLE_ANSWER, commentEntity.getAnswer());
    }

    @Test
    void shouldMapToCommentWithProperCommentEntityValues() {
        //given
        CommentEntity commentEntity = CommentEntity.builder()
                .id(SAMPLE_ID)
                .answer(SAMPLE_ANSWER)
                .build();
        //when
        CommentTo commentTo = commentMapper.toCommentTO(commentEntity);
        //then
        assertEquals(SAMPLE_ID, commentTo.getId());
        assertEquals(SAMPLE_ANSWER, commentTo.getAnswer());
    }

    @Test
    public void testToEntityInvalidId() {
        //given
        CommentTo commentDTO = new CommentTo();
        commentDTO.setId(-1L);
        commentDTO.setAnswer(SAMPLE_ANSWER);
        //then
        assertThrows(IllegalArgumentException.class, () -> commentMapper.toCommentEntity(commentDTO));
    }

    @Test
    public void testToDTOInvalidEntityState() {
        //given - missing atributes
        CommentEntity commentEntity = CommentEntity.builder()
                .id(SAMPLE_ID)
                .answer(null)
                .build();

        assertThrows(NullPointerException.class, () -> {
            commentMapper.toCommentTO(commentEntity);
        });
    }
}
