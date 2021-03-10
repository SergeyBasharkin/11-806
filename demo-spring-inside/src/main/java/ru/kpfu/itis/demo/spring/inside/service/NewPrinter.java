package ru.kpfu.itis.demo.spring.inside.service;

import org.springframework.stereotype.Component;

@Component
public class NewPrinter implements IPrinter {
    @Override
    public void print() {
        System.out.println("I AM NEW PRINTER");
    }
}
