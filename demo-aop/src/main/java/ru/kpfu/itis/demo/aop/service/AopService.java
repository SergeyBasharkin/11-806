package ru.kpfu.itis.demo.aop.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.aop.aspect.DemoBefore;

@Service
public class AopService {

    public void hello(){
        System.out.println("Hello from service method");
    }

    public String helloStr(){
        return "Hello from service";
    }

    public String sayHello(String name){
        return "Hello " + name;
    }

    @DemoBefore
    public void helloWorld(){
        System.out.println("Hello World");
    }
}
