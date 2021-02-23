package com.example.demo;

import com.example.demo.demain.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")
public class HelloController {


    private static final String template = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/")
    public Person index() {
        return new Person(counter.incrementAndGet(), String.format(template, "Rob"));
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/hello")
    public Object PostHello(@RequestBody() String name) {
        System.out.println(String.format("Post API for %s!", name));

        Person person = new Person();
        person.setName(name);
        return person;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password) {
        if (userName.equals("zhangshan") && password.equals("111111")) {
            return "恭喜你登录成功";
        } else
            return "用户名或密码错误";
    }

}