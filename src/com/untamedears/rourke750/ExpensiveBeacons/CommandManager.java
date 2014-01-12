package com.untamedears.rourke750.ExpensiveBeacons;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor{
	PlayerHelper ph;
	
	public CommandManager(PlayerHelper ph){
		this.ph = ph;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("Must be player to use Commands!");
		}
		Player player = (Player)sender;
		Block block = player.getTargetBlock(null, 5);
		
		if (command.getName().equals("eb")) return ph.playerHelp(player);
		
		if (command.getName().equals("eb_check")) return ph.playerHelperCommand(player, block, args, false);
		
		if (command.getName().equals("eb_refresh")) return ph.playerHelperCommand(player, block, args, true);
	
		if (command.getName().equals("eb_info")) return ph.infoStructure(player);
		
		if (command.getName().equals("beaconplus")) return ph.fuckBeaconPlus(player);
		
		return false;
	}
	
}
