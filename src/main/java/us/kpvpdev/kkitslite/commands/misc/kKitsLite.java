package us.kpvpdev.kkitslite.commands.misc;

import org.bukkit.command.*;

import us.kpvpdev.kkitslite.utils.Chat;
import us.kpvpdev.kkitslite.utils.Config;

public class kKitsLite implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            Chat.sendMessage(sender, "kKitsLite plugin coded by CakePvP + AeroPvP");
            Chat.sendMessage(sender, "  * PvP Usage: /pvp");
            Chat.sendMessage(sender, "  * Archer Usage: /archer");
            Chat.sendMessage(sender, "  * Tank Usage: /tank");
            Chat.sendMessage(sender, "Full version plugin @ kitpvp.eu");
        }
        else if(args.length >= 1) {
            if(args[0].equalsIgnoreCase("reload") && sender.isOp()) {
                Config.loadConfig();
                Chat.sendMessage(sender, "Reloaded config");
            }
            else {
                Chat.sendMessage(sender, "You can't use this!");
            }
        }

        return true;
    }

}