package me.machnikowski.ServerQuery;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent  e){
		e.getPlayer().sendMessage(ChatColor.AQUA + "This server runs ServerQuery use /sq help for help");
	}
}
