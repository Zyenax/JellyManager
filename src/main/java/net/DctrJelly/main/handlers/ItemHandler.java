package net.DctrJelly.main.handlers;

import net.DctrJelly.main.Main;
import net.DctrJelly.main.PluginSettings;
import net.DctrJelly.main.menus.RealmMenu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ItemHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public ItemHandler(Main hub) {
		this.plugin = hub;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void gamemenu(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if(e.getHand() == EquipmentSlot.HAND){
				if (e.getPlayer().getItemInHand().equals(PluginSettings.Selector)) {
					//ACTION GOES HERE
					RealmMenu.Menu(e.getPlayer());
				}
			}
		}
	}
}