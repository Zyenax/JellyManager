package net.DctrJelly.main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.DctrJelly.main.handlers.ItemHandler;
import net.DctrJelly.main.menus.RealmMenu;
import net.DctrJelly.main.utils.BungeeUtil;
import net.DctrJelly.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Main extends JavaPlugin implements Listener, PluginMessageListener{
	
	public static String GetServer;
	public static String[] serverList;

    public void onEnable() {
    	registerListeners();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(Utils.color("&aPlugin has been enabled!"));
        Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
    }
    
    public void registerListeners(){
    	PluginManager manager = Bukkit.getPluginManager();
    	manager.registerEvents(new PlayerJoin(this), this);
    	manager.registerEvents(new Utils(this), this);
    	manager.registerEvents(new PluginSettings(this), this);
    	manager.registerEvents(new ItemHandler(this), this);
    	manager.registerEvents(new RealmMenu(this), this);
    	manager.registerEvents(new BungeeUtil(this), this);
    }

    public void onDisable() {
    	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    	console.sendMessage(Utils.color("&cPlugin has been disabled!"));
    }
    
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	    if (!channel.equals("BungeeCord")) {
	      return;
	    }
	    try{
	    	DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		    String subchannel = in.readUTF();
	    if (subchannel.equals("PlayerCount")) {
	    	String PlayerCountServer = in.readUTF();
	    	Integer playercount = in.readInt();
	    	BungeeUtil.PlayerCount.remove(PlayerCountServer);
	    	BungeeUtil.PlayerCount.put(PlayerCountServer, playercount);
        } else if (subchannel.equals("GetServers")) {
        	serverList = in.readUTF().split("\n");
        } else if (subchannel.equals("GetServer")) {
            // Example: GetServer subchannel
        	GetServer = in.readUTF();
        }
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	  }

}
