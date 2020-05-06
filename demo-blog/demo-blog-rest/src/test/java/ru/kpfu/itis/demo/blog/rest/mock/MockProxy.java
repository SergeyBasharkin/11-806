package ru.kpfu.itis.demo.blog.rest.mock;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;

public class MockProxy {

    static MockInvocationHandler lastInvocationHandler;

    public static <T> T mock(Class<T> c){
        return (T) Proxy.newProxyInstance(
                MockProxy.class.getClassLoader(),
                new Class[]{c},
                new MockInvocationHandler()
        );
    }

    public static When when(Object o){
        return new When();
    }

    public static class When {
        public void thenReturn(Object o){
            lastInvocationHandler.setReturnObject(o);
        }
    }
}
