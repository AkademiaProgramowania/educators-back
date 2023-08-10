package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.entity.UserEntity;
import com.akademia.educators_back.mapper.CommentMapper;
import com.akademia.educators_back.repository.CommentRepository;
import com.akademia.educators_back.to.CommentTo;
import com.akademia.educators_back.validator.CommentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTestVerify {

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private CommentMapper commentMapper;
    @Mock
    private CommentValidator commentValidator;

    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyMethodAddComment() {
        CommentTo commentTo = CommentTo.builder()
                .id(1L)
                .answer("Sample answer")
                .userId(123L)
                .problemToId(456L)
                .build();

        CommentEntity commentEntity = CommentEntity.builder()
                .id(1L)
                .answer("Sample answer")
                .userEntity(Mockito.mock(UserEntity.class))
                .problemEntity(Mockito.mock(ProblemEntity.class))
                .build();


        when(commentMapper.toCommentEntity(commentTo)).thenReturn(commentEntity);
        doNothing().when(commentValidator).validation(commentTo);

        commentService.addComment(commentTo);

        verify(commentValidator, times(1)).validation(commentTo);
        verify(commentMapper, times(1)).toCommentEntity(commentTo);
        verify(commentRepository, times(1)).save(commentEntity);
    }

    @Test
    public void verifyMethodDeleteComment() {
        CommentTo commentTo = CommentTo.builder()
                .id(1L)
                .answer("Sample answer")
                .userId(123L)
                .problemToId(456L)
                .build();

        CommentEntity commentEntity = CommentEntity.builder()
                .id(1L)
                .answer("Sample answer")
                .userEntity(Mockito.mock(UserEntity.class))
                .problemEntity(Mockito.mock(ProblemEntity.class))
                .build();

        when(commentMapper.toCommentEntity(commentTo)).thenReturn(commentEntity);
        doNothing().when(commentValidator).validation(commentTo);

        commentService.deleteComment(commentTo);

        verify(commentValidator, times(1)).validation(commentTo);
        verify(commentRepository, times(1)).delete(commentEntity);
    }

    @Test
    public void verifyMethodUpdateComment() {
        Long commentId = 1L;
        String updatedAnswer = "Updated answer";

        CommentTo updatedCommentTo = CommentTo.builder()
                .id(commentId)
                .answer(updatedAnswer)
                .userId(123L)
                .problemToId(456L)
                .build();

        CommentEntity existingCommentEntity = CommentEntity.builder()
                .id(commentId)
                .answer("Sample answer")
                .userEntity(Mockito.mock(UserEntity.class))
                .problemEntity(Mockito.mock(ProblemEntity.class))
                .build();

        when(commentRepository.findById(commentId)).thenReturn(Optional.of(existingCommentEntity));

        commentService.updateComment(updatedCommentTo);

        verify(commentValidator, times(1)).validation(updatedCommentTo);
        verify(commentRepository, times(1)).findById(commentId);
        verify(commentRepository, times(1)).save(existingCommentEntity);
    }

    @Test
    public void verifyMethodGetComments() {
        List<CommentEntity> commentsList = new ArrayList<>();
        commentsList.add(CommentEntity.builder()
                .id(1L)
                .answer("Answer 1")
                .build());
        commentsList.add(CommentEntity.builder()
                .id(2L)
                .answer("Answer 2")
                .build());

        when(commentRepository.findAll()).thenReturn(commentsList);

        List<CommentTo> result = commentService.getComments();

        verify(commentRepository, times(1)).findAll();
        assertEquals(commentsList.size(), result.size());
    }

    @Test
    public void verifyMethodGetCommentById() {
        Long commentId = 1L;
        CommentEntity commentEntity = CommentEntity.builder()
                .id(commentId)
                .answer("Sample answer")
                .userEntity(Mockito.mock(UserEntity.class))
                .problemEntity(Mockito.mock(ProblemEntity.class))
                .build();

        CommentTo expectedCommentTo = CommentTo.builder()
                .id(commentEntity.getId())
                .answer(commentEntity.getAnswer())
                .userId(commentEntity.getUserEntity() != null ? commentEntity.getUserEntity().getId() : null)
                .problemToId(commentEntity.getProblemEntity() != null ? commentEntity.getProblemEntity().getId() : null)
                .build();

        when(commentRepository.findById(commentId)).thenReturn(Optional.of(commentEntity));
        when(commentMapper.toCommentTO(commentEntity)).thenReturn(expectedCommentTo);

        CommentTo result = commentService.getCommentById(commentId);

        assertNotNull(result);
        assertEquals(expectedCommentTo.getId(), result.getId());
        assertEquals(expectedCommentTo.getAnswer(), result.getAnswer());
        assertEquals(expectedCommentTo.getUserId(), result.getUserId());
        assertEquals(expectedCommentTo.getProblemToId(), result.getProblemToId());

        verify(commentRepository, times(1)).findById(commentId);
        verify(commentMapper, times(1)).toCommentTO(commentEntity);
    }
}
