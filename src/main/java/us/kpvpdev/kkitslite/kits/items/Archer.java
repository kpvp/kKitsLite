package us.kpvpdev.kkitslite.kits.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import us.kpvpdev.kkitslite.kits.KitUtils;
import us.kpvpdev.kkitslite.utils.Config;

public class Archer extends KitUtils {

    public void giveKit(Player player) {
        clear(player);

        if(Config.archerHasSword) {
            player.getInventory().addItem(addEnchant(new ItemStack(Material.STONE_SWORD, 1, Config.archerHasLessDurability ? (short)60 : (short)0), Enchantment.DAMAGE_ALL, 1));
        }

        player.getInventory().addItem(addEnchant(new ItemStack(Material.BOW), Enchantment.ARROW_INFINITE, 1));
        player.getInventory().setItem(9, new ItemStack(Material.ARROW));
        player.getInventory().setArmorContents(new ItemStack[] {
            new ItemStack(Material.LEATHER_BOOTS),
            new ItemStack(Material.IRON_LEGGINGS),
            new ItemStack(Material.GOLD_CHESTPLATE),
            new ItemStack(Material.CHAINMAIL_HELMET)
        });

        if(Config.archerSpeedPotionsEnabled) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, Config.archerSpeedPotionsLevel - 1 >= 0 ? Config.archerSpeedPotionsLevel - 1 : 0));
        }

        if(Config.archerJumpPotionsEnabled) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, Config.archerJumpPotionsLevel - 1 >= 0 ? Config.archerJumpPotionsLevel - 1 : 0));
        }

        addSoop(player);
        setKit(player, "Archer");
    }

}