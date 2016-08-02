package com.airbornz.airmessenger.events;

import com.airbornz.airmessenger.Message;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author Airbornz
 * @project AirMail
 * @date 8/2/2016
 */
public class MessageReadEvent extends Event implements Cancellable {

    private boolean cancelled = false;
    private Message message;

    private static final HandlerList handlers = new HandlerList();

    public MessageReadEvent(Message message){
        this.message = message;
    }

    /**
     * Get the message of the event.
     * @return The message of the event.
     */
    public Message getMessage(){
        return message;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
