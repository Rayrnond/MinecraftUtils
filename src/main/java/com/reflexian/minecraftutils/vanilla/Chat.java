package com.reflexian.minecraftutils.vanilla;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;

public class Chat {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static boolean hasPlayed(String name) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(name);
        return player!=null;
    }

}
