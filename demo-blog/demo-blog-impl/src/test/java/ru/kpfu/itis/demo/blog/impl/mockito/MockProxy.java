package ru.kpfu.itis.demo.blog.impl.mockito;

import java.lang.reflect.Proxy;

public class MockProxy {

    static MyInvocationHandler myInvocationHandler;

    public static <T> T mock(Class<T> c){
        return (T) Proxy.newProxyInstance(
                MockProxy.class.getClassLoader(),
                new Class[]{c},
                new MyInvocationHandler()
        );
    }

    public static When when(Object o){
        return new When();
    }

    public static class When{
        public void thenReturn(Object o){
            myInvocationHandler.setReturnObject(o);
        }
    }
}
