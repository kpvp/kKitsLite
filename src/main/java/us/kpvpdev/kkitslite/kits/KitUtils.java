package us.kpvpdev.kkitslite.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import us.kpvpdev.kkitslite.utils.Chat;

public abstract class KitUtils {

	public void clear(Player player) {
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);

		for(PotionEffect pot : player.getActivePotionEffects()) {
			player.removePotionEffect(pot.getType());
		}
	}

	public ItemStack addEnchant(ItemStack item, Enchantment enchant, int level) {
		item.addUnsafeEnchantment(enchant, level);
		return item;
	}

	public void addSoop(Player player) {
		for(int i = 0; i < 27; i++) {
			player.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		}
	}

	public void setKit(Player player, String kit) {
		Chat.sendMessage(player, "You've chosen the " + kit + " kit!");
	}

	public abstract void giveKit(Player player);

}