package ru.kpfu.itis.demo.caching.test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
//@Service
public class CacheService {

    @SneakyThrows
    @Cacheable("helloCache")
    public String hello(String name){
        Thread.sleep(2000);
        return "Hello " + name + "!";
    }

    @SneakyThrows
    @CacheEvict(value = "helloCache", allEntries = true)
    public void clearCache(){
        log.info("cache cleared");
    }

    @SneakyThrows
    @CacheEvict(value = "helloCache")
    public void clearConcreteCache(String name){
        log.info("cache cleared " + name);
    }
}
