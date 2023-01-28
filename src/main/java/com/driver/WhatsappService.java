package com.driver;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhatsappService {
    WhatsappRepository whatsappRepository = new WhatsappRepository() ;
    public boolean isNewUser(String mobile) {
        return whatsappRepository.isNewUser(mobile);
    }

    public String createUser(String name, String mobile) {
        whatsappRepository.createUser(name, mobile);
        return "SUCCESS";
    }

    public Group createGroup(List<com.driver.User> users) {
        return whatsappRepository.createGroup(users);
    }

    public int createMessage(String content) {
        return whatsappRepository.createMessage(content);
    }

    public int sendMessage(Message message, User sender, Group group) throws Exception {
        return whatsappRepository.sendMessage(message, (com.driver.User) sender, group);
    }

    public String changeAdmin(User approver, User user, Group group) throws Exception {
        return whatsappRepository.changeAdmin((com.driver.User) approver, (com.driver.User) user, group);
    }
}