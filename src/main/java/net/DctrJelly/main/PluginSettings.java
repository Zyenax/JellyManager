package net.DctrJelly.main;

import java.util.Arrays;

import net.DctrJelly.main.utils.Utils;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PluginSettings implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public PluginSettings(Main hub) {
		this.plugin = hub;
	}
	
	public static ItemStack Selector = Utils.createItem(Material.ENCHANTED_BOOK, 1, 0, Utils.color("&cMenu"), Arrays.asList(Utils.color("hi"), Utils.color("test")));

}
