package com.example1.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example1.demo.model.domain.Article;
import com.example1.demo.model.service.AddArticleRequest;
import com.example1.demo.model.service.blogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody


public class BlogRestController {
        private final blogService blogService;

@PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@ModelAttribute AddArticleRequest request) {
        Article saveArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(saveArticle);
}

        /**
         * The favicon is usually requested by the browser when the page is loaded. We do not serve a favicon,
         * so this method is empty.
         */
@GetMapping("/favicon.ico")
        public void favicon() {
// 아무 작업도 하지 않음
    }
}