package com.computerdude.volanti;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomEnchants implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		if (e.getSlot() == 100
				&& player.getInventory().getBoots().getItemMeta().getLore().contains(Main.color("&7&lCheetah I"))) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 1));
		} else if (e.getSlot() == 100
				&& player.getInventory().getBoots().getItemMeta().getLore().contains(Main.color("&7&lCheetah II"))) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 2));
		} else if (e.getSlot() == 100
				&& player.getInventory().getBoots().getItemMeta().getLore().contains(Main.color("&7&lCheetah III"))) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 3));
		} else if (!player.getInventory().getBoots().getItemMeta().getLore().contains(Main.color("&7&lCheetah III"))
				|| !player.getInventory().getBoots().getItemMeta().getLore().contains(Main.color("&7&lCheetah II"))
				|| !player.getInventory().getBoots().getItemMeta().getLore().contains(Main.color("&7&lCheetah I"))) {
			player.removePotionEffect(PotionEffectType.SPEED);
		}
	}

	@EventHandler
	public void onEntityAttack(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType().equals(EntityType.PLAYER) && e.getEntity().getType().equals(EntityType.PLAYER)) {
			Player player = (Player) e.getDamager();
			Player attacked = (Player) e.getEntity();
			if (player.isSneaking() == true && player.getInventory().getItemInMainHand().getItemMeta().getLore()
					.contains(Main.color("&7Execute I"))) {
				player.sendMessage("True");
				double damage = e.getFinalDamage() + 1;
				e.setDamage(damage);
			} else if (player.isSneaking() == true && player.getInventory().getItemInMainHand().getItemMeta().getLore()
					.contains(Main.color("&7Execute II"))) {
				player.sendMessage("True");
				double damage = e.getFinalDamage() + 2;
				e.setDamage(damage);
			} else if (player.isSneaking() == true && player.getInventory().getItemInMainHand().getItemMeta().getLore()
					.contains(Main.color("&7Execute III"))) {
				player.sendMessage("True");
				double damage = e.getFinalDamage() + 3;
				e.setDamage(damage);
			} else if (player.isSneaking() == true && player.getInventory().getItemInMainHand().getItemMeta().getLore()
					.contains(Main.color("&7Execute IV"))) {
				player.sendMessage("True");
				double damage = e.getFinalDamage() + 4;
				e.setDamage(damage);
			} else if (player.isSneaking() == true && player.getInventory().getItemInMainHand().getItemMeta().getLore()
					.contains(Main.color("&7Execute V"))) {
				player.sendMessage("True");
				double damage = e.getFinalDamage() + 5;
				e.setDamage(damage);
			} else if (player.isSneaking() == true && player.getInventory().getItemInMainHand().getItemMeta().getLore()
					.contains(Main.color("&7Execute VI"))) {
				player.sendMessage("True");
				double damage = e.getFinalDamage() + 6;
				e.setDamage(damage);
			} else {
				player.sendMessage("False");
			}

			int chance = ThreadLocalRandom.current().nextInt(1, 50);
			int chance2 = ThreadLocalRandom.current().nextInt(1, 25);
			int chance3 = ThreadLocalRandom.current().nextInt(1, 10);
			if (attacked.getInventory().getChestplate().getItemMeta().getLore()
					.contains(Main.color("&7Burning Ember I")) && chance == 2) {
				player.setFireTicks(140);
			} else if (attacked.getInventory().getChestplate().getItemMeta().getLore()
					.contains(Main.color("&7Burning Ember II")) && chance2 == 2) {
				player.setFireTicks(140);
			} else if (attacked.getInventory().getChestplate().getItemMeta().getLore()
					.contains(Main.color("&7Burning Ember III")) && chance3 == 2) {
				player.setFireTicks(140);
			}
		}
	}

}
