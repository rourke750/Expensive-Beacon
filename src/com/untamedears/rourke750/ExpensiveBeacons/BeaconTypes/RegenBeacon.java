package com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RegenBeacon {
	public void Beacons1(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos));
		br.append("(0,-1,0)[57:0];(0,-2,0)[57:0];(0,-3,0)[57:0];(-1,-1,0)[57:0];(-1,-2,0)[57:0];(-1,-3,0)[57:0];"+
		"(1,-1,0)[57:0];(1,-2,0)[57:0];(1,-3,0)[57:0];(2,-1,-2)[57:0];(2,-2,-2)[57:0];(2,-3,-2)[57:0];(2,-1,2)[57:0];"+
		"(2,-2,2)[57:0];(2,-3,2)[57:0];(-1,-1,0)[57:0];(-1,-2,0)[57:0];(-1,-3,0)[57:0];(-2,-2,0)[57:0];(-2,-3,0)[57:0];"+
		"(-1,-2,-1)[57:0];(-1,-3,-1)[57:0];(-1,-2,1)[57:0];(-1,-3,1)[57:0];(0,-2,2)[57:0];(0,-3,2)[57:0];(0,-2,-2)[57:0];"+
		"(0,-3,-2)[57:0];(1,-2,0)[57:0];(1,-3,0)[57:0];(1,-2,1)[57:0];(1,-3,1)[57:0];(1,-2,-1)[57:0];(1,-3,-1)[57:0];"+
		"(2,-2,-2)[57:0];(2,-3,-2)[57:0];(2,-2,2)[57:0];(2,-3,2)[57:0];(1,-2,-3)[57:0];(1,-3,-3)[57:0];(1,-2,3)[57:0];"+
		"(1,-3,3)[57:0];(1,-2,3)[57:0];(1,-2,3)[57:0];(2,-2,-3)[57:0];(-2,-3,-3)[57:0];(2,-2,-4)[57:0];(2,-2,4)[57:0];"+
		"(2,-3,-4)[57:0];(2,-3,4)[57:0];(0,-3,-3)[57:0];(0,-3,-4)[57:0];(-1,-3,2)[57:0];(-1,-3,-2)[57:0];(-2,-3,-1)[57:0];"+
		"(-2,-3,1)[57:0];(0,-3,-3)[57:0];(0,-3,-4)[57:0];(1,-3,4)[57:0];(1,-3,-4)[57:0];(2,-3,0)[57:0];(2,-3,1)[57:0];"+
		"(2,-3,-1)[57:0];(3,-3,2)[57:0];(3,-3,-2)[57:0];(3,-3,3)[57:0];(3,-3,-3)[57:0];(3,-3,4)[57:0];(3,-3,-4)[57:0];"+
		"(3,-3,5)[57:0];(3,-3,-5)[57:0];(2,-3,-5)[57:0];(2,-3,5)[57:0]");
	}
	public void Beacons2(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos));
		
	}
	public void Beacons3(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos));
		
	}
	public void Beacons4(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos));
		
	}
	public void Beacons5(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos));
		
	}
}
