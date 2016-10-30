package com.computerdude.volanti;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BuffedMobs implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player player = (Player) e.getEntity();
		if (e.getEntity() instanceof Player) {
			Location deathLoc = e.getEntity().getLocation();
			LivingEntity ent = (LivingEntity) deathLoc.getWorld().spawnEntity(deathLoc, EntityType.ZOMBIE);
			ent.setCustomName(Main.color("&6&lZombie of " + player.getName()));
			ent.setCanPickupItems(true);
		}
	}

	@EventHandler
	public void onPlayerPickup(PlayerPickupItemEvent e) {
		Player player = (Player) e.getPlayer();
		if (player.getInventory().contains(SpecialItems.getSugarCake()) && player.isFlying() == false) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 1));

		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = (Player) e.getPlayer();
		if (player.getInventory().contains(SpecialItems.getSugarCake()) && player.isFlying() == false) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 1));
		}
	}

	@EventHandler
	public void onPlayerBeginFly(PlayerToggleFlightEvent e) {
		Player player = (Player) e.getPlayer();
		if (player.getInventory().contains(SpecialItems.getSugarCake())) {
			player.removePotionEffect(PotionEffectType.SPEED);
			player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			player.removePotionEffect(PotionEffectType.JUMP);
			player.removePotionEffect(PotionEffectType.REGENERATION);
		}
	}

	@EventHandler
	public void onAchievement(PlayerAchievementAwardedEvent e) {
		if (e.getPlayer() != null) {
			Player player = (Player) e.getPlayer();
			player.giveExp(50);
		} else {
			return;
		}

	}

	@EventHandler
	public void onPlayerEnchant(EnchantItemEvent e) {
		Player player = (Player) e.getEnchanter();
		int exp = player.getLevel();
		Location loc = player.getLocation();
		if (!loc.getWorld().equals("spawn") && exp > 29) {
			loc.getWorld().spawnEntity(loc, EntityType.LIGHTNING);
		}
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		Entity ent = e.getEntity();
		if(ent.getType().equals(EntityType.DROPPED_ITEM) && ent.getCustomName().equals(Main.color("&d&lSugar Cake"))) {
			Main.cakeExists = false;
			for(;Main.cakeExists = false;) {
				Bukkit.getConsoleSender().sendMessage("SUGAR CAKE DOES NOT EXIST");
			}
		}
	}
	
}
