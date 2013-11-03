package me.machnikowski.ServerQuery;

import java.io.File;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;



public class ServerQuery extends JavaPlugin{
	
	SettingsManager settings = SettingsManager.getInstance();
	FileConfiguration config;
	File cfile;
	
	public static Permission perms = null;
	
	//Enable setup
	@Override
	public void onEnable(){
		settings.setup(this);
		Bukkit.getServer().getLogger().info("[ServerQuery] is ready to use!");
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		setupPermissions();
	}
	//Permissions (Vault)
	private boolean setupPermissions(){
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms !=null;
	}
	
	//Commands setup
	public boolean onCommand(CommandSender sender,Command cmd,String commandLabel,String[] args){
		/*/q commands
		 * Basic function commands (heart and soul)
		 */
		if(commandLabel.equalsIgnoreCase("q")){
			if(args.length == 0){
				sender.sendMessage(ChatColor.AQUA + "Please use /sq help!");
				return true;
			}if(args[0].equalsIgnoreCase("website")){
				if(perms.has(sender, "sq.use") || sender.isOp()){
					sender.sendMessage(ChatColor.GREEN + getConfig().getString("Website"));
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}else if(args[0].equalsIgnoreCase("owner")){
				if(perms.has(sender, "sq.use") || sender.isOp()){
					sender.sendMessage(getConfig().getString("Owner"));
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command");
					return true;
				}
			}else if(args[0].equalsIgnoreCase("facebook")){
				if(perms.has(sender, "sq.use") || sender.isOp()){
					sender.sendMessage(ChatColor.GREEN + getConfig().getString("Facebook"));
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To That Command!");
					return true;
				}
			}else if(args[0].equalsIgnoreCase("twitter")){
				if(perms.has(sender, "sq.use") || sender.isOp()){
					sender.sendMessage(ChatColor.GREEN + getConfig().getString("Twitter"));
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}else if(args[0].equalsIgnoreCase("member")){
				if(perms.has(sender, "sq.use") || sender.isOp()){
					sender.sendMessage(ChatColor.GREEN + getConfig().getString("Member"));
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}
		}
		/*/sq commands
		 * Basic admin functions
		 */
		if(commandLabel.equalsIgnoreCase("sq")){
			if(args.length == 0){
				sender.sendMessage(ChatColor.AQUA + "Please use /sq help for a command list!");
				return true;
			    }
		    }if(args[0].equalsIgnoreCase("welcome")){
				if(perms.has(sender, "sq.help") || sender.isOp()){
				sender.sendMessage(ChatColor.AQUA + "Welcome to ServerQuery a new way to get Server information");
				return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}else if(args[0].equalsIgnoreCase("help")){
				if(perms.has(sender, "sq.help") || sender.isOp()){
					sender.sendMessage(ChatColor.AQUA + "******|ServerQuery CommandList|******");
					sender.sendMessage(ChatColor.AQUA + "/sq welcome --> " + ChatColor.DARK_GREEN + "Allows user to see Welcome message.");
					sender.sendMessage(ChatColor.AQUA + "/sq reload --> " + ChatColor.DARK_GREEN + "Allows user to reload configuration.");
					sender.sendMessage(ChatColor.AQUA + "/sq info --> " + ChatColor.DARK_GREEN + "Shows user plugin information");
					sender.sendMessage(ChatColor.DARK_PURPLE + "/q owner --> " + ChatColor.DARK_AQUA + "Shows you the server owners information");
					sender.sendMessage(ChatColor.DARK_PURPLE + "/q website --> " + ChatColor.DARK_AQUA + "Shows you the server website information");
					sender.sendMessage(ChatColor.DARK_PURPLE + "/q facebook --> " + ChatColor.DARK_AQUA + "Shows you server Facebook information");
					sender.sendMessage(ChatColor.DARK_PURPLE + "/q twitter --> " + ChatColor.DARK_AQUA + "Shows you server Twitter information");
					sender.sendMessage(ChatColor.DARK_PURPLE + "/q member --> " + ChatColor.DARK_AQUA + "Shows you how to become a server member");
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}	
			}else if(args[0].equalsIgnoreCase("info")){
				if(perms.has(sender, "sq.info") || sender.isOp()){
					sender.sendMessage(ChatColor.DARK_BLUE + "[" +getDescription().getName()+"] "+getDescription().getVersion()+ " Written by "+getDescription().getAuthors());
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}else if (args[0].equalsIgnoreCase("reload")){
				if(perms.has(sender, "sq.reload") || sender.isOp()){
					settings.reloadConfig();
					settings.saveConfig();
					settings.getConfig();
					sender.sendMessage(ChatColor.AQUA + "ServerQuery has been reloaded!");
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}
			return false;
		}
	//Disable setup
	@Override
	public void onDisable(){
		Bukkit.getServer().getLogger().info(getDescription().getName() + " is now disabled!");
	}
}
