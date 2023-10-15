package com.springmvc.chap05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Example03Controller {
    @RequestMapping("/exam03")
    public void requestMethod() {
        System.out.println("@RequestMapping 예제입니다.");
        System.out.println("웹 요청 URL은 /exam03 입니다.");
    }
}
