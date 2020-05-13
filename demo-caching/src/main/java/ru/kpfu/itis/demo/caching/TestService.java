package ru.kpfu.itis.demo.caching;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {
//
//    @SneakyThrows
//    @Cacheable("hello")
//    public void hello(){
//        Thread.sleep(2000);
//        log.info("Hello");
//    }
//

    @Cacheable("helloCache")
    @SneakyThrows
    public String hello(){
        Thread.sleep(2000);
        return "Hello";
    }

    @SneakyThrows
    @Cacheable("helloCache")
    public String hello(String name){
        Thread.sleep(2000);
        return "Hello " + name;
    }

    @SneakyThrows
    @CachePut("helloCache")
    public String helloPut(String name){
        Thread.sleep(2000);
        return "Hello " + name;
    }

    @SneakyThrows
    @CacheEvict(cacheNames = "helloCache", allEntries = true)
    public void clearAll(){
        log.info("cache cleared");
    }

    @SneakyThrows
    @CacheEvict(cacheNames = "helloCache")
    public void clear(String name){}
}
