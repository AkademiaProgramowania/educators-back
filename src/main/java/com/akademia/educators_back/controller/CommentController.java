package com.akademia.educators_back.controller;

import com.akademia.educators_back.service.impl.CommentServiceImpl;
import com.akademia.educators_back.to.CommentTo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentController {
    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @GetMapping("/list")
    public ResponseEntity<List<CommentTo>> getComments() {
        return ResponseEntity.ok()
                .body(commentServiceImpl.getComments());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<CommentTo> findCommentById(@PathVariable Long id){
        CommentTo commentTo = commentServiceImpl.getCommentById(id);
        return ResponseEntity.ok()
                .body(commentTo);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addComment(@RequestBody CommentTo commentTo) {
        //System.out.println(commentTo.toString());
        commentServiceImpl.addCommentToDB(commentTo);
    }
}
