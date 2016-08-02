package com.airbornz.airmessenger.events;

import com.airbornz.airmessenger.Message;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author Airbornz
 * @project AirMail
 * @date 8/2/2016
 */
public class MessageSentEvent extends Event implements Cancellable {

    private boolean cancelled = false;
    private Message message;
    private boolean forced;

    private static final HandlerList handlers = new HandlerList();

    public MessageSentEvent(Message message, boolean forced){
        this.message = message;
        this.forced = forced;
    }

    public Message getMessage(){
        return message;
    }

    public boolean wasForced(){
        return forced;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        if (forced && b)
            Bukkit.getLogger().warning("Trying to cancel forced message to "+Bukkit.getPlayer(message.getRecipient()).getName());
        if (!forced)
            this.cancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
