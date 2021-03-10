package ru.kpfu.itis.demo.schedule.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void async() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Hello async");
    }

    public void sync() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Hello sync");
    }
}
