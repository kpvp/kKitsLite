package us.kpvpdev.kkitslite.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import us.kpvpdev.kkitslite.utils.Chat;

public abstract class KitUtils {

    /**
     * Clears the player's inventory and removes any active potion effects.
     *
     * @param player 
     */
    public void clear(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        for(PotionEffect pot : player.getActivePotionEffects()) {
            player.removePotionEffect(pot.getType());
        }
    }

    /**
     * Adds an enchantment to the item specified.
     *
     * @param item      ItemStack to enchant
     * @param enchant   enchantment to add to the item
     * @param level     level at which the item should be enchanted to
     * @return          the enchanted ItemStack
     */
    public ItemStack addEnchant(ItemStack item, Enchantment enchant, int level) {
        item.addUnsafeEnchantment(enchant, level);
        return item;
    }

    /**
     * Adds 27 soup to the player's inventory.
     *
     * @param player 
     */
    public void addSoop(Player player) {
        for(int i = 0; i < 27; i++) {
            player.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
        }
    }

    /**
     * Notifies the player about which kit they've chosen.
     *
     * @param player
     * @param kit
     */
    public void setKit(Player player, String kit) {
        Chat.sendMessage(player, "You've chosen the " + kit + " kit!");
    }

    public abstract void giveKit(Player player);

}