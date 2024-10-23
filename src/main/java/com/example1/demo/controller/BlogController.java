package com.example1.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example1.demo.model.service.blogService;
import com.example1.demo.model.domain.Article;

@Controller

public class BlogController {
    @Autowired
    blogService blogService;

/*************  ✨ Codeium Command ⭐  *************/
    /**
     * The article_list method handles GET requests to /article_list.
     * It populates the model with a list of all articles, and then returns the
     * article_list.html template, which displays the list of articles.
     */
/******  a33dfa17-372c-40c7-83dc-2ae25563180b  *******/
    @GetMapping("/article_list") // 게시판 링크 지정
    public String article_list(Model model) {
        List<Article> list = blogService.findAll(); // 게시판 리스트
        model.addAttribute("articles", list); // 모델에 추가
    return "article_list"; // .HTML 연결
    }
}