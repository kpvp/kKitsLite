package us.kpvpdev.kkitslite.commands;

import org.bukkit.command.CommandExecutor;

import us.kpvpdev.kkitslite.kKitsLite;
import us.kpvpdev.kkitslite.commands.kits.*;
import us.kpvpdev.kkitslite.commands.misc.Refill;

public enum Commands {

	PVP("pvp", new PvP()),
	ARCHER("archer", new Archer()),
	TANK("tank", new Tank()),
	REFILL("refill", new Refill()),
	KKITSLITE("kkitslite", new us.kpvpdev.kkitslite.commands.misc.kKitsLite());

	private String name;
	private CommandExecutor exec;

	private Commands(String name, CommandExecutor exec) {
		this.name = name;
		this.exec = exec;
	}

	public String getName() {
		return name;
	}

	public CommandExecutor getExecutor() {
		return exec;
	}

	public static void registerCommands() {
		for(Commands cmd : values()) {
			kKitsLite.getInstance().getCommand(cmd.getName()).setExecutor(cmd.getExecutor());
		}
	}

}