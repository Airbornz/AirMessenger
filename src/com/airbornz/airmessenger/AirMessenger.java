package com.airbornz.airmessenger;

import com.airbornz.airmessenger.storage.MessageStorage;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Airbornz
 * @project AirMail
 * @date 8/2/2016
 */
public class AirMessenger extends JavaPlugin{

    private static MessageStorage messageStorage;

    @Override
    public void onEnable(){
        //TODO Enable plugin
    }

    @Override
    public void onDisable(){
        //TODO Disable plugin
    }

    /**
     * Get the current MessageStorage.
     * @return The current MessageStorage.
     */
    public static MessageStorage getMessageStorage(){return messageStorage;}

    /**
     * Set the current MessageStorage.
     * Useful if you want to make your own.
     * Inconsistently changing this is not recommended!
     * @param storage The storage to now use.
     */
    public static void setMessageStorage(MessageStorage storage){
        messageStorage.saveData();
        messageStorage = storage;
    }

    /**
     * Set the current MessageStorage.
     * Useful if you want to make your own.
     * Inconsistently changing this is not recommended!
     * @param storage The storage to now use.
     * @param saveData If the current MessageStorage should be saved.
     */
    public static void setMessageStorage(MessageStorage storage, boolean saveData){
        if (saveData)
            messageStorage.saveData();
        messageStorage = storage;
    }

}
