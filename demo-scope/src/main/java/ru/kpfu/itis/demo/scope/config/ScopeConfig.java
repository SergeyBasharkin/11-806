package ru.kpfu.itis.demo.scope.config;

import org.dummycreator.DummyCreator;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.kpfu.itis.demo.scope.printer.Color;
import ru.kpfu.itis.demo.scope.printer.ConsolePrinter;

import java.util.Random;

@Configuration
public class ScopeConfig {


//   Первый вариант с внедрением ApplicationContext в ConsolePrinter. (плохой, так как класс зависит от целого контекста)
//    1. Внедряем ApplicationContext
//    2. Через getBean постоянно достаем новый экземпляр Color, так как Scope(prototype)
//    3. Profit
//    @Bean
//    public ConsolePrinter consolePrinter(ApplicationContext context) {
//        return new ConsolePrinter(context, new DummyCreator().create(String.class));
//    }

//   Второй вариант через proxyMode. (получше, но всё ещё плохо, так как при каждом обращении к полю будет вытаскиваться новый экземпляр)
//    1. Ставим proxyMode=TARGET_CLASS
//    2. Внедряем Color в ConsolePrinter
//    3. Profit
//    @Bean
//    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public Color color() {
//        return new Color(
//                AnsiColor.values()[
//                        new Random().nextInt(AnsiColor.values().length)
//                        ]
//        );
//    }

    @Bean
    @Scope("counted")
    public Color color() {
        return new Color(
                AnsiColor.values()[
                        new Random().nextInt(AnsiColor.values().length)
                        ]
        );
    }

//    Третий вариант через lookup метод. (идеально)
//    1. Делаем класс и метод абстрактными
//    2. Переопределяем метод на "достань из контекста"
//    3. Profit
    @Bean
    public ConsolePrinter consolePrinter() {
        return new ConsolePrinter(color(), new DummyCreator().create(String.class));
    }



}
