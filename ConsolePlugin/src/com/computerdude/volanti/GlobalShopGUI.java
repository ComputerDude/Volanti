package com.computerdude.volanti;

import java.util.ArrayList;

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

public class GlobalShopGUI implements CommandExecutor,Listener{
	
	public static ArrayList<String> shopGUILore = new ArrayList<String>();
	public static ArrayList<String> expShopLore = new ArrayList<String>();
	public static ArrayList<String> gadgetShopLore = new ArrayList<String>();

	public static void Init() {
		shopGUILore.add(Main.color("&eKeys and Kits"));
		expShopLore.add(Main.color("&eMind Gems & Enchants"));
		gadgetShopLore.add(Main.color("&eSpecial Gadgets"));
	}
	
	private void openGUI(Player player) {
		Inventory glo = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Shops...");
		
		ItemStack shopGUI = new ItemStack (Material.TRIPWIRE_HOOK);
		ItemMeta shopGUIMeta = shopGUI.getItemMeta();
		shopGUIMeta.setDisplayName(Main.color("&6&lSpecial Item Shop"));
		shopGUIMeta.setLore(shopGUILore);
		shopGUI.setItemMeta(shopGUIMeta);
		glo.setItem(4, shopGUI);
		
		ItemStack expShop = new ItemStack (Material.EXP_BOTTLE);
		ItemMeta expShopMeta = expShop.getItemMeta();
		expShopMeta.setDisplayName(Main.color("&6&lEnchant Shop"));
		expShopMeta.setLore(expShopLore);
		expShop.setItemMeta(expShopMeta);
		glo.setItem(3, expShop);
		
		ItemStack gadgetShop = new ItemStack (Material.COMPASS);
		ItemMeta gadgetShopMeta = expShop.getItemMeta();
		gadgetShopMeta.setDisplayName(Main.color("&6&lGadget Shop"));
		gadgetShopMeta.setLore(gadgetShopLore);
		gadgetShop.setItemMeta(gadgetShopMeta);
		glo.setItem(5, gadgetShop);
		
		player.openInventory(glo);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Shops...")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null 
				|| event.getCurrentItem().getType()==Material.AIR
				||!event.getCurrentItem().hasItemMeta()) {
			return;
		}
		switch(event.getCurrentItem().getType()) {
		case TRIPWIRE_HOOK:
			player.closeInventory();
			ShopGUI.openGUI(player);
			break;
		case EXP_BOTTLE:
			player.closeInventory();
			ExpShop.openSecondGUI(player);
			break;
		case COMPASS:
			player.closeInventory();
			GadgetShop.openGUI(player);
			break;
		default:
			break;
		}
	}
	
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("shop") && sender instanceof Player){
			Player player = (Player) sender;
			openGUI(player);
			return true;
		}
		
		return false;
	
	
	}
}
