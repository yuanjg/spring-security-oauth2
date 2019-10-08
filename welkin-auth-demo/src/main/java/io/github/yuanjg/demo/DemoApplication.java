package io.github.yuanjg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author yuanjg
 * @create 2019-10-06 8:17
 */


@SpringBootApplication
@ComponentScan("io.github.yuanjg")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

