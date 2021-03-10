package ru.kpfu.itis.demo.schedule.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DemoScheduler {

    @Scheduled(fixedDelay = 1000)
    public void schedule() throws InterruptedException {
//        System.out.println(LocalTime.now());
        Thread.sleep(3000);
    }
}
