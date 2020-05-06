package ru.kpfu.itis.demo.blog.impl.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
public class DataHolder {
    private Method method;
    private Object[] args;
    private Object returnValue;
}
