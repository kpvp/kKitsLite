package us.kpvpdev.kkitslite;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import us.kpvpdev.kkitslite.commands.Commands;
import us.kpvpdev.kkitslite.listeners.PlayerListener;
import us.kpvpdev.kkitslite.utils.Config;

public class kKitsLite extends JavaPlugin {

    @Override
    public void onEnable() {
        kkitslite = this;

        Commands.registerCommands();
        Config.setupConfig(this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        kkitslite = null;
    }

    private static kKitsLite kkitslite;

    public static kKitsLite getInstance() {
        return kkitslite;
    }

}