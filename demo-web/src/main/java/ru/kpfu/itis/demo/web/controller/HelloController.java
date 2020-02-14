package ru.kpfu.itis.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.demo.web.dto.PostDto;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private List<PostDto> postDtos = new ArrayList<>();

    @GetMapping("/hello/{var}")
    public String hello(@PathVariable String var, @RequestParam(defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("var", var);
        return "hello";
    }

    @PostMapping("/note")
    public String add(@ModelAttribute PostDto postDto){
        postDtos.add(postDto);
        return "redirect:notes";
    }

    @GetMapping("/note")
    public String getAdd(){
        return "post";
    }

    @GetMapping("/notes")
    public String getAll(Model model){
        model.addAttribute("notes", postDtos);
        return "all";
    }
}
