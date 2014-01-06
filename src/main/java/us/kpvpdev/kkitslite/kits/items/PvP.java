package us.kpvpdev.kkitslite.kits.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import us.kpvpdev.kkitslite.kits.KitUtils;
import us.kpvpdev.kkitslite.utils.Config;

public class PvP extends KitUtils {

	public void giveKit(Player player) {
		clear(player);

		player.getInventory().addItem(Config.pvpHasSharpness ? addEnchant(new ItemStack(Material.DIAMOND_SWORD), Enchantment.DAMAGE_ALL, 1) : new ItemStack(Material.DIAMOND_SWORD));
		player.getInventory().setArmorContents(new ItemStack[] {
			new ItemStack(Material.IRON_BOOTS),
			new ItemStack(Material.IRON_LEGGINGS),
			new ItemStack(Material.IRON_CHESTPLATE),
			new ItemStack(Material.IRON_HELMET)
		});

		if(Config.pvpHasStrength) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
		}

		addSoop(player);
		setKit(player, "PvP");
	}

}