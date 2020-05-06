package ru.kpfu.itis.demo.blog.impl.mockito;

import org.junit.jupiter.api.Test;

public class TestMyMock {

    @Test
    public void testMock(){
        TestInterface testInterface = MockProxy.mock(TestInterface.class);

        MockProxy.when(testInterface.hello()).thenReturn("Hello World!");

        System.out.println(testInterface.hello());

        MockProxy.when(testInterface.hello()).thenReturn("Hello World! 2");

        System.out.println(testInterface.hello());

        System.out.println(testInterface.hello("Name"));

        MockProxy.when(testInterface.hello("World")).thenReturn("Test");

        System.out.println(testInterface.hello("World"));

        MockProxy.when(testInterface.hello("Test")).thenReturn("World");

        System.out.println(testInterface.hello("Test"));

        System.out.println(testInterface.hello("World"));

        System.out.println(testInterface.hello("Test"));

    }
}
