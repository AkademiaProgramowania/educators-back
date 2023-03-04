package com.akademia.educators_back.controller;

import com.akademia.educators_back.service.CommentService;
import com.akademia.educators_back.to.CommentTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentTo>> getComments() {
        return ResponseEntity.ok()
                .body(commentService.getComments());
    }

    @PostMapping
    public void createComment(@RequestBody CommentTo commentTo) {
        System.out.println(commentTo.toString());
        commentService.addCommentToDB(commentTo);
    }
}
