package com.example.testspringmvc.model;

import com.example.testspringmvc.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UsersList {

    private List<User> users = new ArrayList<>();

    public UsersList() {
    }

    public UsersList(List<User> users) {
        this.users = users;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUser(User user) {
        this.users.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersList usersList = (UsersList) o;
        return Objects.equals(users, usersList.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
