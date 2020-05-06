package ru.kpfu.itis.demo.blog.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kpfu.itis.demo.blog.rest.mock.MockProxy;

class DemoBlogRestApplicationTests {

    @Test
    void contextLoads() {
        TestCustomMock mock = (TestCustomMock) MockProxy.mock(TestCustomMock.class);
        MockProxy.when(mock.hello()).thenReturn("Hello World");

        System.out.println(mock.hello());
        MockProxy.when(mock.hello()).thenReturn("Hello World 2");
        System.out.println(mock.hello());

        MockProxy.when(mock.hello("World")).thenReturn("Hello World!");
        System.out.println(mock.hello("World"));
        MockProxy.when(mock.hello("Java")).thenReturn("Bye World!");
        System.out.println(mock.hello("Java"));
        System.out.println(mock.hello("Java"));
        System.out.println(mock.hello("World"));


    }

    public static interface TestCustomMock{
        public String hello();
        public String hello(String name);
    }
}
