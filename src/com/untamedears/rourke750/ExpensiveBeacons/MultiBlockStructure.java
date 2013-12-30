package com.untamedears.rourke750.ExpensiveBeacons;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;

import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.SpeedBeacon;
import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.StrengthBeacon;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.BeaconStorage;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.ChunkStructure;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.Info;

public class MultiBlockStructure {
	private ExpensiveBeaconsPlugin plugin;
	private StoredValues sv = null;
	private StaticBeaconMeta meta = null;
	
	public MultiBlockStructure(ExpensiveBeaconsPlugin plugin, BeaconListener lis, StoredValues stored,
			StaticBeaconMeta m) {
		meta = m;
		sv = stored;
		this.plugin = plugin;
	}

	Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());

	public void checkBuild(Location loc) {
		int tier = 0;
		String type= null;
		int classnum = 0;
		String typeName[] = {"speed","strength", "regen", "haste", "super"};
		Block block=loc.getBlock();
			for(int i=meta.getMaxSize()-1; i>=0;i--){			//Remove if statements for loop statement.	~iebagi
				if(meta.getStruct(i).matches((Beacon) block.getState())==true){	
					if (type !=null && type == "haste"){
						type=null;
						tier=0;
					}
					if (type !=null){
						continue;
					}
					else{
					tier = i%5+1;
					type = typeName[(i/5)%5];			//Every 4 loops, typeName[n] turns into typeName[1] ~iebagi
					classnum = i;
					}
				} 
			}
				
				if (type != null && sv.getBeaconInfo(loc)==null){
					System.out.print(type);
					boolean allowed = true;
					for (ChunkStructure chunky: sv.getChunkStructure()){
						System.out.print("This is not empty.");
						if (chunky.mainbecid.getChunk() == loc.getChunk()) allowed = false;
					}
					if (allowed == false && type != "super") return;
				List<Location> locations = meta.getStruct(classnum).getStructureLocations(block);
				int id = 0; // doesnt matter gets updated in the future
				boolean broken = false;
				long time = System.currentTimeMillis();
				int hitpoints = plugin.getConfig().getInt("beacon_hitpoints");
				Info info = new Info(id, tier, type, broken, time, 0, hitpoints, loc, classnum);
				sv.addInfo(loc, info);
				sv.createBeacon(locations, info);
				if (type=="super"){
					Location locs = new Location(loc.getWorld(), loc.getX()-1, loc.getY(), loc.getZ());
					Info in = sv.getBeaconInfo(locs);
					if (in !=null) sv.removeBeaconInfo(locs, in.beaconid);
					locs = new Location(loc.getWorld(), loc.getX()-1, loc.getY(), loc.getZ()+1);
					in = sv.getBeaconInfo(locs);
					if (in !=null) sv.removeBeaconInfo(locs, in.beaconid);
					locs = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()+1);
					in = sv.getBeaconInfo(locs);
					if (in !=null) sv.removeBeaconInfo(locs, in.beaconid);
				}
				}
		}
	}

