package com.example.firstproject.api;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.service.ArticleService;
import com.example.firstproject.service.CommentService;
import org.apache.catalina.connector.Response;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable("articleId") Long articleId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.comments(articleId));
    }

    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable("articleId") Long articleId, @RequestBody CommentDto commentDto){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.create(articleId, commentDto));
    }

    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable("id") Long id, @RequestBody CommentDto commentDto){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.update(id, commentDto));
    }

    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.delete(id));
    }
}
