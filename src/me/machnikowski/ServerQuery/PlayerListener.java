package me.machnikowski.ServerQuery;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	
	private ServerQuery pl;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent  e){
		e.getPlayer().sendMessage(ChatColor.AQUA + "This server runs ServerQuery use /sq help for help");
	}
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		if(e.getMessage().equalsIgnoreCase("owner")){
			e.getPlayer().sendMessage(ChatColor.AQUA + "The Owner is " + pl.getConfig().getString("Owner") + "!");
		}
	}
}
