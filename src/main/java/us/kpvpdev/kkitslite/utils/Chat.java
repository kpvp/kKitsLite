package us.kpvpdev.kkitslite.utils;

import org.bukkit.command.CommandSender;

public class Chat {

    public static void sendMessage(CommandSender obj, String msg) {
        obj.sendMessage("§ckKitsLite >§f " + msg);
    }

    public static void noKitPerms(CommandSender obj, String kit) {
        sendMessage(obj, "You don't have access to the " + kit + " kit!");
    }

}
