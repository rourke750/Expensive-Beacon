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
	
	public void runEffects(Map<Location, String> type, Map<Location, Integer> tier){
		logger.info("Effects has run");
		Collection<String> ty= type.values();
		Collection<Integer> ti= tier.values();
		for (String run: ty){
			logger.info(run);
			for (int run3: ti){
				logger.info(""+run3);
			for (Location run2: tier.keySet()){
			if (type.get(run2)==run && run=="speed" && run3==1){
					setSpeedEffects(run2, run3);
				}
			if(type.get(run2)==run && run=="speed" && run3==2){
				setSpeedEffects(run2, run3);
			}
			if(type.get(run2)==run && run=="speed" && run3==3){
				setSpeedEffects(run2, run3);
			}
			if(type.get(run2)==run && run=="speed" && run3==4){
				setSpeedEffects(run2, run3);
			}
			if(type.get(run2)==run && run=="speed" && run3==5){
				setSpeedEffects(run2, run3);
			}
			}
		}
		}
	}
	
	public void setSpeedEffects(Location loc, int tier){
		
		int distance = 0, level=0;
		if (tier==1){
			distance=20;
		}
		if (tier==2){
			distance=30;
		}
		if (tier==3){
			distance=40;
		}
		if (tier==4){
			distance=50;
			level=1;
		}
		if (tier==5){
			distance=70;
			level=1;
		}
			logger.info("if tier one has run");
			Faction group= groupname(loc);
			for (Player name: Bukkit.getOnlinePlayers()){
				
				if (!group.isMember(name.toString()) && !group.isModerator(name.toString()) && !group.isFounder(name.toString()) && !group.isPersonalGroup()){
					continue;
				}
				else {
				if (loc.distance(name.getLocation())<=distance){
					logger.info("Potions has run");
					name.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, level));
			}}}
		}
	
	public Faction groupname(Location loc){
		String groupName = null;
		Faction group=null;
		IReinforcement rein = Citadel.getReinforcementManager().getReinforcement(loc);
		if (rein instanceof PlayerReinforcement) {
		  groupName = ((PlayerReinforcement)rein).getOwner().getName();

			group =Citadel.getGroupManager().getGroup(groupName);
		}
		logger.info("Setspeedeffects has run");
		if (groupName == null) {
			
			//players are told to reinforce after they place.
			return null;
		}
		else{
			logger.info(group.toString());
			return group;
		}
	}
}
