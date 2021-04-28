package com.premiumtechs.chirkut;

public class Message {
    private String message;
    private String messageId;
    private String messages;
    private String messageDateTime;
    private String media;
    private String links;
    private String docs;

    public Message(String message, String messageId, String messages, String messageDateTime) {
        this.message = message;
        this.messageId = messageId;
        this.messages = messages;
        this.messageDateTime = messageDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", messageId='" + messageId + '\'' +
                ", messages='" + messages + '\'' +
                ", messageDateTime='" + messageDateTime + '\'' +
                ", media='" + media + '\'' +
                ", links='" + links + '\'' +
                ", docs='" + docs + '\'' +
                '}';
    }
}
