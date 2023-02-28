package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: fmz200
 * @Date: 2023-02-28 14:39
 */
@SpringBootApplication
@Slf4j
public class QuartzApplication {

    public static void main(String[] args) {
        // springboot运行起来了
        SpringApplication.run(QuartzApplication.class, args);
        log.info("------ springboot Application running ------");
    }
}
