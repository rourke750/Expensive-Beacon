package com.untamedears.rourke750.ExpensiveBeacons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class PlayerHelper {
	private StaticBeaconMeta meta;
	public PlayerHelper(StaticBeaconMeta meta){
		this.meta = meta;
	}
	
		// Tells player where a block is missing.	
		public boolean playerHelperCommand(Player player, Block block, String[] args, boolean state){
			if (block.getType() != Material.BEACON){
				player.sendMessage(ChatColor.BLUE+"That is not a beacon, try pointing your cross hair at the beacon.");
				return true;
			}
			if (args.length <2){
				player.sendMessage(ChatColor.BLUE+"Please include a string and a tier, like so: eb_check <type> <tier>");
				return true;
			}
			String typeName[] = {"speed","strength", "regen", "haste", "super"};
			String type = args[0];
			 Integer tier = null;
			 try { 
			 tier = Integer.parseInt(args[1]); }
			 catch (Exception ex) {}
			 if (tier == null) {
			   player.sendMessage("Tier must be a number!");
			   return true;
			 } 
			
			boolean typetrue = false;
			
			for (int i=0; i<5; i++){
				if (typeName[i].equals(type)) typetrue = true;
			}
			
			if (typetrue != true){
				player.sendMessage(ChatColor.BLUE+"Type must be either speed, strength, regen, haste, or super.");
				return true;
			}
			
			if (tier<1 || tier>5){
				player.sendMessage(ChatColor.BLUE+"Tier must be greater than five or less than one.");
				return true;
			}
			int x = checkBeaconTier(args, tier);
			System.out.print(x);
			if (x == 21) return true;
			meta.getStruct(x).buildStructure(player, (Beacon) block.getState(), state);
			return true;
		}
		
		public boolean playerHelp(Player player){
			player.sendMessage(ChatColor.BLUE+ "List of possible commands: \r\n" +
					"eb_check <beacontype> <tier>: shows how to build the specific beacon. \n"+
					"eb_refresh <beacontype> <tier>: removes the fake blocks, make sure you are looking at the beacon.");
			return true;
		}
		
		public int checkBeaconTier(String args[], int tier){
			int x = 0;
			switch(args[0]){
			case "super": 
				x=20;
				break;
			case "haste":
				if (tier==5) x = 19;
				if (tier==4) x = 18;
				if (tier==3) x = 17;
				if (tier==2) x = 16;
				if (tier==1) x = 15;
				break;
			case "regen":
				if (tier==5) x = 14;
				if (tier==4) x = 13;
				if (tier==3) x = 12;
				if (tier==2) x = 11;
				if (tier==1) x = 10;
				break;
			case "strength":
				if (tier==5) x = 9;
				if (tier==4) x = 8;
				if (tier==3) x = 7;
				if (tier==2) x = 6;
				if (tier==1) x = 5;
				break;
			case "speed":
				if (tier==5) x = 4;
				if (tier==4) x = 3;
				if (tier==3) x = 2;
				if (tier==2) x = 1;
				if (tier==1) x = 0;
				break;
			default:
				x=21;
				break;
			}
			return x;
		}
}
