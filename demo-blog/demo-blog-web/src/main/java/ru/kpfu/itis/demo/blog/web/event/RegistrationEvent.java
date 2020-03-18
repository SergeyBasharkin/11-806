package ru.kpfu.itis.demo.blog.web.event;

import org.springframework.context.ApplicationEvent;
import ru.kpfu.itis.demo.blog.web.dto.UserRegistrationRequest;

public class RegistrationEvent extends ApplicationEvent {
    public RegistrationEvent(UserRegistrationRequest source) {
        super(source);
    }
}
