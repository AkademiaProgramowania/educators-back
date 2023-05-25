package com.akademia.educators_back.controller;

import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.service.impl.CommentServiceImpl;
import com.akademia.educators_back.to.CommentTo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void addComment(@Valid @RequestBody CommentTo commentTo) {
//        commentServiceImpl.addComment(commentTo);
//    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@Valid @RequestBody CommentTo commentTo) {
        commentServiceImpl.addComment(commentTo);
    }

    /*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String > handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

     */
}
