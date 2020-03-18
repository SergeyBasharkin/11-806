package ru.kpfu.itis.demo.blog.web.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.blog.web.dto.UserRegistrationRequest;
import ru.kpfu.itis.demo.blog.web.event.RegistrationEvent;

@Component
public class RegistrationListener implements ApplicationListener<RegistrationEvent> {

    @Async("executor")
    @Override
    public void onApplicationEvent(RegistrationEvent registrationEvent) {
        try {
            Thread.sleep(5000);
            System.out.println(((UserRegistrationRequest)registrationEvent.getSource()).getUsername());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
