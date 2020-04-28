package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.demo.blog.impl.entity.User;

import java.security.Principal;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        model.addAttribute("username", user.getUsername());
        return "hello";
    }
}
