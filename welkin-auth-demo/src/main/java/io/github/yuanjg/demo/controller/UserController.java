package io.github.yuanjg.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author yuanjg
 * @create 2019-10-06 8:20
 */


@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello,World";
    }
}

