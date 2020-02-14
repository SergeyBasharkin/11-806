package ru.kpfu.itis.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.repository.DemoRepository;

//@Service
@Slf4j
public class DemoService {

    private final DemoRepository repository;

    public DemoService(DemoRepository repository) {
        this.repository = repository;
    }
//
//    public DemoService(DemoRepository repository){
//        this.repository = repository;
//    }

    public void run(){
        log.info("Hello from service");
        repository.run();
    }

}
