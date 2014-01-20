package me.machnikowski.ServerQuery;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandSQ implements CommandExecutor {
	
	private ServerQuery pl;
	
	public CommandSQ(ServerQuery plugin){
		this.pl = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String commandLabel,String[] args){
		/*/sq commands
		 * Basic admin functions
		 */
		if(commandLabel.equalsIgnoreCase("sq")){
			if(args.length == 0){
				sender.sendMessage(ChatColor.AQUA + "Please use /sq help for a command list!");
				return true;
			    }
		    }if(args[0].equalsIgnoreCase("welcome")){
				if(sender.hasPermission("sq.help") || sender.isOp()){
				sender.sendMessage(ChatColor.AQUA + "Welcome to ServerQuery a new way to get Server information");
				return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}else if(args[0].equalsIgnoreCase("help")){
				if(sender.hasPermission("sq.help") || sender.isOp()){
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
				if(sender.hasPermission("sq.info") || sender.isOp()){
					sender.sendMessage(ChatColor.DARK_BLUE + "[" + pl.getDescription().getName()+"] "+ pl.getDescription().getVersion()+ " Written by "+ pl.getDescription().getAuthors());
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}else if (args[0].equalsIgnoreCase("reload")){
				if(sender.hasPermission("sq.reload") || sender.isOp()){
					pl.settings.reloadConfig();
					pl.settings.saveConfig();
					pl.settings.getConfig();
					sender.sendMessage(ChatColor.AQUA + "ServerQuery has been reloaded!");
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You Do Not Have Access To This Command!");
					return true;
				}
			}
			return false;
		}
	}


