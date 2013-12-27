package me.machnikowski.ServerQuery;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;



public class ServerQuery extends JavaPlugin{
	
	SettingsManager settings = SettingsManager.getInstance();
	FileConfiguration config;
	File cfile;
	
	//Enable setup
	@Override
	public void onEnable(){
		settings.setup(this);
		Bukkit.getServer().getLogger().info("[ServerQuery] is ready to use!");
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getCommand("sq").setExecutor(new CommandSQ(this));
		getCommand("q").setExecutor(new CommandQ(this));
	}
	//Disable setup
	@Override
	public void onDisable(){
		Bukkit.getServer().getLogger().info(getDescription().getName() + " is now disabled!");
	}
}
