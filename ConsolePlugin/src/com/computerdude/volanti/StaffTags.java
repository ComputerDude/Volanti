package com.computerdude.volanti;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class StaffTags implements CommandExecutor,Listener{

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("stafftag") && sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("volanti.owner")) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
						"manuaddv " + player.getName() + " suffix &f&l <&3&lOwner&f&l>&r");
				player.sendMessage(ChatColor.GOLD + "Enabled Staff Tag");
			} else if(player.hasPermission("volanti.mod")) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
						"manuaddv " + player.getName() + " suffix &f&l <&5&lModerator&f&l>&r");
				player.sendMessage(ChatColor.GOLD + "Enabled Staff Tag");
			} else if(player.hasPermission("volanti.admin")) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
						"manuaddv " + player.getName() + " suffix &f&l <&4&lAdmin&f&l>&r");
				player.sendMessage(ChatColor.GOLD + "Enabled Staff Tag");
			} else if(player.hasPermission("volanti.headadmin")) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
						"manuaddv " + player.getName() + " suffix &f&l <&4&lHead-Admin&f&l>&r");
				player.sendMessage(ChatColor.GOLD + "Enabled Staff Tag");
			} else if(player.hasPermission("volanti.builder")) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
						"manuaddv " + player.getName() + " suffix &f&l <&9&lBuilder&f&l>&r");
				player.sendMessage(ChatColor.GOLD + "Enabled Staff Tag");
			} else {
				player.sendMessage(ChatColor.RED + "No Permission");
			}
			return true;
		}
		
		return false;
	
	
	}
	
}
