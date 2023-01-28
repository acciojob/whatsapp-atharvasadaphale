package com.driver;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class WhatsappService {
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, Group> groups = new HashMap<>();
    private HashMap<Integer, Message> messages = new HashMap<>();
    private int messageId = 1;

    public String createUser(String name, String mobileNumber) throws Exception {
        if (users.containsKey(mobileNumber)) {
            throw new Exception("Mobile number already exists");
        }
        User user = new User(name, mobileNumber);
        users.put(mobileNumber, user);
        return name;
    }

    public Group createGroup(List<User> userList) throws Exception {
        if (userList.size() < 2) {
            throw new Exception("Group must have at least 2 users");
        }
        User admin = userList.get(0);
        if (admin.getGroup() != null) {
            throw new Exception("Admin already belongs to a group");
        }
        String groupName;
        if (userList.size() == 2) {
            groupName = userList.get(1).getName();
        } else {
            groupName = "Group " + (groups.size() + 1);
        }
        Group group = new Group(groupName, admin);
        for (User user : userList) {
            if (user.getGroup() != null) {
                throw new Exception("User already belongs to a group");
            }
            user.setGroup(group);
            group.addUser(user);
        }
        groups.put(groupName, group);
        return group;
    }

    public int createMessage(String content) {
        LocalDateTime timestamp = LocalDateTime.now();
        Message message = new Message(messageId, content, timestamp);
        messages.put(messageId, message);
        messageId++;
        return 0;
    }

    public int sendMessage(Message message, User sender, Group group) throws Exception {
        if (!groups.containsValue(group)) {
            throw new Exception("Group does not exist");
        }
        if (!group.getUsers().contains(sender)) {
            throw new Exception("Sender is not a member of the group");
        }
        group.addMessage(message);
        return group.getMessages().size();
    }

    public String changeAdmin(User approver, User user, Group group) throws Exception {
        if (!groups.containsValue(group)) {
            throw new Exception("Group does not exist");
        }
        if (!Objects.equals(group.getAdmin(),approver)) {
            throw new Exception("Approver is not the current admin of the group");
        }
        if (!group.getUsers().contains(user)) {
            throw new Exception("User is not a part of the group");
        }
        group.setAdmin(user);
        return "SUCCESS";
    }

    public String removeUser(String userName) {
        User user = users.get(userName);
        if (user == null) {
            throw new IllegalArgumentException("User not found in any group");
        }
        Group group = groups.get(user.getGroupName());
        if (Objects.equals(group.getAdmin(), userName)) {
            throw new IllegalArgumentException("Cannot remove admin from group");
        }
        group.getUsers().remove(userName);
        group.setNumUsers(group.getNumUsers()-1);
        int numGroupMessages = 0;
        int numAllMessages = messages.size();
        for (Message message : messages.values()) {
            if (message.getGroupName().equals(group.getGroupName())) {
                if (message.getSender().equals(userName)) {
                    messages.remove(message.getMessageId());
                    numGroupMessages--;
                }
            }
        }
        if (group.getNumUsers()<=1) {
            groups.remove(group.getGroupName());
        }
        return "SUCCESS: " + group.getNumUsers() + " " + numGroupMessages + " " + numAllMessages;
    }

    public String findMessage(Date start, Date end, int k) {
        return null;
    }
}