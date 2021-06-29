package Sentetic.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;


public class Sentetic extends JavaPlugin {
	
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		
		File config = new File(getDataFolder()+File.separator+"config.yml");
		if (!config.exists()) {
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		
		Bukkit.getPluginManager().registerEvents(new Handler(this), this);
		getCommand("sentetic").setExecutor(new Commands(this));
		
		getLogger().info("enabled!");
	}
	
	public void onDisable() {
		getLogger().info("Plugin created with IJustFortiLive");
	}
}
