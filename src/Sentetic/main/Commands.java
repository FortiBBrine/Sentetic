package Sentetic.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
	private Sentetic plugin;
	public Commands(Sentetic plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!sender.hasPermission("sentetic.reload")) {
			sender.sendMessage("[Sentetic] You don't have permissions!");
			return true;
		}
		if (args[0].equals("reload") && sender.hasPermission("sentetic.reload")) {
			plugin.reloadConfig();
			sender.sendMessage("[Sentetic] Successfully reload!");
			return true;
		}
		return false;
	}

}
