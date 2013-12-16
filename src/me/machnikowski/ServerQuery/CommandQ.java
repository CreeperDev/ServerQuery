package me.machnikowski.ServerQuery;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandQ implements CommandExecutor {
	
	private ServerQuery pl;
	
	public CommandQ(ServerQuery plugin){
		this.pl = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String commandLabel,String[] args){
	/*/q commands
	 * Basic function commands (heart and soul)
	 */
	if(commandLabel.equalsIgnoreCase("q")){
		if(args.length == 0){
			sender.sendMessage(ChatColor.AQUA + "Please use /sq help!");
			return true;
		}if(args[0].equalsIgnoreCase("website")){
			if(sender.hasPermission("sq.use") || sender.isOp()){
				sender.sendMessage(ChatColor.GREEN + pl.getConfig().getString("Website"));
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
				return true;
			}
		}else if(args[0].equalsIgnoreCase("owner")){
			if(sender.hasPermission("sq.use") || sender.isOp()){
				sender.sendMessage(pl.getConfig().getString("Owner"));
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command");
				return true;
			}
		}else if(args[0].equalsIgnoreCase("facebook")){
			if(sender.hasPermission("sq.use") || sender.isOp()){
				sender.sendMessage(ChatColor.GREEN + pl.getConfig().getString("Facebook"));
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You Do Not Have Access To That Command!");
				return true;
			}
		}else if(args[0].equalsIgnoreCase("twitter")){
			if(sender.hasPermission("sq.use") || sender.isOp()){
				sender.sendMessage(ChatColor.GREEN + pl.getConfig().getString("Twitter"));
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
				return true;
			}
		}else if(args[0].equalsIgnoreCase("member")){
			if(sender.hasPermission("sq.use") || sender.isOp()){
				sender.sendMessage(ChatColor.GREEN + pl.getConfig().getString("Member"));
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
				return true;
			}
		}
	}
	return false;
  }
}
