package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;

public class StoredValues {
private Map<Location, String> type= new HashMap<Location, String>();
private Map<Location, String> tier= new HashMap<Location, String>();
	public StoredValues(){
		
	}
	public Map<Location, String> getTypeMap(){
		return type;
	}
	public Map<Location, String> getTierMap(){
		return tier;
	}
	public String getType(Location loc){
		return type.get(loc);
	}
	public String getTier(Location loc){
		return tier.get(loc);
	}
	public void setType(Location loc, String name){
		type.put(loc, name);
	}
	public void setTier(Location loc, String name){
		tier.put(loc,  name);
	}

}
