package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


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

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.Faction;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;

public class Effects {
	Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
	
	public void runEffects(Map<Location, String> type, Map<Location, String> tier){
		logger.info("Effects has run");
		Collection<String> ty= type.values();
		Collection<String> ti= tier.values();
		for (String run: ty){
			logger.info(run);
			for (String run3: ti){
				logger.info(run3);
			for (Location run2: tier.keySet()){
			if (type.get(run2)==run && run=="speed" && run3=="one"){
					setSpeedEffects(run2, run3);
				}
			}
		}
		}
	}
	
	public void setSpeedEffects(Location loc, String tier){
		Faction group= groupname(loc);
		if (tier=="one"){
			logger.info("if tier one has run");
			for (Player name: Bukkit.getOnlinePlayers()){
				if (!group.isMember(name.toString()) && !group.isModerator(name.toString()) && !group.isFounder(name.toString())){
					continue;
				}
				else {
				if (loc.distance(name.getLocation())<=20){
					logger.info("Potions has run");
					name.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 0));
				
			}}}
		}// end of tier one
		
		}
	
	public Faction groupname(Location loc){
		String groupName = null;
		IReinforcement rein = Citadel.getReinforcementManager().getReinforcement(loc);
		if (rein instanceof PlayerReinforcement) {
		  groupName = ((PlayerReinforcement)rein).getOwner().getName();
		}
		Faction group =Citadel.getGroupManager().getGroup(groupName);
		logger.info("Setspeedeffects has run");
		if (groupName == null) {
			
			//players are told to reinforce after they place.
			return null;
		}
		else{
			return group;
		}
	}
}
