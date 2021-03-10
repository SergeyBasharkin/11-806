package ru.kpfu.itis.demo.scope.printer;

import org.springframework.boot.ansi.AnsiOutput;

public class ConsolePrinter {

    private Color color;
    private final String text;

    public ConsolePrinter(Color color, String text) {
        this.color = color;
        this.text = text;
    }

    public void print(){
//        color = getColor();
        System.out.println(AnsiOutput.encode(color.getColor()) + text );
//        System.out.println(AnsiOutput.encode(color.getColor()) + text );
    }

//    protected abstract Color getColor();
}
