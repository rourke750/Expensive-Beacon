package com.untamedears.rourke750.ExpensiveBeacons.DataBase;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

import net.minecraft.server.v1_6_R3.IInventory;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_6_R3.inventory.CraftInventory;
import org.bukkit.inventory.Inventory;

import com.untamedears.rourke750.ExpensiveBeacons.ConfigManager;
import com.untamedears.rourke750.ExpensiveBeacons.Effects;
import com.untamedears.rourke750.ExpensiveBeacons.ExpensiveBeaconsPlugin;

public class BeaconStorage {
	private Effects ef;
    private final DataBase db;
    protected ExpensiveBeaconsPlugin plugin;
    private final String host;
    private final String dbname;
    private final String username;
    private final int port;
    private final String password;
    private PreparedStatement getLastBeaconID;
    private PreparedStatement getBeaconFromLocation;
    private PreparedStatement getBeaconStructureFromId;
    private PreparedStatement deleteBeaconId;
    private PreparedStatement deleteBeaconStructure;
    private PreparedStatement insertBeacon;
    private PreparedStatement insertBeaconStructure;
    private PreparedStatement getBeaconIds;
    private PreparedStatement getBeaconFromId;
    private PreparedStatement updateBeacon;
    private int lastBeaconId;
    
    
    public BeaconStorage(FileConfiguration config_, Effects ef){
    	this.ef = ef;
    	plugin = ExpensiveBeaconsPlugin.instance;
    	host = config_.getString("sql.hostname");
    	port = config_.getInt("sql.port");
    	dbname = config_.getString("sql.dbname");
    	username = config_.getString("sql.username");
    	password = config_.getString("sql.password");
    	db= new DataBase(host, port, dbname, username, password, this.plugin.getLogger());
    	boolean connected = db.connect();
    	if (connected){
    		genTables();
    		initializeStatements();
    	}
    	
    }
    
    public DataBase getDb(){
    	return db;
    }
    
    public void genTables(){
    	db.execute("CREATE TABLE IF NOT EXISTS `beacons` ("
    			+ "`beacon_id` int(10) unsigned NOT NULL AUTO_INCREMENT,"
    			+ "`type` varchar(40) NOT NULL,"
    			+ "`tier` int(10) NOT NULL,"
    			+ "`creation` bigint(20) NOT NULL,"
    			+ "`broken` BOOL NOT NULL,"
    			+ "`broken_time` bigint(20) NOT NULL,"
    			+ "`block_world` varchar(40) NOT NULL,"
    			+ "`block_x` int(10) NOT NULL,"
    			+ "`block_y` int(10) NOT NULL,"
    			+ "`block_z` int(10) NOT NULL,"
    			+ "`hit_points` int(10) NOT NULL,"
    			+ "`class_num` int(10) NOT NULL,"
    			+ "PRIMARY KEY(`beacon_id`));");
    			 
    	db.execute("CREATE TABLE IF NOT EXISTS `beacon_blocks` ("
    			+ "`beacon_block_id` int(10) unsigned NOT NULL AUTO_INCREMENT,"
    			+ "`beacon_id` int(10) unsigned NOT NULL,"
    			+ "`block_world` varchar(40) NOT NULL,"
    			+ "`block_x` int(10) NOT NULL,"
    			+ "`block_y` int(10) NOT NULL,"
    			+ "`block_z` int(10) NOT NULL,"
    			+ "PRIMARY KEY(`beacon_block_id`),"
    			+ "CONSTRAINT `fk_beacons_beacon_id` FOREIGN KEY (`beacon_id`) "
    			+ "REFERENCES `beacons` (`beacon_id`) ON DELETE CASCADE ON UPDATE CASCADE);");
    }
    
