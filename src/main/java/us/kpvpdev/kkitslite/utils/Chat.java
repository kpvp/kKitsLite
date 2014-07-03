package us.kpvpdev.kkitslite.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Chat {

    public static void sendMessage(CommandSender obj, String msg) {
        obj.sendMessage(color("&ckKitsLite >&f " + msg));
    }

    public static void noKitPerms(CommandSender obj, String kit) {
        sendMessage(obj, "You don't have access to the " + kit + " kit!");
    }
    
    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
