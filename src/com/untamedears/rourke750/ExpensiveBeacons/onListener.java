package com.untamedears.rourke750.ExpensiveBeacons;




import net.minecraft.server.v1_5_R3.Block;

import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class onListener implements Listener{
	private multiblockstructure multi=null;
	public onListener(multiblockstructure plugin){
		multi=plugin;
	}
	public void onBlockPlace(BlockPlaceEvent event){
		Block block= Block.BEACON;
		if(event.getBlock()==block){
			Location loc= event.getBlock().getLocation();
			multi.checkBuild(loc);
		}
	}
}
