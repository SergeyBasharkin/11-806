package ru.kpfu.itis.demo.aop.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.aop.service.AopService;

@Component
public class RunCommand implements CommandLineRunner {

    @Autowired
    private AopService aopService;

    @Override
    public void run(String... args) throws Exception {
//        aopService.hello();
//        System.out.println(aopService.helloStr());
        System.out.println(aopService.sayHello("World"));
        aopService.helloWorld();
    }
}
