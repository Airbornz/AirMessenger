package com.airbornz.airmessenger.storage;

import com.airbornz.airmessenger.MessengerAccount;

import java.util.List;
import java.util.UUID;

/**
 * @author Airbornz
 * @project AirMessenger
 * @date 8/2/2016
 */
public interface MessageStorage {

    /**
     * Save the message data of all loaded accounts.
     * @return If the save process was successful.
     */
    boolean saveData();

    /**
     * Save the message data of the specified accounts.
     * @param accounts The accounts to save.
     * @return If the save process was successful.
     */
    boolean saveData(List<MessengerAccount> accounts);

    /**
     * Save the message data of the specified account.
     * @param account The account to save.
     * @return If the save process was successful.
     */
    boolean saveData(MessengerAccount account);

    /**
     * Load the message data of all players, not recommended, unless using messages are
     * being used across multiple platforms, and even still.
     * @return If the data loaded successfully.
     */
    boolean loadData();

    /**
     * Load the message data of a specified user.
     * @param uuid The user's UUID.
     * @return If the data loaded successfully.
     */
    boolean loadData(UUID uuid);

    /**
     * Load the message data of the specified users.
     * @param uuids The user's UUIDs.
     * @return If the data loaded successfully.
     */
    boolean loadData(List<UUID> uuids);

    /**
     * Get all loaded MessengerAccounts.
     * @return All loaded MessengerAccounts.
     */
    List<MessengerAccount> getAllAccounts();

    /**
     * Get the MessengerAccount of the specified user.
     * @param uuid The UUID of the user to get the account of.
     * @return The MessengerAccount linked to the user.
     */
    MessengerAccount getAccount(UUID uuid);

    /**
     * Returns if the message storage automatically checks for updates.
     * @return If the message storage automatically checks for updates.
     */
    boolean supportsAutoSync();

    /**
     * If supportsAutoSync() returns how long between each sync.
     * @return If supportsAutoSync() how long between each sync
     */
    int getSyncSpan();

    /**
     * Get the next time in millis that the storage syncs with its db.
     * @return The next time in millis that the storage syncs with its db.
     */
    long getNextSyncMillis();
}
