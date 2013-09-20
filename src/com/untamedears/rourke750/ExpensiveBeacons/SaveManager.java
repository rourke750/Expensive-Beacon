package com.untamedears.rourke750.ExpensiveBeacons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class SaveManager {
	Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());
	private ExpensiveBeaconsPlugin pl = null;
	private StoredValues sv = null;

	public SaveManager(ExpensiveBeaconsPlugin plugin, StoredValues stored) {
		pl = plugin;
		sv = stored;
	}

	public void load(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line;
		while ((line = br.readLine()) != null) {
			String parts[] = line.split(" ");
			String type = parts[0];
			String tier = parts[1];
			Location loc = new Location(Bukkit.getWorld(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
			sv.setTier(loc, Integer.parseInt(tier));
			sv.setType(loc, type);
		}
		fis.close();
	}

	public void save(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos));
		for (Location loc : sv.getTypeMap().keySet()) {
			if (loc.getBlock().getType() != Material.BEACON) {
				continue;
			}
			String ty = sv.getType(loc);
			int ti = sv.getTier(loc);
			br.append(ty);
			br.append(" ");
			br.append(Integer.toString(ti));
			br.append(" ");
			br.append(loc.getWorld().getName());
			br.append(" ");
			br.append(String.valueOf(loc.getBlockX()));
			br.append(" ");
			br.append(String.valueOf(loc.getBlockY()));
			br.append(" ");
			br.append(String.valueOf(loc.getBlockZ()));
			br.append("\n");

		}
		br.flush();
		fos.close();
	}
	
}
