package ru.kpfu.itis.demo.spring.inside.service;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.spring.inside.annotation.DeprecatedClass;
import ru.kpfu.itis.demo.spring.inside.annotation.InjectRandomInt;

import javax.annotation.PostConstruct;

@Component
@DeprecatedClass(newClass = NewPrinter.class)
public class Printer implements IPrinter {

    @InjectRandomInt(min = 5, max = 15)
    private int randomInt;

    @PostConstruct
    public void init(){
//        System.out.println(randomInt);
//        print();
    }

    public void print() {
        for (int i = 0; i < randomInt; i++) {
            System.out.println("Hello");
        }
    }
}
