package com.bridgelabz.greetingApp.controller;

import com.bridgelabz.greetingApp.model.UserInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello from BridgeLabz!!";
    }
    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody UserInfo user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + "!";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,
                           @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }
}
