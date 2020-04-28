package ru.kpfu.itis.demo.blog.web.controller;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;
import ru.kpfu.itis.demo.blog.api.service.UserService;
import ru.kpfu.itis.demo.blog.impl.entity.User;
import ru.kpfu.itis.demo.blog.web.dto.UserRegistrationRequest;
import ru.kpfu.itis.demo.blog.web.event.RegistrationEvent;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService<User> userService;
    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher publisher;

    public RegistrationController(UserService<User> userService, ModelMapper modelMapper, ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.publisher = publisher;
    }

    @GetMapping("/registration")
    public String getReg(){
        return "user/registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestBody @Valid UserRegistrationRequest userRequest, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("errors",errors);
            return "user/registration";
        }
        UserDTO userDTO = modelMapper.map(userRequest, UserDTO.class);
        User user = userService.save(userDTO);
        publisher.publishEvent(new RegistrationEvent(user));
        return "redirect:/registration";
    }
}
