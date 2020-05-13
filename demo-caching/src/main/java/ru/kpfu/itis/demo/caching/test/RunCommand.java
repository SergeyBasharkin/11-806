package ru.kpfu.itis.demo.caching.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class RunCommand implements CommandLineRunner {

    private final CacheService cacheService;

    public RunCommand(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public void run(String... args) throws Exception {
       helloInvoke();

       helloInvoke();
       helloInvoke();

       cacheService.clearCache();

       helloInvoke();
       helloInvoke();

       cacheService.clearConcreteCache(String.valueOf(1));

       helloInvoke();
    }

    private void helloInvoke(){
        for (int i = 0; i < 3; i++) {
            log.info(cacheService.hello(String.valueOf(i)));
        }
    }
}
