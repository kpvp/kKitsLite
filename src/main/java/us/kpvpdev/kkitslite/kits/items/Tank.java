package us.kpvpdev.kkitslite.kits.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import us.kpvpdev.kkitslite.kits.KitUtils;

public class Tank extends KitUtils {

    public void giveKit(Player player) {
        clear(player);

        player.getInventory().addItem(addEnchant(new ItemStack(Material.DIAMOND_SWORD), Enchantment.DAMAGE_ALL, 1));
        player.getInventory().setArmorContents(new ItemStack[] {
            new ItemStack(Material.DIAMOND_BOOTS),
            new ItemStack(Material.DIAMOND_LEGGINGS),
            new ItemStack(Material.DIAMOND_CHESTPLATE),
            new ItemStack(Material.DIAMOND_HELMET)
        });

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));

        addSoop(player);
        setKit(player, "Tank");
    }

}
