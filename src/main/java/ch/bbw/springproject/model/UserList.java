package ch.bbw.springproject.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
@Scope("singleton")
public class UserList {
    private final List<UUID> users;

    public UserList() {
        this.users = new LinkedList<>();
    }

    public List<UUID> getUsers() {
        return users;
    }

    public void addUser(UUID user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }
}
