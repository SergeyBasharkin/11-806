package ru.kpfu.itis.demo.blog.web.event;

import org.springframework.context.ApplicationEvent;
import ru.kpfu.itis.demo.blog.impl.entity.User;

public class RegistrationEvent extends ApplicationEvent {
    public RegistrationEvent(User source) {
        super(source);
    }
}
