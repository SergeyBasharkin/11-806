package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.demo.blog.web.dto.UserRegistrationRequest;
import ru.kpfu.itis.demo.blog.web.event.RegistrationEvent;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final ApplicationEventPublisher publisher;

    public RegistrationController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/reg")
    public String getReg(){
        return "user/registration";
    }

    @PostMapping("/reg")
    public String registration(@ModelAttribute("user") @Valid UserRegistrationRequest userDTO, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("errors",errors);
            return "user/registration";
        }
        publisher.publishEvent(new RegistrationEvent(userDTO));
        return "redirect:/reg";
    }
}
