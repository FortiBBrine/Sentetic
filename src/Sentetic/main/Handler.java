package Sentetic.main;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;
import java.util.Random;

import org.bukkit.Material;

public class Handler implements Listener {

	private Sentetic plugin;
	public Handler(Sentetic plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		Block b = e.getBlock();
		int x1 = plugin.getConfig().getInt("x1");
		int x2 = plugin.getConfig().getInt("x2");
		int y1 = plugin.getConfig().getInt("y1");
		int y2 = plugin.getConfig().getInt("y2");
		int z1 = plugin.getConfig().getInt("z1");
		int z2 = plugin.getConfig().getInt("z2");
		
		int x = b.getX();
		int y = b.getY();
		int z = b.getZ();
		
		Material bc = Material.getMaterial( plugin.getConfig().getString("block").toUpperCase() );
		if ((x1 <= x && x2 >= x) && (y1 <= y && y2 >= y) && (z1 <= z && z2 >= z) && b.getType() == bc) {
			
			Player player = e.getPlayer();
			
			List<String> configItems = plugin.getConfig().getStringList("items");
			int index = new Random().nextInt(configItems.size());
		
			String items = configItems.get(index);
			ItemStack newItem = new ItemStack(Material.getMaterial(items.toUpperCase()));
			player.getInventory().addItem(newItem);
			player.sendMessage(plugin.getConfig().getString("msg").replace("%item%", items) );
		}

	}

}
