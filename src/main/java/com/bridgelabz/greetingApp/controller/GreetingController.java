package com.bridgelabz.greetingApp.controller;

import com.bridgelabz.greetingApp.model.Greeting;
import com.bridgelabz.greetingApp.model.User;
import com.bridgelabz.greetingApp.repository.GreetingRepository;
import com.bridgelabz.greetingApp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController is a combination of @ResponseBody and @Controller

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    // field injection is not recommended
    // we are checking why not to use?
    // use constructor injection
    @Autowired
    private IGreetingService service;

    @Autowired
    private GreetingRepository greetingRepository;

    // GET: Return a greeting message (with query params)
    @GetMapping("/message")
    public Greeting greet(@RequestParam(defaultValue = "World") String firstName,
                          @RequestParam(defaultValue = "") String lastName) {
        User user = new User(firstName, lastName);
        return service.addGreeting(user);
    }

    // GET: Return all greetings from DB
    @GetMapping("/all")
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }

    // POST: Create a new greeting using JSON request body
    @PostMapping("/create")
    public Greeting createGreeting(@RequestBody User user) {
        return service.addGreeting(user);
    }

    @GetMapping("/hello")
    public Greeting getSimpleGreeting() {
        return service.getSimpleGreeting();
    }

    @GetMapping("/message2")
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        User user = new User(firstName, lastName);
        return service.addGreeting(user);
    }

}
