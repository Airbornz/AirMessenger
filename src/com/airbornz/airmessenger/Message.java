package com.airbornz.airmessenger;

import java.util.UUID;

/**
 * @author Airbornz
 * @project AirMail
 * @date 8/2/2016
 */
public class Message {

    private UUID recipient;
    private String sender;
    private String message;
    private boolean read;
    private long sentTime;

    protected Message(UUID recipient, String sender, String message) {
        this.recipient = recipient;
        this.sender = sender;
        this.message = message;
        this.sentTime = System.currentTimeMillis();
    }

    public UUID getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public long getSentTimeMillis(){
        return sentTime;
    }
}
