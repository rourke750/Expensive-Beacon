package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.Faction;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;

public class Effects {
	private FileConfiguration config_;
	public Effects(FileConfiguration fi){
		config_=fi;
	}
	
	// Thank you Iebagi for making this code more efficient.
	Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());
	 public void runEffects(Map<Location, String> type, Map<Location, Integer> tier, Map<Location, Long> date) {
         int run3;
         Collection<String> ty = type.values();
         for (String run : ty) {
                 for (Location run2 : tier.keySet()) {
                         run3 = tier.get(run2);
                         if (type.get(run2) == null) continue;
                         if(type.get(run2).equals(run)){  // Tried making the if statements more efficent. ~iebagi
                        	 long time = date.get(run2) + 60000 * config_.getLong("maturation_time");
                        	 if (System.currentTimeMillis() <= time) continue;
                                 if(run.equals("speed")){
                                         setSpeedEffects(run2, run3);
                                 }
                                 if(run.equals("strength")){
                                         setStrengthEffects(run2, run3);
                                 }
                                 if(run.equals("regen")){
                                	 setRegenEffects(run2, run3);
                                 }
                                 if(run.equals("haste")){
                                	 setHasteEffects(run2, run3);
                                 }
                                 if(run.equals("super")){
                                	 setSuperEffects(run2, run3);
                                 }
                         }
                 }
         }
 }

	 public void setSpeedEffects(Location loc, int tier) {
         int level = 0;
         int one = config_.getInt("beacon_speed.tier_1.range");
         int two = config_.getInt("beacon_speed.tier_2.range");
         int three = config_.getInt("beacon_speed.tier_3.range");
         int four = config_.getInt("beacon_speed.tier_4.range");
         int five = config_.getInt("beacon_speed.tier_5.range");
         int dist[] = {0,one,two,three,four,five};  // Distances for this beacon; In Array form because if someone wants a 6th lvl, it can be done without changing alot of code.
         switch(tier){         // if tier == 4 || 5, level = 1;
                 case 4:
                 case 5:
                         level=1;
                         break;         
         }
        
         Faction group = groupname(loc);
         if (group == null) {
             return;
         }
         for (Player name : Bukkit.getOnlinePlayers()) {
                 
                 if (!group.isMember(name.getName()) && !group.isModerator(name.getName())
                		 && !group.isFounder(name.getName())) {
                         continue;
                 }
                 else if (group.isPersonalGroup()){
                	 if (name.equals(Citadel.getPersonalGroupManager().getPersonalGroup(group.getName()).getOwnerName())){
                		 effecttype(name, loc, dist, tier, level, PotionEffectType.SPEED);
                	 }
                 }
                 else {
                	 effecttype(name, loc, dist, tier, level, PotionEffectType.SPEED);
                 }
         }
 }

 public void setStrengthEffects(Location loc, int tier) {
         int level = 0;
         int one = config_.getInt("beacon_strength.tier_1.range"); 
         int two = config_.getInt("beacon_strength.tier_1.range"); 
         int three = config_.getInt("beacon_strength.tier_1.range"); 
         int four = config_.getInt("beacon_strength.tier_1.range"); 
         int five = config_.getInt("beacon_strength.tier_1.range"); 
         int dist[] = {0,one,two,three,four,five};
        
         switch(tier){
                 case 4:
                 case 5:
                         level=1;
                         break;         
         }
        
         Faction group = groupname(loc);
         if (group == null) {
             return;
         }
         for (Player name : Bukkit.getOnlinePlayers()) {
                 if (!group.isMember(name.getName()) && !group.isModerator(name.getName())
                		 && !group.isFounder(name.getName())) {
                         continue;
                 }
                 else if (group.isPersonalGroup()){
                	 if (name.equals(Citadel.getPersonalGroupManager().getPersonalGroup(group.getName()).getOwnerName())){
                		 effecttype(name, loc, dist, tier, level, PotionEffectType.INCREASE_DAMAGE);
                	 }
                 }
                 else {
                         effecttype(name, loc, dist, tier, level, PotionEffectType.INCREASE_DAMAGE);
                 }
         }
 }
 public void setRegenEffects(Location loc, int tier){
	 int level = 0;
     int one = config_.getInt("beacon_regen.tier_1.range"); 
     int two = config_.getInt("beacon_regen.tier_1.range"); 
     int three = config_.getInt("beacon_regen.tier_1.range"); 
     int four = config_.getInt("beacon_regen.tier_1.range"); 
     int five = config_.getInt("beacon_regen.tier_1.range"); 
     int dist[] = {0,one,two,three,four,five};
    
     switch(tier){
             case 4:
             case 5:
                     level=1;
                     break;         
     }
    
     Faction group = groupname(loc);
     if (group == null) {
         return;
     }
     for (Player name : Bukkit.getOnlinePlayers()) {
             if (!group.isMember(name.getName()) && !group.isModerator(name.getName())
            		 && !group.isFounder(name.getName())) {
                     continue;
             }
             else if (group.isPersonalGroup()){
            	 if (name.equals(Citadel.getPersonalGroupManager().getPersonalGroup(group.getName()).getOwnerName())){
            		 effecttype(name, loc, dist, tier, level, PotionEffectType.REGENERATION);
            	 }
             }
             else {
                     effecttype(name, loc, dist, tier, level, PotionEffectType.REGENERATION);
             }
     }
 }
 public void setHasteEffects(Location loc, int tier){
	 int level = 0;
     int one = config_.getInt("beacon_haste.tier_1.range"); 
     int two = config_.getInt("beacon_haste.tier_1.range"); 
     int three = config_.getInt("beacon_haste.tier_1.range"); 
     int four = config_.getInt("beacon_haste.tier_1.range"); 
     int five = config_.getInt("beacon_haste.tier_1.range"); 
     int dist[] = {0,one,two,three,four,five};
    
     switch(tier){
             case 4:
             case 5:
                     level=1;
                     break;         
     }
    
     Faction group = groupname(loc);
     if (group == null) {
         return;
     }
     for (Player name : Bukkit.getOnlinePlayers()) {
             if (!group.isMember(name.getName()) && !group.isModerator(name.getName())
            		 && !group.isFounder(name.getName())) {
                     continue;
             }
             else if (group.isPersonalGroup()){
            	 if (name.equals(Citadel.getPersonalGroupManager().getPersonalGroup(group.getName()).getOwnerName())){
            		 effecttype(name, loc, dist, tier, level, PotionEffectType.FAST_DIGGING);
            	 }
             }
             else {
                     effecttype(name, loc, dist, tier, level, PotionEffectType.FAST_DIGGING);
             }
     }
 }
 public void setSuperEffects(Location loc, int tier){
	 int level = 1;
     int one = config_.getInt("beacon_super.range");
     int dist[] = {0,one};

    
     Faction group = groupname(loc);
     if (group == null) {
         return;
     }
     for (Player name : Bukkit.getOnlinePlayers()) {
             if (!group.isMember(name.getName()) && !group.isModerator(name.getName())
            		 && !group.isFounder(name.getName())) {
                     continue;
             }
             if (group.isPersonalGroup()){
            	 if (name.equals(Citadel.getPersonalGroupManager().getPersonalGroup(group.getName()).getOwnerName())){
            		 PotionEffectType Types[] = {PotionEffectType.FAST_DIGGING, PotionEffectType.REGENERATION,
            		 PotionEffectType.INCREASE_DAMAGE, PotionEffectType.SPEED};
            		 for (PotionEffectType type:Types){
            		 effecttype(name, loc, dist, tier, level, type);
            		 }
            	 }
             }
             else {
            	 	PotionEffectType Types[] = {PotionEffectType.FAST_DIGGING, PotionEffectType.REGENERATION,
            	 	PotionEffectType.INCREASE_DAMAGE, PotionEffectType.SPEED};
            	 	for (PotionEffectType type:Types){
            	 	effecttype(name, loc, dist, tier, level, type);
        		 }
             }
     }
 }

 public Faction groupname(Location loc) {
         IReinforcement rein = Citadel.getReinforcementManager().getReinforcement(loc);
         if (rein != null && rein instanceof PlayerReinforcement) {
                 return ((PlayerReinforcement) rein).getOwner();
         }
         return null;
 }
 
 public void effecttype(Player name, Location loc, int[] dist, int tier, int level, PotionEffectType type){
	 if (loc.distance(name.getLocation()) <= dist[tier]) {
		 name.removePotionEffect(type);
         name.addPotionEffect(new PotionEffect(type, config_.getInt("apply_effects"), level));
 }
 }

}


