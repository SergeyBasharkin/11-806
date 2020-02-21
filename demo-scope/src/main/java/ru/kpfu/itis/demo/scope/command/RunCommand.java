package ru.kpfu.itis.demo.scope.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.scope.printer.ConsolePrinter;

@Component
public class RunCommand implements CommandLineRunner {

    private final ConsolePrinter printer;

    public RunCommand(ConsolePrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            printer.print();
            Thread.sleep(500);
        }
    }
}
