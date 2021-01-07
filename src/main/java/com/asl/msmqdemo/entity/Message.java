package com.asl.msmqdemo.entity;

/**
 * @author Lance
 * @date 2021/1/7 11:25
 */
public class Message {
    private String content;
    private String messageId;
    private String label;

    public Message() {
    }

    public Message(String content, String messageId, String label) {
        this.content = content;
        this.messageId = messageId;
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