    private void initializeStatements(){
    	getBeaconFromLocation = db.prepareStatement(String.format("SELECT beacon_id, tier, type, creation, broken, class_num FROM %s "
                + " WHERE block_x=? AND block_y=? AND block_z=? AND block_world=?", "beacons"));
    	getBeaconStructureFromId = db.prepareStatement(String.format("SELECT block_x, block_y, block_z, block_world FROM %s "
    			+ " WHERE beacon_id=?", "beacon_blocks"));
    	deleteBeaconId = db.prepareStatement(String.format("DELETE FROM %s WHERE beacon_id=?", "beacons"));
    	deleteBeaconStructure = db.prepareStatement(String.format("DELETE FROM %s WHERE beacon_id=?", "beacon_blocks"));
    	insertBeacon = db.prepareStatement(String.format("INSERT INTO %s "
    			+ "(type, tier, creation, broken, broken_time, block_world, block_x, "
    			+ "block_y, block_z, hit_points, class_num)"
    			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "beacons"));
    	insertBeaconStructure = db.prepareStatement(String.format("INSERT INTO %s "
    			+ "(beacon_id, block_world, block_x, block_y, block_z) "
    			+ "VALUES(?, ?, ?, ?, ?)", "beacon_blocks"));
    	getBeaconIds = db.prepareStatement(String.format(
                "SELECT beacon_id FROM %s ", "beacons"));
    	getBeaconFromId = db.prepareStatement(String.format("SELECT tier, type, creation, broken, broken_time, block_world, block_x, block_y, block_z, hit_points, class_num FROM %s "
    			+ " WHERE beacon_id=?", "beacons"));
    	getLastBeaconID = db.prepareStatement(String.format(
    			"SELECT LAST_INSERT_ID() AS id ", "beacons"));
    	updateBeacon = db.prepareStatement(String.format(
    			"UPDATE %s SET broken=?, broken_time=?, hit_points=? WHERE beacon_id=?", "beacons"));
    	
    }
    
    public List<Block> getBeaconStructure(int id) {
        List<Block> blocks = new ArrayList<Block>();
        try {
        	
        	getBeaconStructureFromId.setInt(1, id);
            ResultSet BeaconStructureSet = getBeaconStructureFromId.executeQuery();
            
            // make sure we got a result
            boolean didFind = false;
            while (BeaconStructureSet.next()) {
            	World world = plugin.getServer().getWorld(BeaconStructureSet.getString("block_world"));
            	int x = BeaconStructureSet.getInt("block_x");
                int y = BeaconStructureSet.getInt("block_y");
                int z = BeaconStructureSet.getInt("block_z");
            	Location loc = new Location(world, x, y, z);
                didFind = true;
                blocks.add(loc.getBlock());
            }

            // only continue if we actually got a result from the first query
            if (!didFind) {
                this.plugin.getLogger().log(Level.SEVERE, "Didn't get any results trying to find a beacon in the beacons table at id: " + id);
            } else {
                return blocks;
            }

        } catch (SQLException ex1) {
            this.plugin.getLogger().log(Level.SEVERE, "Could not get Beacon Details! id: " + id, ex1);
        }

        return blocks;
    }
    
    public Info getBeaconInfo(Location loc){
    	Info info = null;
    	// get the snitch's ID based on the location, then use that to get the snitch details from the snitchesDetail table
        int interestedBeaconId = 0;
        int interestedBeaconTier = 0;
        String interestedBeaconType = "";
        boolean interestedBeaconBroken = false;
        long interestedBeaconTime = 0;
        long interestedBeaconBrokenTime = 0;
        int interestedBeaconHitPoints = 0;
        int interestedBeaconClassNum = 0;
        try {
            // params are x(int), y(int), z(int), world(tinyint), column returned: snitch_id (int)
        	getBeaconFromLocation.setInt(1, loc.getBlockX());
        	getBeaconFromLocation.setInt(2, loc.getBlockY());
        	getBeaconFromLocation.setInt(3, loc.getBlockZ());
        	getBeaconFromLocation.setString(4, loc.getWorld().getName());

            ResultSet BeaconIdSet = getBeaconFromLocation.executeQuery();
            BeaconIdSet.next();
                interestedBeaconId = BeaconIdSet.getInt("beacon_id");
                interestedBeaconTier = BeaconIdSet.getInt("tier");
                interestedBeaconType = BeaconIdSet.getString("type");
                interestedBeaconBroken = BeaconIdSet.getBoolean("broken");
                interestedBeaconTime = BeaconIdSet.getLong("creation");
                interestedBeaconBrokenTime = BeaconIdSet.getLong("broken_time");
                interestedBeaconHitPoints = BeaconIdSet.getInt("hit_points");
                interestedBeaconClassNum = BeaconIdSet.getInt("class_num");
                
                info = new Info(interestedBeaconId,interestedBeaconTier, interestedBeaconType, interestedBeaconBroken, interestedBeaconTime,
                		interestedBeaconBrokenTime, interestedBeaconHitPoints, loc, interestedBeaconClassNum);
                return info;
        }
        catch (SQLException ex1) {
            this.plugin.getLogger().log(Level.SEVERE, "Could not get Beacon Details! loc: " + loc, ex1);
        }
        return info;
    }
    
