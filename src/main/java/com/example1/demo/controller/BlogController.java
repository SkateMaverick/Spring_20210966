package com.example1.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example1.demo.model.service.AddArticleRequest;
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

    
    @GetMapping("/article_edit/{id}") // 게시판 링크 지정
      public String article_edit(Model model, @PathVariable Long id) {
        Optional<Article> list = blogService.findById(id); // 선택한 게시판 글
            if (list.isPresent()) {
                model.addAttribute("article", list.get()); // 존재하면 Article 객체를 모델에 추가
            } else {
                // 처리할 로직 추가 (예: 오류 페이지로 리다이렉트, 예외 처리 등)
               return "/error_page/article_error"; // 오류 처리 페이지로 연결
            }
        return "article_edit"; // .HTML 연결
    }

    @DeleteMapping("/api/article_delete/{id}")
        public String deleteArticle(@PathVariable Long id) {
            blogService.delete(id);
        return "redirect:/article_list";
    }
    
}