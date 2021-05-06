package com.premiumtechs.chirkut;

public class Message {
    private String messageId;
    private String senderId;
    private String recieverId;
    private String messages;
    private String sendTime;
    private String recieveTime;
    private String media;
    private String links;
    private String docs;

    public Message(String messageId, String senderId, String recieverId, String messages, String sendTime,String recieveTime) {
        //this.message = message;
        this.messageId = messageId;
        this.messages = messages;
        this.sendTime = sendTime;
        this.recieveTime=recieveTime;
        this.senderId=senderId;
        this.recieverId=recieverId;
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

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(String recieverId) {
        this.recieverId = recieverId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getRecieveTime() {
        return recieveTime;
    }

    public void setRecieveTime(String recieveTime) {
        this.recieveTime = recieveTime;
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
                ", messageId='" + messageId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", recieverId='" + recieverId + '\'' +
                ", messages='" + messages + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", recieveTime='" + recieveTime + '\'' +
                ", media='" + media + '\'' +
                ", links='" + links + '\'' +
                ", docs='" + docs + '\'' +
                '}';
    }
}
