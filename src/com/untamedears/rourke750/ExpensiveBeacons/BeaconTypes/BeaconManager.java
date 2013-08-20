package com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes;

import java.io.File;
import java.io.IOException;

public class BeaconManager {
	private SpeedBeacon sb;
	private StrengthBeacon strb;
	private RegenBeacon rb;
	private HasteBeacon hb;
	private MegaBeacon mb;
 public BeaconManager (SpeedBeacon speed, StrengthBeacon strength, RegenBeacon regen, HasteBeacon haste, MegaBeacon sup){
	 sb=speed;
	 strb=strength;
	 rb=regen;
	 hb=haste;
	 mb=sup;
 }
 	public void CreateBeaconFiles(File file, String type) throws IOException{
 		if (type.equals("speed_structure1.txt")){
 			sb.Beacons1(file);
 		}
 		if (type.equals("speed_structure2.txt")){
 			sb.Beacons2(file);
 		}
 		if (type.equals("speed_structure3.txt")){
 			sb.Beacons3(file);
 		}
 		if (type.equals("speed_structure4.txt")){
 			sb.Beacons4(file);
 		}
 		if (type.equals("speed_structure5.txt")){
 			sb.Beacons5(file);
 		}
 		if (type.equals("strength_structure1.txt")){
 			strb.Beacons1(file);
 		}
 		if (type.equals("strength_structure2.txt")){
 			strb.Beacons2(file);
 		}
 		if (type.equals("strength_structure3.txt")){
 			strb.Beacons3(file);
 		}
 		if (type.equals("strength_structure4.txt")){
 			strb.Beacons4(file);
 		}
 		if (type.equals("strength_structure5.txt")){
 			strb.Beacons5(file);
 		}
 		if (type.equals("regen_structure1.txt")){
 			rb.Beacons1(file);
 		}
 		if (type.equals("regen_structure2.txt")){
 			rb.Beacons2(file);
 		}
 		if (type.equals("regen_structure3.txt")){
 			rb.Beacons3(file);
 		}
 		if (type.equals("regen_structure4.txt")){
 			rb.Beacons4(file);
 		}
 		if (type.equals("regen_structure5.txt")){
 			rb.Beacons5(file);
 		}
 		if (type.equals("haste_structure1.txt")){
 			hb.Beacons1(file);
 		}
 		if (type.equals("haste_structure2.txt")){
 			hb.Beacons2(file);
 		}
 		if (type.equals("haste_structure3.txt")){
 			hb.Beacons3(file);
 		}
 		if (type.equals("haste_structure4.txt")){
 			hb.Beacons4(file);
 		}
 		if (type.equals("haste_structure5.txt")){
 			hb.Beacons5(file);
 		}
 		if (type.equals("super_structure.txt")){
 			mb.Beacons(file);
 		}
 		
 	}
}
