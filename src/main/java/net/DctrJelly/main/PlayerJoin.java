package net.DctrJelly.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public PlayerJoin(Main main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		giveItems(player);
	}
	
	public void giveItems(Player player){
		player.getInventory().clear();
		player.getInventory().setItem(0, PluginSettings.Selector);
	}

}
