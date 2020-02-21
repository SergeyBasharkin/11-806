package ru.kpfu.itis.demo.scope.printer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.ansi.AnsiColor;

@Data
@AllArgsConstructor
public class Color {
    private AnsiColor color;
}
