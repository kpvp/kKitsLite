package us.kpvpdev.kkitslite.utils;

import org.bukkit.configuration.file.FileConfiguration;

import us.kpvpdev.kkitslite.kKitsLite;

import java.io.File;
import java.io.IOException;

public class Config {

    public static boolean pvpHasStrength, pvpHasSharpness;
    public static boolean archerHasSword, archerHasLessDurability;
    public static boolean archerSpeedPotionsEnabled;
    public static int archerSpeedPotionsLevel;
    public static boolean archerJumpPotionsEnabled;
    public static int archerJumpPotionsLevel;
    public static boolean hungerDisabled, hungerHealOnFullDisable;
    public static boolean canDropItems, canDropsSpawn;
    public static boolean customJoinMessage, customKickMessage, customQuitMessage;
    public static boolean refillBenefits;
    public static int refillTime, amountOfSoup;

    public static void loadConfig() {
        FileConfiguration config = kKitsLite.getInstance().getConfig();

        pvpHasStrength = Boolean.valueOf(config.getBoolean("PvP.hasStrength"));
        pvpHasSharpness = Boolean.valueOf(config.getBoolean("PvP.hasSharpness"));

        archerHasSword = Boolean.valueOf(config.getBoolean("Archer.hasSword"));
        archerHasLessDurability = Boolean.valueOf(config.getBoolean("Archer.lessDurability"));

        archerSpeedPotionsEnabled = Boolean.valueOf(config.getBoolean("Archer.potions.speed.enabled"));
        archerSpeedPotionsLevel = Integer.valueOf(config.getInt("Archer.potions.speed.level"));

        archerJumpPotionsEnabled = Boolean.valueOf(config.getBoolean("Archer.potions.jumpboost.enabled"));
        archerJumpPotionsLevel = Integer.valueOf(config.getInt("Archer.potions.jumpboost.level"));

        hungerDisabled = Boolean.valueOf(config.getBoolean("Hunger.disabled"));
        hungerHealOnFullDisable = Boolean.valueOf(config.getBoolean("Hunger.disableHealOnFull"));

        canDropItems = Boolean.valueOf(config.getBoolean("Drops.canSpawnItems"));
        canDropsSpawn = Boolean.valueOf(config.getBoolean("Drops.canSpawn"));

        customJoinMessage = Boolean.valueOf(config.getBoolean("Messages.customJoin"));
        customKickMessage = Boolean.valueOf(config.getBoolean("Messages.customKick"));
        customQuitMessage = Boolean.valueOf(config.getBoolean("Messages.customQuit"));

        refillBenefits = Boolean.valueOf(config.getBoolean("Refill.benefits"));
        refillTime = Integer.valueOf(config.getInt("Refill.refillTime"));
        amountOfSoup = Integer.valueOf(config.getInt("Refill.amountOfSoup"));
    }

    public static void setupConfig(kKitsLite p) {
        File file = new File(p.getDataFolder(), "config.yml");

        if( ! file.exists()) {
            try {
                FileConfiguration config = kKitsLite.getInstance().getConfig();

                config.set("PvP.hasStrength", false);
                config.set("PvP.hasSharpness", true);

                config.set("Archer.hasSword", true);
                config.set("Archer.lessDurability", true);

                config.set("Archer.potions.speed.enabled", false);
                config.set("Archer.potions.speed.level", 1);

                config.set("Archer.potions.jumpboost.enabled", false);
                config.set("Archer.potions.jumpboost.level", 1);

                config.set("Hunger.disabled", true);
                config.set("Hunger.disableHealOnFull", true);

                config.set("Drops.canDropItems", false);
                config.set("Drops.canSpawn", false);

                config.set("Messages.customJoin", false);
                config.set("Messages.customKick", false);
                config.set("Messages.customQuit", false);

                config.set("Refill.benefits", true);
                config.set("Refill.refillTime", 6);
                config.set("Refill.amountOfSoup", 9);

                config.save(file);
            } catch(IOException e) { }
        }

        loadConfig();
    }

}