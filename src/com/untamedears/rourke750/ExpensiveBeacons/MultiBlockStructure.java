package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;

import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.SpeedBeacon;
import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.StrengthBeacon;

public class MultiBlockStructure {
	private BeaconListener ls = null;
	private ExpensiveBeaconsPlugin pl = null;
	private StoredValues sv = null;
	private StrengthBeacon strb;
	

	private StaticBeaconStructure sb1 = null;
	private StaticBeaconStructure sb2 = null;
	private StaticBeaconStructure sb3 = null;
	private StaticBeaconStructure sb4 = null;
	private StaticBeaconStructure sb5 = null;
	private StaticBeaconStructure str1=null;
	private StaticBeaconStructure str2=null;
	private StaticBeaconStructure str3=null;
	private StaticBeaconStructure str4=null;
	private StaticBeaconStructure str5=null;
	
	public MultiBlockStructure(ExpensiveBeaconsPlugin plugin, BeaconListener lis, StoredValues stored,
			StaticBeaconStructure speed1, StaticBeaconStructure speed2, StaticBeaconStructure speed3,
			StaticBeaconStructure speed4, StaticBeaconStructure speed5, StaticBeaconStructure strength1,
			StaticBeaconStructure strength2, StaticBeaconStructure strength3, StaticBeaconStructure strength4,
			StaticBeaconStructure strength5) {
		pl = plugin;
		ls = lis;
		sb1 = speed1;
		sb2 = speed2;
		sb3 = speed3;
		sb4 = speed4;
		sb5 = speed5;
		str1 =strength1;
		str2 =strength2;
		str3 =strength3;
		str4 =strength4;
		str5 =strength5;
		sv = stored;
	}

	Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());

	public void checkBuild(Location loc) {
		int tier = 0;
		String type;
		Block block=loc.getBlock();
		

			
			if (sb5.matches((Beacon) block.getState())== true) {
				tier = 5;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (sb4.matches((Beacon) block.getState())== true) {
				tier = 4;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (sb3.matches((Beacon) block.getState())== true) {
				tier = 3;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (sb2.matches((Beacon) block.getState())== true) {
				tier = 2;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (sb1.matches((Beacon) block.getState())== true) {
				tier = 1;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (str5.matches((Beacon) block.getState())== true) {
				tier = 5;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (str4.matches((Beacon) block.getState())== true) {
				tier = 4;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (str3.matches((Beacon) block.getState())== true) {
				tier = 3;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (str2.matches((Beacon) block.getState())== true) {
				tier = 2;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (str1.matches((Beacon) block.getState())== true) {
				tier = 1;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (tier==0){
			if (sv.getType(loc)!=null){
				sv.removeTier(loc);
				sv.removeType(loc);
				}
			}
		}
	}

