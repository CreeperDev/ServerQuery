package me.machnikowski.ServerQuery;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;



public class ServerQuery extends JavaPlugin implements Listener{
	
	SettingsManager settings = SettingsManager.getInstance();
	FileConfiguration config;
	File cfile;
	
	//Enable setup
	@Override
	public void onEnable(){
		settings.setup(this);
		Bukkit.getServer().getLogger().info("[ServerQuery] is ready to use!");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getCommand("sq").setExecutor(new CommandSQ(this));
		getCommand("q").setExecutor(new CommandQ(this));
	}
	//Chat setup
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		if(e.getMessage().equalsIgnoreCase("owner")){
			e.getPlayer().sendMessage(ChatColor.AQUA + "The owner is " + getConfig().getString("Owner") + "!");
		}else if(e.getMessage().equalsIgnoreCase("twitter")){
			e.getPlayer().sendMessage(ChatColor.AQUA + "The twitter account is " + getConfig().getString("Twitter"));
		}else if(e.getMessage().equalsIgnoreCase("facebook")){
			e.getPlayer().sendMessage(ChatColor.AQUA + "The Facebook account is " + getConfig().getString("Facebook"));
		}else if(e.getMessage().equalsIgnoreCase("website")){
			e.getPlayer().sendMessage(ChatColor.AQUA + " This servers website is " + getConfig().getString("Website"));
		}else if(e.getMessage().equalsIgnoreCase("member")){
			e.getPlayer().sendMessage(ChatColor.AQUA + getConfig().getString("Member"));
		}
	}
	//@Player join
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		e.getPlayer().sendMessage(ChatColor.AQUA + "This server uses ServerQuery Please use /sq help for a list of commands!");
	}
	//Disable setup
	@Override
	public void onDisable(){
		Bukkit.getServer().getLogger().info(getDescription().getName() + " is now disabled!");
	}
}
