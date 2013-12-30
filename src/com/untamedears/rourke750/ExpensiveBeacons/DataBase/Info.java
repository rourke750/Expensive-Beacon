package com.untamedears.rourke750.ExpensiveBeacons.DataBase;

import org.bukkit.Chunk;
import org.bukkit.Location;

public class Info {
	    public Info(int id, int ti, String ty, boolean bro, long time, long brokenTime, int hitPoints, Location loc, int classnum) {
	      beaconid = id;
	      tier = ti;
	      type = ty;
	      broken = bro;
	      this.time = time;
	      this.brokenTime = brokenTime;
	      this.hitPoints = hitPoints;
	      this.loc = loc;
	      this.classnum = classnum;
	      this.chunks = loc.getChunk();
	    }
	    public int beaconid;
	    public int tier;
	    public boolean broken;
	    public long time;
	    public String type;
	    public long brokenTime;
	    public int hitPoints;
	    public Location loc;
	    public int classnum;
	    public Chunk chunks;
	    
	    public void updateCorrectID(int x){
	    	beaconid = x;
	    }
	    public void updateIfBroken(boolean broken){
	    	this.broken = broken;
	    }
	    public void updateBrokenTime(long brokenTime){
	    	this.brokenTime = brokenTime;
	    }
	    public void updateHitPoints(int x){
	    	hitPoints = x;
	    }
	  }
