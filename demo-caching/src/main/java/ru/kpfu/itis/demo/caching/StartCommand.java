package ru.kpfu.itis.demo.caching;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StartCommand implements CommandLineRunner {

    private final TestService testService;

    public StartCommand(TestService testService) {
        this.testService = testService;
    }

    @Override
    public void run(String... args) throws Exception {


        log.info(testService.hello("1"));
        log.info(testService.hello("2"));

        log.info(testService.hello("1"));
        log.info(testService.hello("2"));

        testService.clear("2");

        log.info(testService.hello("1"));
        log.info(testService.hello("2"));


        log.info(testService.helloPut("TestPut"));
        log.info(testService.helloPut("TestPut"));
        log.info(testService.hello("TestPut"));

//        log.info(testService.hello());
//        log.info(testService.hello());
//        log.info(testService.hello());
//        log.info(testService.hello());

        for (int i = 0; i < 3; i++) {
//            log.info(testService.hello());
            log.info(testService.hello(String.valueOf(i)));
        }

        for (int i = 0; i < 3; i++) {
//            log.info(testService.hello());
            log.info(testService.hello(String.valueOf(i)));
        }

        testService.clearAll();

        for (int i = 0; i < 3; i++) {
//            log.info(testService.hello());
            log.info(testService.hello(String.valueOf(i)));
        }
    }
}
