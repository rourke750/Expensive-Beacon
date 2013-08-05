package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.Faction;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;

public class Effects {
	// Thank you Iebagi for making this code more efficient.
	Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());

	 public void runEffects(Map<Location, String> type, Map<Location, Integer> tier) {
         int run3;
         Collection<String> ty = type.values();
         Collection<Integer> ti = tier.values();
         for (String run : ty) {
                 logger.info(run);
                 for (Location run2 : tier.keySet()) {
                	 logger.info("LOCATION "+run2);
                         run3 = tier.get(run2);
                         if(type.get(run2).equals(run)){  // Tried making the if statements more efficent. ~iebagi
                        	 logger.info(run2 + "        " + run + "          " + run3);
                                 if(run=="speed"){
                                         setSpeedEffects(run2, run3);
                                 }
                                 if(run=="strength"){
                                         setStrengthEffects(run2, run3);
                                 }
                         }
                 }
         }
 }

	 public void setSpeedEffects(Location loc, int tier) {
         int level = 0;
         int dist[] = {0,30,55,72,80,100};  // Distances for this beacon; In Array form because if someone wants a 6th lvl, it can be done without changing alot of code.
         switch(tier){         // if tier == 4 || 5, level = 1;
                 case 4:
                 case 5:
                         level=1;
                         break;         
         }
        
         Faction group = groupname(loc);
         for (Player name : Bukkit.getOnlinePlayers()) {
                 if (group == null) {
                         continue;
                 }
                 if (!group.isMember(name.toString()) && !group.isModerator(name.toString())
                		 && !group.isFounder(name.toString()) && !group.isPersonalGroup()) {
                         continue;
                 }
                 else {
                         logger.info("Else ran.");
                         if (loc.distance(name.getLocation()) <= dist[tier]) {
                                 logger.info("Potions has run");
                                 name.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, level));
                         }
                 }
         }
 }

 public void setStrengthEffects(Location loc, int tier) {
         int level = 0;
         int dist[] = {0,20,30,40,50,70};
        
         switch(tier){
                 case 4:
                 case 5:
                         level=1;
                         break;         
         }
        
         Faction group = groupname(loc);
         for (Player name : Bukkit.getOnlinePlayers()) {
                 if (group == null) {
                         continue;
                 }
                 if (!group.isMember(name.toString()) && !group.isModerator(name.toString())
                		 && !group.isFounder(name.toString()) && !group.isPersonalGroup()) {
                      
                         continue;
                 }
                 else {
                         if (loc.distance(name.getLocation()) <= dist[tier]) {
                                 name.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, level));
                         }
                 }
         }
 }

 public Faction groupname(Location loc) {
         logger.info("public void faction cords" + loc);
         IReinforcement rein = Citadel.getReinforcementManager().getReinforcement(loc);
         if (rein != null && rein instanceof PlayerReinforcement) {
                 return ((PlayerReinforcement) rein).getOwner();
         }
         return null;
 }

}