    public Info getBeaconInfo(int id){
    	Info info = null;
    	// get the snitch's ID based on the location, then use that to get the snitch details from the snitchesDetail table
        int interestedBeaconId = id;
        int interestedBeaconTier = 0;
        String interestedBeaconType = "";
        boolean interestedBeaconBroken = false;
        long interestedBeaconTime = 0;
        long interestedBeaconBrokenTime = 0;
        int interestedBeaconHitPoints = 0;
        double x,y,z;
        String world;
        int interestedBeaconClassNum = 0;
        try {
        	getBeaconFromId.setInt(1, id);
            ResultSet BeaconIdSet = getBeaconFromId.executeQuery();
            BeaconIdSet.next();
                interestedBeaconTier = BeaconIdSet.getInt("tier");
                interestedBeaconType = BeaconIdSet.getString("type");
                interestedBeaconBroken = BeaconIdSet.getBoolean("broken");
                interestedBeaconTime = BeaconIdSet.getLong("creation");
                interestedBeaconBrokenTime = BeaconIdSet.getLong("broken_time");
                interestedBeaconHitPoints = BeaconIdSet.getInt("hit_points");
                interestedBeaconClassNum = BeaconIdSet.getInt("class_num");
                x = BeaconIdSet.getInt("block_x");
                y = BeaconIdSet.getInt("block_y");
                z = BeaconIdSet.getInt("block_z");
                world = BeaconIdSet.getString("block_world");
                Location loc = new Location(Bukkit.getWorld(world),x,y,z);
                info = new Info(interestedBeaconId,interestedBeaconTier, interestedBeaconType, interestedBeaconBroken, interestedBeaconTime,
                		interestedBeaconBrokenTime, interestedBeaconHitPoints, loc, interestedBeaconClassNum);
                return info;
        }
        catch (SQLException ex1) {
            this.plugin.getLogger().log(Level.SEVERE, "Could not get Beacon Details! id: " + id, ex1);
        }
        return info;
    }
    
    
    
      public void deleteBeacon(int id){
    	  try {
			deleteBeaconId.setInt(1, id);
			deleteBeaconId.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
      }
      
      public List<Integer> getAllBeaconIds(){
    	  List<Integer> ids = new ArrayList<Integer>();
    	  try {
			ResultSet BeaconIdSet = getBeaconIds.executeQuery();
			while (BeaconIdSet.next()){
				int id = BeaconIdSet.getInt("beacon_id");
				ids.add(id);
			}
			return ids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return ids;
      }
      
      public int getLastId() {
    	  try {
			if (getLastBeaconID.execute()) {
				System.out.print("Id from get last id executed"+ lastBeaconId);
				  ResultSet rsKey = getLastBeaconID.getResultSet();
				  if (rsKey.next()) {
					  lastBeaconId = rsKey.getInt("id");
					  System.out.print("Id from get last id was successful "+lastBeaconId);
					  rsKey.close();
					  return lastBeaconId;
				  }
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return lastBeaconId;
      }
      
      public void createBeacon(List<Location> blocklocations, Info info){
    	  try {
    		  insertBeacon.setString(1, info.type);
              insertBeacon.setInt(2, info.tier);
              insertBeacon.setLong(3, info.time);
              insertBeacon.setBoolean(4, info.broken);
              insertBeacon.setLong(5, info.brokenTime);
              insertBeacon.setString(6, info.loc.getWorld().getName());
              insertBeacon.setInt(7, info.loc.getBlockX());
              insertBeacon.setInt(8, info.loc.getBlockY());
              insertBeacon.setInt(9, info.loc.getBlockZ());
              insertBeacon.setInt(10, info.hitPoints);
              insertBeacon.setInt(11, info.classnum);
              insertBeacon.execute();
              int lastId = getLastId();
              info.updateCorrectID(lastId);
              for (Location loc : blocklocations){
                      insertBeaconStructure.setInt(1, lastId);
                      insertBeaconStructure.setString(2, loc.getWorld().getName());
                      insertBeaconStructure.setInt(3, loc.getBlockX());
                      insertBeaconStructure.setInt(4, loc.getBlockY());
                      insertBeaconStructure.setInt(5, loc.getBlockZ());
                      insertBeaconStructure.execute();
              }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      
      public void saveAllBeacons(Collection<Info> info){
    	  for (Info in : info){
    		  try {
				updateBeacon.setBoolean(1, in.broken);
	    		updateBeacon.setLong(2, in.brokenTime);
	    		updateBeacon.setInt(3, in.hitPoints);
	    		updateBeacon.setInt(4, in.beaconid);
	    		updateBeacon.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  }
      }
}
