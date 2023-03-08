package com.akademia.educators_back.controller;

import com.akademia.educators_back.service.CommentServiceImpl;
import com.akademia.educators_back.service.impl.CommentService;
import com.akademia.educators_back.to.CommentTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/api/commentList")
    public ResponseEntity<List<CommentTo>> getComments() {
        return ResponseEntity.ok()
                .body(commentService.getComments());
    }

    @GetMapping("/api/commentList/{id}")
    public ResponseEntity<CommentTo> findCommentById(@PathVariable Long id){
        CommentTo commentTo = commentService.getCommentById(id);
        return ResponseEntity.ok()
                .body(commentTo);
    }

    @PostMapping
    public void createComment(@RequestBody CommentTo commentTo) {
        System.out.println(commentTo.toString());
        commentService.addCommentToDB(commentTo);
    }
}
