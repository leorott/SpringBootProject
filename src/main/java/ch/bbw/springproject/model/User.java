package ch.bbw.springproject.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Component
@SessionScope
public class User {
    private final UUID id;

    public User() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
