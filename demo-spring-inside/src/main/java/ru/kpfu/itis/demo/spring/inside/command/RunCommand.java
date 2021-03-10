package ru.kpfu.itis.demo.spring.inside.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.kpfu.itis.demo.spring.inside.service.IPrinter;
import ru.kpfu.itis.demo.spring.inside.service.Printer;

@Component
public class RunCommand implements CommandLineRunner {
    private final IPrinter printer;

    public RunCommand(IPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run(String... args) throws Exception {
        printer.print();
    }
}
