package ru.kpfu.itis.demo.blog.rest.mock;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MockInvocationHandler implements InvocationHandler {

    private List<DataHolder> dataHolderList = new ArrayList<>();
    private Method lastMethod;
    private Object[] lastArgs;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        lastMethod = method;
        lastArgs = args;
        MockProxy.lastInvocationHandler = this;

        Optional<DataHolder> any = dataHolderList.stream()
                .filter(dataHolder -> dataHolder.getMethod().equals(lastMethod) && Arrays.deepEquals(dataHolder.getArgs(), lastArgs))
                .findAny();

        return any.map(DataHolder::getReturnObject).orElse(null);
    }

    public void setReturnObject(Object returnObject) {

        Optional<DataHolder> any = dataHolderList.stream()
                .filter(dataHolder -> dataHolder.getMethod().equals(lastMethod) && Arrays.deepEquals(dataHolder.getArgs(), lastArgs))
                .peek(dataHolder -> dataHolder.setReturnObject(returnObject))
                .findAny();

        if (!any.isPresent()) dataHolderList.add(new DataHolder(lastMethod, lastArgs, returnObject));

    }
}
