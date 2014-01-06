package us.kpvpdev.kkitslite.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

import us.kpvpdev.kkitslite.utils.Config;

public class PlayerListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();

		if(player.getItemInHand().getType() == Material.MUSHROOM_SOUP && player.getHealth() <= 20 && player.getHealth() + 1 <= 20) {
			player.setHealth(player.getHealth() + 7 >= player.getMaxHealth() ? 20 : player.getHealth() + 7);
			player.setItemInHand(new ItemStack(Material.BOWL));
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Config.customJoinMessage) {
			e.setJoinMessage("§a[+]§7 " + e.getPlayer().getName() + " connected");
		}
	}

	@EventHandler
	public void onKick(PlayerKickEvent e) {
		if(Config.customJoinMessage) {
			e.setLeaveMessage("§c[-]§7 " + e.getPlayer().getName() + " connected");
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if(Config.customJoinMessage) {
			e.setQuitMessage("§c[-]§7 " + e.getPlayer().getName() + " connected");
		}
	}

	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		if(Config.hungerDisabled) {
			e.setFoodLevel(20);
		}
	}

	@EventHandler
	public void onHealRegain(EntityRegainHealthEvent e) {
		if(e.getEntity() instanceof Player && e.getRegainReason() == RegainReason.SATIATED && Config.hungerHealOnFullDisable) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerItemDrop(PlayerDropItemEvent e) {
		if(!Config.canDropItems) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onItemSpawn(ItemSpawnEvent e) {
		if(!Config.canDropsSpawn) {
			e.setCancelled(true);
		}
	}

}