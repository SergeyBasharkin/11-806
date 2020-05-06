package ru.kpfu.itis.demo.blog.impl.mockito;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MyInvocationHandler implements InvocationHandler {
    private List<DataHolder> holders = new ArrayList<>();
    private Method lastMethod;
    private Object[] lastArgs;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        lastArgs = args;
        lastMethod = method;
        MockProxy.myInvocationHandler = this;

        Optional<DataHolder> any = holders.stream()
                .filter(dataHolder -> dataHolder.getMethod().equals(lastMethod) && Arrays.deepEquals(lastArgs, dataHolder.getArgs()))
                .findAny();

        return any.map(DataHolder::getReturnValue).orElse(null);
    }

    public void setReturnObject(Object o) {
        Optional<DataHolder> any = holders.stream()
                .filter(dataHolder -> dataHolder.getMethod().equals(lastMethod) && Arrays.deepEquals(lastArgs, dataHolder.getArgs()))
                .peek(dataHolder -> dataHolder.setReturnValue(o))
                .findAny();

        if (!any.isPresent()) holders.add(new DataHolder(lastMethod, lastArgs, o));
    }
}
