package ru.kpfu.itis.demo.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoRepository {

    public void run(){
      log.info("Hello from Repo");
    }
}
