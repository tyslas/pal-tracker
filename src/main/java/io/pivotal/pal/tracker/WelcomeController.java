package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    private String WELCOME_MESSAGE;

    public WelcomeController(@Value("${welcome_message}") String welcome_message) {
        this.WELCOME_MESSAGE = welcome_message;
    }

    @GetMapping("/")
    public String sayHello() {
        return WELCOME_MESSAGE;
    }
}
