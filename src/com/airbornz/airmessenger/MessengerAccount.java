package com.airbornz.airmessenger;

import com.airbornz.airmessenger.events.MessageSentEvent;

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
    private List<Message> message = new ArrayList<>();

    protected MessengerAccount(UUID owner, List<Message> message) {
        this.owner = owner;
        this.message = message;
    }

    public UUID getOwner() {
        return owner;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void sendMail(Message message){
        MessageSentEvent event = new MessageSentEvent(message, false);
        if (!event.isCancelled())
            this.message.add(message);
    }

    public void sendMail(Message message, boolean force){
        MessageSentEvent event = new MessageSentEvent(message, false);
        this.message.add(message);
    }
}
