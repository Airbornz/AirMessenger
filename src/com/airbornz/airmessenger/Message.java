package com.airbornz.airmessenger;

import java.util.UUID;

/**
 * @author Airbornz
 * @project AirMail
 * @date 8/2/2016
 */
public class Message {

    private UUID recipient;
    private String sender, subject, message;
    private boolean read;
    private long sentTime;

    /**
     * Create a new message.
     * @param recipient The recipient of the message.
     * @param sender The sender of the message.
     * @param subject The subject of the message.
     * @param message The message string.
     */
    public Message(UUID recipient, String sender, String subject, String message) {
        this.recipient = recipient;
        this.sender = sender;
        this.subject = subject;
        this.message = message;
        this.sentTime = System.currentTimeMillis();
    }

    /**
     * Get who the message was sent to.
     * @return The UUID of the recipient.
     */
    public UUID getRecipient() {
        return recipient;
    }

    /**
     * Get who sent the message.
     * If it is a player, returns the UUID as a String.
     * @return The sender of the message.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Get the subject of the message.
     * @return The subject of the message.
     */
    public String getSubject(){
        return subject;
    }

    /**
     * Get the message that was sent.
     * @return The message that was sent.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get if the message was read or not.
     * @return If the message was read or not.
     */
    public boolean isRead() {
        return read;
    }

    /**
     * Set if the message was read or not.
     * @param read The new read status.
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    /**
     * Get the time the message was sent in millis.
     * @return The time in millis the message was sent.
     */
    public long getSentTimeMillis(){
        return sentTime;
    }
}
