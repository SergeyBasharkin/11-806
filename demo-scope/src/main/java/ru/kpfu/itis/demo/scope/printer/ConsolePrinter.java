package ru.kpfu.itis.demo.scope.printer;

import org.springframework.boot.ansi.AnsiOutput;

public abstract class ConsolePrinter {

    private final Color color;
    private final String text;

    public ConsolePrinter(Color color, String text) {
        this.color = color;
        this.text = text;
    }

    public void print(){
        System.out.println(AnsiOutput.encode(getColor().getColor()) + text );
    }

    protected abstract Color getColor();
}
