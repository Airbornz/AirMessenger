package com.airbornz.airmessenger;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Airbornz
 * @project AirMail
 * @date 8/2/2016
 */
public class AirMessenger extends JavaPlugin{

    private static List<MessengerAccount> accounts = new ArrayList<>();

    @Override
    public void onEnable(){
        if (accounts != null){
            //TODO GET SAVED EMAIL ACCOUNTS
        }
        //TODO Enable plugin
    }

    @Override
    public void onDisable(){
        //TODO Disable plugin
    }

    public static MessengerAccount getAccount(UUID uuid){
        for (MessengerAccount account : accounts){
            if (account.getOwner().equals(uuid))
                return account;
        }
        MessengerAccount account = new MessengerAccount(uuid, new ArrayList<>());
        accounts.add(account);
        return account;
    }

}
