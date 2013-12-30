package com.untamedears.rourke750.ExpensiveBeacons.DataBase;

import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;

public class ChunkStructure {
	public ChunkStructure(List<Location> struct, Location mainbecid){
		this.struct = struct;
		this.mainbecid = mainbecid;
	}
	public List<Location> struct;
	public Location mainbecid;
}
