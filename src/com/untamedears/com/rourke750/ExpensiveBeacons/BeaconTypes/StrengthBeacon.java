package com.untamedears.com.rourke750.ExpensiveBeacons.BeaconTypes;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;

import com.untamedears.rourke750.ExpensiveBeacons.ExpensiveBeaconsplugin;

public class StrengthBeacon {
	Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
	private int level=0;
	private int level1=0;
	private int level2=0;
	private int level3=0;
	private int level4=0;
	private int level5=0;
	public void tier1(Location master){
		logger.info("Strength started");
		level1=0;
		Location loc= master.clone();
		Material block= Material.DIAMOND_BLOCK;
		Material check=loc.getBlock().getType();
		loc.setY(loc.getY()-1);
		check=loc.getBlock().getType();
		if (check==block){
			loc.setX(loc.getX()+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(loc.getX()-2);
				check=loc.getBlock().getType();
				if (check==block){
					logger.info("Strength line 33");
					loc.setX(loc.getX()+1);
					loc.setZ(loc.getZ()+1);
					check=loc.getBlock().getType();
					if (check==block){
					loc.setZ(loc.getZ()-2);
					check=loc.getBlock().getType();
					if (check==block){
						logger.info("Strength line 41"+loc);
						loc=master.clone();
						loc.setY(loc.getY()-2);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setX(loc.getX()+1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setZ(loc.getZ()-1);
								check=loc.getBlock().getType();
								if (check==block){
									logger.info("Strength line 52");
									loc.setX(loc.getX()-1);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setX(loc.getX()-1);
										check=loc.getBlock().getType();
										if (check==block){
											logger.info("Strength line 59");
											loc.setZ(loc.getZ()+1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setZ(loc.getZ()+1);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setX(loc.getX()+1);
													check=loc.getBlock().getType();
													if (check==block){
														logger.info("Strength line 69");
														loc.setX(loc.getX()+1);
														check=loc.getBlock().getType();
														if (check==block){
															loc.setX(loc.getX()+1);
															loc.setZ(loc.getZ()+1);
															check=loc.getBlock().getType();
															if (check==block){
																loc.setX(loc.getX()-2);
																check=loc.getBlock().getType();
																if (check==block){
																	loc.setX(loc.getX()-2);
																	check=loc.getBlock().getType();
																	if (check==block){
																		loc.setZ(loc.getZ()-2);
																		check=loc.getBlock().getType();
																		if (check==block){
																			loc.setZ(loc.getZ()-2);
																			check=loc.getBlock().getType();
																			if (check==block){
																				loc.setX(loc.getX()+2);
																				check=loc.getBlock().getType();
																				if (check==block){
																					loc.setX(loc.getX()+2);
																					check=loc.getBlock().getType();
																					if (check==block){
																						loc.setZ(loc.getZ()+2);
																						check=loc.getBlock().getType();
																						if (check==block){
																							loc.setZ(loc.getZ()+3);
																							loc.setX(loc.getX()+1);
																							check=loc.getBlock().getType();
																							if (check==block){
																								loc.setZ(loc.getZ()-6);
																								check=loc.getBlock().getType();
																								if (check==block){
																									loc.setX(loc.getX()-6);
																									check=loc.getBlock().getType();
																									if (check==block){
																										loc.setZ(loc.getZ()+6);
																										check=loc.getBlock().getType();
																										if (check==block){
																											logger.info("Bean tier 1 Strength finished");
																											level1++;
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					}
				}
			}
		}
	}
	public void tier2(Location master){
		int detector=0;
		level1=0;
		Location loc= master.clone();
		Material block= Material.DIAMOND_BLOCK;
		Material check=loc.getBlock().getType();
		loc.setY(loc.getY()-1);
		check=loc.getBlock().getType();
		if (check==block){
			loc.setY(loc.getBlockY()-1);
			loc.setX(loc.getX()-1);
			loc.setZ(loc.getZ()+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(loc.getX()+2);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setZ(loc.getZ()-2);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setX(loc.getX()-2);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setY(loc.getY()-1);
							loc.setX(loc.getX()-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setZ(loc.getZ()+2);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setZ(loc.getZ()+1);
									loc.setX(loc.getX()+1);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setX(loc.getX()+2);
										check=loc.getBlock().getType();
										if (check==block){
											loc.setX(loc.getX()+1);
											loc.setZ(loc.getZ()-1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setZ(loc.getZ()-2);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setZ(loc.getZ()-1);
													loc.setX(loc.getX()-1);
													check=loc.getBlock().getType();
													if (check==block){
														loc.setX(loc.getX()-2);
														check=loc.getBlock().getType();
														if (check==block){
															loc.setZ(loc.getZ()-1);
															loc.setX(loc.getX()+1);
															check=loc.getBlock().getType();
															if (check==block){
																loc.setX(loc.getX()+3);
																loc.setZ(loc.getZ()+3);
																check=loc.getBlock().getType();
																if (check==block){
																	loc.setZ(loc.getZ()+3);
																	loc.setX(loc.getX()-3);
																	check=loc.getBlock().getType();
																	if (check==block){
																		loc.setX(loc.getX()-3);
																		loc.setZ(loc.getZ()-3);
																		check=loc.getBlock().getType();
																		if (check==block){
																			loc.setX(loc.getX()-1);
																			loc.setZ(loc.getZ()-4);
																			check=loc.getBlock().getType();
																			if (check==block){
																				loc.setX(loc.getX()+8);
																				check=loc.getBlock().getType();
																				if (check==block){
																					loc.setZ(loc.getZ()+8);
																					check=loc.getBlock().getType();
																					if (check==block){
																						loc.setX(loc.getX()-8);
																						check=loc.getBlock().getType();
																						if (check==block){
																							detector++;
																							level2=1;
																							loc=master.clone();
																
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (detector==1){
			loc=master.clone();
			loc.setY(loc.getY()-1);
			tier1(loc);
		}
		else {
			loc=master.clone();
			tier1(loc);
		}
	}
	
	
	
	
	
	public int getLevel(Location loc){
		tier2(loc);
		if (level5==1 && level4==1 && level3==1 && level2==1 && level1==1){
			level=5;
			return level;
		}
		if (level4==1 && level3==1 && level2==1 && level1==1){
			level=4;
			return level;
		}
		if (level3==1 && level2==1 && level1==1){
			level=3;
			return level;
		}
		if (level2==1 && level1==1){
			level=2;
			return level;
		}
		if (level1==1){
			level=1;
			return level;
		}
		else {
			logger.info("Returned 0"+level);
			level=0;
			return level;
		}
	}
}
