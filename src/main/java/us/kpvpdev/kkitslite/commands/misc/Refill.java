package us.kpvpdev.kkitslite.commands.misc;

import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import us.kpvpdev.kkitslite.kKitsLite;
import us.kpvpdev.kkitslite.utils.*;

public class Refill implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player && args.length >= 0) {
            final Player player = (Player)sender;

            if(!Utils.refilling.contains(player.getName())) {
                Utils.refilling.add(player.getName());
                Chat.sendMessage(sender, "Refilling in " + (Config.refillTime) + " seconds...");

                if(Config.refillBenefits) {
                    Chat.sendMessage(sender, "You are weak whilst you refill...");

                    player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Config.refillTime * 20, 4));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Config.refillTime * 20, 4));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, Config.refillTime * 20, 4));
                }

                new BukkitRunnable() {
                    public void run() {
                        for(int i = 0; i < Config.amountOfSoup; i++) {
                            player.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
                        }

                        Chat.sendMessage(player, "Refilled!");
                        Utils.refilling.remove(player.getName());
                    }
                }.runTaskLater(kKitsLite.getInstance(), Config.refillTime * 20);
            } else {
                Chat.sendMessage(sender, "You're already refilling!");
            }

            return true;
        }

        return false;
    }

}