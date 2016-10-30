package com.computerdude.volanti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class PaperClaim implements CommandExecutor,Listener {
	
	public static ArrayList<String> paperlore1 = new ArrayList<String>();
	public static ArrayList<String> paperlore2 = new ArrayList<String>();
	public static ArrayList<String> paperlore3 = new ArrayList<String>();
	public static ArrayList<String> paperlore4 = new ArrayList<String>();
	public static ArrayList<String> paperlore5 = new ArrayList<String>();
	public static ArrayList<String> sunlore = new ArrayList<String>();
	public static ArrayList<String> cakelore = new ArrayList<String>();
	public static ArrayList<String> questlore = new ArrayList<String>();
	
	public static void Init() {
		paperlore1.add(ChatColor.GRAY + "Right Click to claim " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Scout Rank!");
		paperlore2.add(ChatColor.GRAY + "Right Click to claim " + ChatColor.RED + "" + ChatColor.BOLD + "Adventurer Rank!");
		paperlore3.add(ChatColor.GRAY + "Right Click to claim " + ChatColor.GREEN + "" + ChatColor.BOLD + "Knight Rank!");
		paperlore4.add(ChatColor.GRAY + "Right Click to claim " + ChatColor.AQUA + "" + ChatColor.BOLD + "Duke Rank!");
		paperlore5.add(ChatColor.GRAY + "Right Click to claim " + ChatColor.GOLD + "" + ChatColor.BOLD + "Emperor Rank!");
		cakelore.add(ChatColor.GRAY + "THIS IS OVERPOWEEEEEEEEERED!");
		questlore.add(ChatColor.GRAY + "Right-Click to Discover your first quest!");
		sunlore.add(ChatColor.GRAY + "Right-Click to change the time to " + ChatColor.YELLOW + "" + ChatColor.BOLD + "day" + ChatColor.GRAY + " in your current world");
	}

	private void giveRank(Player player, String rank){
	    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manpromote " + player.getName() + " " + rank);
		}
	private void claimAnnounce(Player player, String rank){
		Bukkit.broadcastMessage("");
		Bukkit.broadcastMessage("");
		Bukkit.broadcastMessage("");
	    Bukkit.broadcastMessage(Main.color("&e&l(!) &9&l" + player.getName() + " &e&ljust claimed " + rank + "!"));
	    Bukkit.broadcastMessage("");
	    Bukkit.broadcastMessage("");
	    Bukkit.broadcastMessage("");
		}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("givesco") && sender instanceof Player) {
			if(player.hasPermission("volanti.admin")){
			((Player)sender).getInventory().addItem(getPaperClaim());
			} else {
				player.sendMessage(Main.color("&cNo Permission"));
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("giveadv") && sender instanceof Player) {
			if(player.hasPermission("volanti.admin")){
			((Player)sender).getInventory().addItem(getPaperClaimTwo());
			}else {
				player.sendMessage(Main.color("&cNo Permission"));
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("givekni") && sender instanceof Player) {
			if(player.hasPermission("volanti.admin")){
			((Player)sender).getInventory().addItem(getPaperClaimThree());
			}else {
				player.sendMessage(Main.color("&cNo Permission"));
			}
			return true;
		}else if (cmd.getName().equalsIgnoreCase("giveduk") && sender instanceof Player) {
			if(player.hasPermission("volanti.admin")){
			((Player)sender).getInventory().addItem(getPaperClaimFour());
			}else {
				player.sendMessage(Main.color("&cNo Permission"));
			}
			return true;
		}else if (cmd.getName().equalsIgnoreCase("giveemp") && sender instanceof Player) {
			if(player.hasPermission("volanti.admin")){
			((Player)sender).getInventory().addItem(getPaperClaimFive());
			}else {
				player.sendMessage(Main.color("&cNo Permission"));
			}
			return true;
		}
return false;
	}
	
	/**
	 * 
	 * @return The Paper Claim item
	 */
	public static ItemStack getPaperClaim() {
		
		ItemStack paperClaim = setMeta(new ItemStack(Material.PAPER), ChatColor.RESET + "" + ChatColor.YELLOW + "" + ChatColor.BOLD +"Scout Rank", 
				Arrays.asList(ChatColor.GRAY + "Right Click to claim " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Scout Rank!"));
	  
		return paperClaim;
		
	}
public static ItemStack getPaperClaimTwo() {
		
		ItemStack paperClaim2 = setMeta(new ItemStack(Material.PAPER), ChatColor.RESET + "" + ChatColor.RED + "" + ChatColor.BOLD +"Adventurer Rank", 
				Arrays.asList(ChatColor.GRAY + "Right Click to claim " + ChatColor.RED + "" + ChatColor.BOLD + "Adventurer Rank!"));
	  
		return paperClaim2;
		
	}
public static ItemStack getPaperClaimThree() {
	
	ItemStack paperClaim3 = setMeta(new ItemStack(Material.PAPER), ChatColor.RESET + "" + ChatColor.GREEN + "" + ChatColor.BOLD +"Knight Rank", 
			Arrays.asList(ChatColor.GRAY + "Right Click to claim " + ChatColor.GREEN + "" + ChatColor.BOLD + "Knight Rank!"));
  
	return paperClaim3;
	
}
public static ItemStack getPaperClaimFour() {
	
	ItemStack paperClaim4 = setMeta(new ItemStack(Material.PAPER), ChatColor.RESET + "" + ChatColor.AQUA + "" + ChatColor.BOLD +"Duke Rank", 
			Arrays.asList(ChatColor.GRAY + "Right Click to claim " + ChatColor.AQUA + "" + ChatColor.BOLD + "Duke Rank!"));
  
	return paperClaim4;
	
}
public static ItemStack getPaperClaimFive() {
	
	ItemStack paperClaim5 = setMeta(new ItemStack(Material.PAPER), ChatColor.RESET + "" + ChatColor.GOLD + "" + ChatColor.BOLD +"Emperor Rank", 
			Arrays.asList(ChatColor.GRAY + "Right Click to claim " + ChatColor.GOLD + "" + ChatColor.BOLD + "Emperor Rank!"));
	return paperClaim5;
  
	
}
	
     public static ItemStack setMeta(ItemStack material, String name, List<String> lore) {
    	   if(((material == null) || material.getType() == Material.AIR) 
    			   || ((name == null) && lore == null)) 
    		   return null;
    	   
    	   ItemMeta im = material.getItemMeta();
    	   if (name != null) 
    		   im.setDisplayName(name);
    	   if(lore != null) 
    		   im.setLore(lore);
    	   
    	   material.setItemMeta(im);
    	   return material;
    	   
     }
     
     @EventHandler(priority=EventPriority.HIGH)
 	public void onPlayerClick(PlayerInteractEvent event) {
    	 Player p = event.getPlayer();
    	 
    	    if(p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore1) 
    	    		&& !p.hasPermission("volanti.scout")){
    	        giveRank(p, "Scout");
    	        claimAnnounce(p, "&e&lScout Rank");
    	        ItemStack temp = getPaperClaim();
                p.getInventory().removeItem(temp); 
    	    }
    	    else if(p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore2) 
    	    		&& !p.hasPermission("volanti.adventurer")){
    	        giveRank(p, "Adventurer");
    	        claimAnnounce(p, "&c&lAdventurer Rank");
    	        ItemStack temp = getPaperClaimTwo();
                p.getInventory().removeItem(temp); 
    	    }
    	    else if(p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore3) 
    	    		&& !p.hasPermission("volanti.knight")){
    	        giveRank(p, "Knight");
    	        claimAnnounce(p, "&a&lKnight Rank");
    	        ItemStack temp = getPaperClaimThree();
                p.getInventory().removeItem(temp); 
    	    }
    	    else if(p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore4)  
    	    		&& !p.hasPermission("volanti.duke")){
    	        giveRank(p, "Duke");
    	        claimAnnounce(p, "&b&lDuke Rank");
    	        ItemStack temp = getPaperClaimFour();
                p.getInventory().removeItem(temp); 
    	    }
    	    else if(p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore5) 
    	    		&& !p.hasPermission("volanti.emperor")){
    	        giveRank(p, "Emperor");
    	        claimAnnounce(p, "&6&lEmperor Rank");
    	        ItemStack temp = getPaperClaimFive();
                p.getInventory().removeItem(temp); 
               
    	    } else if(p.getInventory().getItemInMainHand().getType() == Material.WATCH
    	    && p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(sunlore)){
    	    	p.getInventory().removeItem(SpecialItems.getSunCalc());
    	    	Location loc = p.getLocation();
    	    	loc.getWorld().setTime(0);
    	    	Bukkit.broadcastMessage(Main.color("&e&l(!) &eAs time passes, the sun moves oddly quick!"));
    	    	
    	    }
    	    else if(p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore5) 
    	    		&& p.hasPermission("volanti.emperor") || 
    	    		p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore4) 
    	    		&& p.hasPermission("volanti.duke") ||
    	    		p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore3) 
    	    		&& p.hasPermission("volanti.knight") ||
    	    		p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore2) 
    	    		&& p.hasPermission("volanti.adventurer") || 
    	    		p.getInventory().getItemInMainHand().getType() == Material.PAPER 
    	    		&& p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(paperlore1) 
    	    		&& p.hasPermission("volanti.scout")){
    			p.sendMessage(Main.color("&7You already have a rank equal to or higher than that. Try selling the rank to another player!"));
    	    }
    	}
}
