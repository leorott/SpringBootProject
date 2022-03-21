package ch.bbw.springproject.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@SessionScope
public class MyUserSession {
    public MyUserSession() {
        System.out.println("SessionController --> Constructor is called...");
    }

    @PostConstruct
    public void init() {
        System.out.println(" SessionController --> PostConstruct is called...");
        // injected beans are ready at this point
    }

    @PreDestroy
    public void dispose() {
        System.out.println(" SessionController --> PreDestroy is called...");
    }
}
