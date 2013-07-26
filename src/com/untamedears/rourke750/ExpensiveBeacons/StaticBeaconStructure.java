package com.untamedears.rourke750.ExpensiveBeacons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.material.MaterialData;

public class StaticBeaconStructure implements BeaconStructure {
	private static Pattern locationPattern = Pattern.compile("^\\(([0-9]+),([0-9]+),([0-9]+)\\)\\[([0-9]+):([0-9]+)\\]$");
	
	private HashMap<RelativeBlock, MaterialData> blocks = new HashMap<RelativeBlock, MaterialData>();
	
	@Override
	public boolean matches(Beacon beacon) {
		for(RelativeBlock rBlock : blocks.keySet()) {
			MaterialData data = blocks.get(rBlock);
			Block block = rBlock.getRelativeTo(beacon.getBlock());
			
			if(block.getTypeId() != data.getItemTypeId() || block.getData() != data.getData()) {
				return false;
			}
		}
		
		return true;
	}
	
	public static StaticBeaconStructure loadFromFile(File file) {
		StaticBeaconStructure structure = new StaticBeaconStructure();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String contents = "";
			String line;
			
			while((line = reader.readLine()) != null) {
				contents += line;
			}
			
			reader.close();
			
			contents = contents.replaceAll("\\s*", ""); // Remove all whitespace.
			
			String[] locations = contents.split(";");
			
			boolean error = false;
			
			for(String location : locations) {
				Matcher matcher = locationPattern.matcher(location);
				
				if(matcher.matches() && matcher.groupCount() == 5) {
					try {
						int x = Integer.parseInt(matcher.group(1));
						int y = Integer.parseInt(matcher.group(2));
						int z = Integer.parseInt(matcher.group(3));
						int id = Integer.parseInt(matcher.group(4));
						byte data = Byte.parseByte(matcher.group(5));
						
						structure.blocks.put(new RelativeBlock(x, y, z), new MaterialData(id, data));
					}
					catch(NumberFormatException e) {
						error = true;
					}
				}
				else {
					error = true;
				}
			}
			
			if(error)
				ExpensiveBeaconsPlugin.instance.getLogger().warning("Error while parsing " + file.getName() + ".");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return structure;
	}
}
