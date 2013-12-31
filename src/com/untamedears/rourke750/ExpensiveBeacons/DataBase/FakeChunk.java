package com.untamedears.rourke750.ExpensiveBeacons.DataBase;

import org.bukkit.World;

public class FakeChunk {
	public FakeChunk(int x, int z, World world){
		this.x=x;
		this.z=z;
		this.world=world;
	}
	public int x;
	public int z;
	public World world;
}
