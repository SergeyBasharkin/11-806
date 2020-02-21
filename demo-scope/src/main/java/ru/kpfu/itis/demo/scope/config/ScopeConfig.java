package ru.kpfu.itis.demo.scope.config;

import org.dummycreator.DummyCreator;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import ru.kpfu.itis.demo.scope.printer.Color;
import ru.kpfu.itis.demo.scope.printer.ConsolePrinter;

import java.util.Random;

@Configuration
public class ScopeConfig {

    @Bean
    @Scope(value = "prototype")
    public Color color() {
        return new Color(
                AnsiColor.values()[
                        new Random().nextInt(AnsiColor.values().length)
                        ]
        );
    }

    @Bean
    public ConsolePrinter consolePrinter() {
        return new ConsolePrinter(color(), new DummyCreator().create(String.class)) {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }
//    @Bean
//    public ConsolePrinter consolePrinter(ApplicationContext context) {
//        return new ConsolePrinter(context, new DummyCreator().create(String.class));
//    }

}
