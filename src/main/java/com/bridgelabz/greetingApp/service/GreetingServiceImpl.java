package com.bridgelabz.greetingApp.service;

import com.bridgelabz.greetingApp.model.Greeting;
import com.bridgelabz.greetingApp.model.User;
import com.bridgelabz.greetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

// Business logic
@Service
public class GreetingServiceImpl implements IGreetingService {
    private static final String template = "Hello, %s %s!";
    private final AtomicLong counter = new AtomicLong();
    private static long count = 1;

    @Autowired
    private GreetingRepository repository;

    @Override
    public Greeting addGreeting(User user) {
        String firstName = user.getFirstName() != null ? user.getFirstName() : "World";
        String lastName = user.getLastName() != null ? user.getLastName() : "";
        String message = String.format(template, firstName, lastName);
        Greeting greeting = new Greeting(message);
        return repository.save(greeting);
    }

    @Override
    public Greeting getSimpleGreeting() {
        Greeting greeting = new Greeting("Hello World");
        return repository.save(greeting);
    }

    @Override
    public Greeting giveGreeting(User user) {
        String message;

        // Logic for deciding greeting message
        boolean hasFirst = user.getFirstName() != null && !user.getFirstName().isBlank();
        boolean hasLast = user.getLastName() != null && !user.getLastName().isBlank();

        if (hasFirst && hasLast) {
            message = "Hello " + user.getFirstName() + " " + user.getLastName();
        } else if (hasFirst) {
            message = "Hello " + user.getFirstName();
        } else if (hasLast) {
            message = "Hello " + user.getLastName();
        } else {
            message = "Hello World";
        }

        return new Greeting(count++, message);
    }
}
