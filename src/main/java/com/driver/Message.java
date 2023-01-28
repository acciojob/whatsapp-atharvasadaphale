package com.driver;

import java.time.LocalDateTime;

public class Message {
    private int id;
    private String content;
    private LocalDateTime timestamp;

    public Message(int id, String content, LocalDateTime timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Object getGroupName() {
        return this.getGroupName();
    }

    public Object getSender() {
        return this.getSender();
    }

    public Integer getMessageId() {
        return this.getMessageId();
    }
}
