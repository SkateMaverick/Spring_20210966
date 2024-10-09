package com.example1.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example1.demo.model.domain.Article;
import com.example1.demo.model.domain.TestDB;
import com.example1.demo.model.service.TestService;
import com.example1.demo.model.service.blogService;





@Controller // 컨트롤러 어노테이션 명시
public class DemoController {
@GetMapping("/hello") // 전송 방식 GET
public String hello(Model model) {
    model.addAttribute("data", " 방갑습니다."); // model 설정
        return "hello"; // hello.html 연결
    }

    

@GetMapping("/hello2")
    public String hello2(Model model) {
        model.addAttribute("name", "김산님,");
        model.addAttribute("hi", "반갑습니다,");
        model.addAttribute("today", "오늘,");
        model.addAttribute("weather", "날씨는,");
        model.addAttribute("good", "매우 좋습니다.");
        return "hello2";
    }

@GetMapping("/about_detailed")
    public String about(){
        return "about_detailed";
    }

@GetMapping("/article_list")
    public String article_list(Model model) {
        List<Article> list = blogService.findAll(); // 게시판 리스트
        model.addAttribute("articles", list); // 모델에 추가
        return "article_list"; // .HTML 연결
    }

@GetMapping("/thymeleaf_test1")
    public String thymeleaf_test1(Model model) {
        model.addAttribute("data1", "<h2> 방갑습니다 </h2>");
        model.addAttribute("data2", "태그의 속성 값");
        model.addAttribute("link", 01);
        model.addAttribute("name", "홍길동");
        model.addAttribute("para1", "001");
        model.addAttribute("para2", 002);
        return "thymeleaf_test1";
        }

@Autowired
TestService testService;
@GetMapping("/testdb")
public String getAllTestDBs(Model model) {
    TestDB test = testService.findByName("김산");
    TestDB test1 = testService.findByName("아저씨");
    TestDB test2 = testService.findByName("꾸러기");
        model.addAttribute("data4", test);
        model.addAttribute("data5", test1);
        model.addAttribute("data6", test2);
    System.out.println("데이터 출력 디버그 : " + test);
    return "testdb";
}


    
}
