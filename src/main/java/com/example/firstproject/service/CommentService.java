package com.example.firstproject.service;

import com.example.firstproject.annotation.RunningTime;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId){
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .toList();
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto commentDto){
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다."));

        Comment comment = Comment.createComment(commentDto, article);

        Comment created = commentRepository.save(comment);

        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto commentDto){
        Comment target = getComment(id);

        target.patch(commentDto);
        Comment updated = commentRepository.save(target);
        return CommentDto.createCommentDto(updated);
    }

    @RunningTime
    @Transactional
    public CommentDto delete(Long id){
        Comment target = getComment(id);

        commentRepository.delete(target);
        return CommentDto.createCommentDto(target);
    }

    public Comment getComment(Long id){
        return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("대상 댓글이 없습니다."));
    }
}
