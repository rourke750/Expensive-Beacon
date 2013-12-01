package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;

public class StoredValues {
	private Map<Location, String> type = new HashMap<Location, String>();
	private Map<Location, Integer> tier = new HashMap<Location, Integer>();
	private Map<Location, Long> date = new HashMap<Location, Long>();

	public StoredValues() {
		
	}

	public Map<Location, String> getTypeMap() {
		return type;
	}

	public Map<Location, Integer> getTierMap() {
		return tier;
	}
	
	public Map<Location, Long> getTimeMap(){
		return date;
	}

	public String getType(Location loc) {
		return type.get(loc);
	}

	public int getTier(Location loc) {
		return tier.get(loc);
	}

	public long getDate(Location loc) {
		return date.get(loc);
	}
	
	public void setType(Location loc, String name) {
		type.put(loc, name);
	}

	public void setTier(Location loc, int num) {
		tier.put(loc, num);
	}
	
	public void setDate(Location loc, long lon){
		date.put(loc, lon);
	}

	public void removeType(Location loc) {
		type.remove(loc);
	}

	public void removeTier(Location loc) {
		tier.remove(loc);
	}
	
	public void removeDate(Location loc) {
		date.remove(loc);
	}
}
