package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.Collection;
import java.util.List;
import java.util.Map;


import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Effects {

	public void runEffects(Map<Location, String> type, Map<Location, String> tier){
		Collection<String> ty= type.values();
		Collection<String> ti= tier.values();
		for (String run: ty){
			for (String run3: ti){
			for (Location run2: tier.keySet()){
			if (tier.get(run2)==run && run=="speed" && run3=="tier1"){
					setSpeedEffects(run2, run3);
				}
			}
		}
		}
	}
	
	public void setSpeedEffects(Location loc, String tier){
		if (tier=="tier1"){
		if (loc.getBlock().getType()==Material.BEACON){
			Player[] players= Bukkit.getOnlinePlayers();
			for (Player name: players){
				if (loc.distance(name.getLocation())<=20){
					name.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, 0));
				}
			}
		}
		}
	}
}
