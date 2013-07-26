package com.untamedears.rourke750.ExpensiveBeacons;

import org.bukkit.block.Block;

public final class RelativeBlock {
	private final int relX;
	private final int relY;
	private final int relZ;
	
	public RelativeBlock(int relX, int relY, int relZ) {
		this.relX = relX;
		this.relY = relY;
		this.relZ = relZ;
	}
	
	public int getRelativeX() {
		return relX;
	}
	
	public int getRelativeY() {
		return relY;
	}
	
	public int getRelativeZ() {
		return relZ;
	}
	
	public Block getRelativeTo(Block b) {
		return b.getRelative(relX, relY, relZ);
	}
	
	@Override
	public int hashCode() {
		return (relX * 37 + relY) * 37 + relZ;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RelativeBlock) {
			RelativeBlock other = (RelativeBlock) o;
			
			return relX == other.relX && relY == other.relY && relZ == other.relZ;
		}
		
		return false;
	}
}
