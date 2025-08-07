package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired // sprint boot가 생성해놓은 객체 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleFrom(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm){
        System.out.println(articleForm.toString());

        Article article = articleForm.toEntity();

        // repository에게 entity를 db 안에 저장하도록 함.
        Article saved = articleRepository.save(article);
        System.out.println(saved);

        return "";
    }
}
