package com.airbornz.airmessenger;

import com.airbornz.airmessenger.events.MessageSentEvent;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Airbornz
 * @project AirMail
 * @date 8/2/2016
 */
public class MessengerAccount {

    private UUID owner;
    private List<Message> messages = new ArrayList<>();
    private boolean sendReadMessage;

    /**
     * Create a new MessengerAccount.
     * @param owner The owner of the account.
     * @param messages The messages of the account.
     */
    protected MessengerAccount(UUID owner, List<Message> messages) {
        this.owner = owner;
        this.messages = messages;
    }

    /**
     * Get the owner of the account.
     * @return The UUID of the owner of the account.
     */
    public UUID getOwner() {
        return owner;
    }

    /**
     * Get the messages of the account.
     * @return A list of messages of the account.
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Send a message to the account.
     * @param message The message to send.
     */
    public void sendMail(Message message){
        if (message.getRecipient().equals(owner)){
            MessageSentEvent event = new MessageSentEvent(message, false);
            if (!event.isCancelled())
                this.messages.add(message);
        }
        else{
            Bukkit.getLogger().severe("Message to "+Bukkit.getPlayer(owner)+" " +
                    "failed to send. Subject "+message.getSubject()+", sender "+message.getSender());
        }
    }

    /**
     * Send a message to the account.
     * @param message The message to send.
     * @param force Bypass cancellation of the MessageSentEvent.
     *              (Still fires it though) (Also does NOT bypass recipient check!)
     */
    public void sendMail(Message message, boolean force){
        if (message.getRecipient().equals(owner)){
            new MessageSentEvent(message, false);
            this.messages.add(message);
        }
        else{
            Bukkit.getLogger().severe("Message to "+Bukkit.getPlayer(owner)+" " +
                    "failed to send. Subject "+message.getSubject()+", sender "+message.getSender());
        }
    }

    /**
     * Get if the account will update read status.
     * @return If the account will update read status.
     */
    public boolean sendReadMessage() {
        return sendReadMessage;
    }
}
