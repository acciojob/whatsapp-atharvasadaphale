package com.driver;

import com.driver.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    private String groupName;
    private User admin;
    private List<User> users;

    Map<Object, Object> messages = new HashMap<>();
    public Group(String groupName, User admin) {
        this.groupName = groupName;
        this.admin = admin;
        this.users = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public User getAdmin() {
        return admin;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public int getNumUsers() {
        return users.size();
    }

    public void addMessage(Message message) {
    }

    public Map<Object, Object> getMessages() {
        return messages;
    }

    public void setAdmin(User user) {
    }

    public void setNumUsers(int i) {
    }
}
