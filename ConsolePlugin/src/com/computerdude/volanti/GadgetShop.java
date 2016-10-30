package com.computerdude.volanti;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.milkbowl.vault.economy.EconomyResponse;

public class GadgetShop implements CommandExecutor,Listener{

	public static void openGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Gadget Shop");
		
		ItemStack sunDial = new ItemStack (Material.WATCH);
		ItemMeta sunDialMeta = sunDial.getItemMeta();
		sunDialMeta.setDisplayName(Main.color("&e&lSun Dial"));
		sunDialMeta.setLore(ShopGUI.sunDialLore);
		sunDial.setItemMeta(sunDialMeta);
		inv.setItem(1, sunDial);
		
		ItemStack none = new ItemStack (Material.STAINED_GLASS_PANE);
		ItemMeta noneMeta = none.getItemMeta();
		none.setDurability((short) 15);
		noneMeta.setDisplayName(Main.color(" "));
		none.setItemMeta(noneMeta);
		inv.setItem(0, none);
		inv.setItem(8, none);
		
		player.openInventory(inv);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Gadget Shop")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null 
				|| event.getCurrentItem().getType()==Material.AIR
				||!event.getCurrentItem().hasItemMeta()) {
			return;
		}
		switch(event.getCurrentItem().getType()) {
		case WATCH:
			EconomyResponse r = Main.econ.withdrawPlayer(player, 10000);
			if(r.transactionSuccess() && player.getInventory().firstEmpty() != -1) {
			player.getInventory().addItem(SpecialItems.getSunCalc());
			player.sendMessage(Main.color("&2Purchase Success!"));
			} else {
				player.sendMessage(Main.color("&4Insufficient Funds"));
			}
			break;
		default:
			break;
		}
		
	}
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("gshop") && sender instanceof Player){
			Player player = (Player) sender;
			openGUI(player);
			return true;
		}
		
		return false;
	
	
	}
}
