package com.example.demo;

import com.example.demo.demain.Person;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/org/{orgId}")
public class PersonController {


    @GetMapping("/persons/{personId}")
    public Object GetPerson(@PathVariable String orgId, @PathVariable String personId, @RequestParam(defaultValue = "Rob") String name) {
        System.out.println(String.format("Hello %s!", name));

        Person person = new Person();
        person.setName(name);
        person.setContent(orgId + ":"+ personId);
        return person;
    }
}