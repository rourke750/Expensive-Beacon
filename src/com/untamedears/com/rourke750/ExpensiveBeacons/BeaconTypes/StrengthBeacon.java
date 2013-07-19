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
					loc.setX(loc.getX()+1);
					loc.setZ(loc.getZ()+1);
					check=loc.getBlock().getType();
					if (check==block){
					loc.setZ(loc.getZ()-2);
					check=loc.getBlock().getType();
					if (check==block){
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
									loc.setX(loc.getX()-1);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setX(loc.getX()-1);
										check=loc.getBlock().getType();
										if (check==block){
											loc.setZ(loc.getZ()+1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setZ(loc.getZ()+1);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setX(loc.getX()+1);
													check=loc.getBlock().getType();
													if (check==block){
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
		level2=0;
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
	public void tier3(Location master){
		int detector=0;
		level3=0;
		Location loc= master.clone();
		Material block= Material.DIAMOND_BLOCK;
		Material check=loc.getBlock().getType();
		loc.setY(loc.getY()-1);
		check=loc.getBlock().getType();
		if (check==block){
			logger.info("line 258");
			loc.setX(loc.getX()-1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(loc.getX()+2);
				check=loc.getBlock().getType();
				if (check==block){
					logger.info("line 270");
					loc.setX(loc.getX()-1);
					loc.setZ(loc.getZ()-1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(loc.getZ()+2);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setY(loc.getY()-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setX(loc.getX()-1);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setZ(loc.getZ()-1);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setZ(loc.getZ()-1);
										check=loc.getBlock().getType();
										if (check==block){
											loc.setX(loc.getX()+1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setX(loc.getX()+1);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setZ(loc.getZ()+1);
													check=loc.getBlock().getType();
													if (check==block){
														loc.setZ(loc.getZ()+1);
														check=loc.getBlock().getType();
														if (check==block){
															loc.setZ(loc.getZ()+1);
															loc.setX(loc.getX()-1);
															check=loc.getBlock().getType();
															if (check==block){
																loc.setX(loc.getX()-2);
																loc.setZ(loc.getZ()-2);
																check=loc.getBlock().getType();
																if (check==block){
																	loc.setZ(loc.getZ()-2);
																	loc.setX(loc.getX()+2);
																	check=loc.getBlock().getType();
																	if (check==block){
																		loc.setX(loc.getX()+2);
																		loc.setZ(loc.getZ()+2);
																		check=loc.getBlock().getType();
																		if (check==block){
																			loc.setY(loc.getY()-1);
																			check=loc.getBlock().getType();
																			if (check==block){
																				loc.setZ(loc.getZ()+1);
																				check=loc.getBlock().getType();
																				if (check==block){
																					loc.setZ(loc.getZ()+1);
																					check=loc.getBlock().getType();
																					if (check==block){
																						loc.setX(loc.getX()-1);
																						check=loc.getBlock().getType();
																						if (check==block){
																							logger.info("line 329");
																							loc.setX(loc.getX()-1);
																							check=loc.getBlock().getType();
																							if (check==block){
																								loc.setX(loc.getX()-1);
																								check=loc.getBlock().getType();
																								if (check==block){
																									loc.setX(loc.getX()-1);
																									check=loc.getBlock().getType();
																									if (check==block){
																										loc.setZ(loc.getZ()-1);
																										check=loc.getBlock().getType();
																										if (check==block){
																											loc.setZ(loc.getZ()-1);
																											check=loc.getBlock().getType();
																											if (check==block){
																												loc.setZ(loc.getZ()-1);
																												check=loc.getBlock().getType();
																												if (check==block){
																													loc.setZ(loc.getZ()-1);
																													check=loc.getBlock().getType();
																													if (check==block){
																														loc.setX(loc.getX()+1);
																														check=loc.getBlock().getType();
																														if (check==block){
																															loc.setX(loc.getX()+1);
																															check=loc.getBlock().getType();
																															if (check==block){
																																loc.setX(loc.getX()+1);
																																check=loc.getBlock().getType();
																																if (check==block){
																																	loc.setX(loc.getX()+1);
																																	check=loc.getBlock().getType();
																																	if (check==block){
																																		loc.setZ(loc.getZ()+1);
																																		check=loc.getBlock().getType();
																																		if (check==block){
																																			loc.setZ(loc.getZ()+1);
																																			loc.setX(loc.getX()+1);
																																			check=loc.getBlock().getType();
																																			if (check==block){
																																				logger.info("line 370");
																																				loc.setY(loc.getY()-1);
																																				loc.setX(loc.getX()+1);
																																				check=loc.getBlock().getType();
																																				if (check==block){
																																					loc.setX(loc.getX()-1);
																																					loc.setZ(loc.getZ()+1);
																																					check=loc.getBlock().getType();
																																					if (check==block){
																																						loc.setZ(loc.getZ()-2);
																																						check=loc.getBlock().getType();
																																						if (check==block){
																																							loc.setZ(loc.getZ()-2);
																																							loc.setX(loc.getX()-2);
																																							check=loc.getBlock().getType();
																																							if (check==block){
																																								logger.info("line 382");
																																								loc.setX(loc.getX()-1);
																																								loc.setZ(loc.getZ()-1);
																																								check=loc.getBlock().getType();
																																								if (check==block){
																																									loc.setY(loc.getY()+1);
																																									loc.setZ(loc.getZ()+1);
																																									check=loc.getBlock().getType();
																																									if (check==block){
																																										loc.setY(loc.getY()-1);
																																										loc.setX(loc.getX()-1);
																																										check=loc.getBlock().getType();
																																										if (check==block){
																																											loc.setX(loc.getX()-2);
																																											loc.setZ(loc.getZ()+2);
																																											check=loc.getBlock().getType();
																																											if (check==block){
																																												loc.setZ(loc.getZ()+1);
																																												loc.setY(loc.getY()+1);
																																												check=loc.getBlock().getType();
																																												if (check==block){
																																													loc.setY(loc.getY()-1);
																																													loc.setX(loc.getX()-1);
																																													check=loc.getBlock().getType();
																																													if (check==block){
																																														logger.info("line 407"+loc);
																																														loc.setZ(loc.getZ()+1);
																																														loc.setX(loc.getX()+1);
																																														check=loc.getBlock().getType();
																																														if (check==block){
																																															logger.info("line 412");
																																															loc.setZ(loc.getZ()+2);
																																															loc.setX(loc.getX()+2);
																																															check=loc.getBlock().getType();
																																															if (check==block){
																																																logger.info("line 417");
																																																loc.setX(loc.getX()+1);
																																																loc.setY(loc.getY()+1);
																																																check=loc.getBlock().getType();
																																																if (check==block){
																																																	logger.info("line 422");
																																																	loc.setY(loc.getY()-1);
																																																	loc.setZ(loc.getZ()+1);
																																																	check=loc.getBlock().getType();
																																																	if (check==block){
																																																		logger.info("line 423");
																																																		loc.setZ(loc.getZ()-1);
																																																		loc.setX(loc.getX()+1);
																																																		check=loc.getBlock().getType();
																																																		if (check==block){
																																																			logger.info("line 430");
																																																			detector++;
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
		if (detector==1){
			level3++;
			loc=master.clone();
			loc.setY(loc.getY()-1);
			tier2(loc);
		}
		else{
			loc=master.clone();
			tier2(loc);
		}
	}
	
	public void tier4(Location master){
		int detector=0;
		level4=0;
		Location loc= master.clone();
		Material block= Material.DIAMOND_BLOCK;
		Material check=loc.getBlock().getType();
		loc.setY(loc.getY()-1);
		check=loc.getBlock().getType();
		if (check==block){
			loc.setY(loc.getY()-1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setZ(loc.getZ()+1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setY(loc.getY()+1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(loc.getZ()+1);
						loc.setY(loc.getY()-1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setY(loc.getY()-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setZ(loc.getZ()+1);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setY(loc.getY()-1);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setZ(loc.getZ()+1);
										check=loc.getBlock().getType();
										if (check==block){
											loc.setY(loc.getY()-1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setZ(loc.getZ()+1);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setY(loc.getY()-1);
													check=loc.getBlock().getType();
													if (check==block){
														loc.setZ(loc.getZ()+1);
														check=loc.getBlock().getType();
														if (check==block){
															loc=master.clone();
															loc.setY(loc.getY()-1);
															loc.setZ(loc.getZ()-1);
															check=loc.getBlock().getType();
															if (check==block){
																loc.setY(loc.getY()-1);
																check=loc.getBlock().getType();
																if (check==block){
																	loc.setZ(loc.getZ()-1);
																	check=loc.getBlock().getType();
																	if (check==block){
																		loc.setY(loc.getY()-1);
																		check=loc.getBlock().getType();
																		if (check==block){
																			loc.setZ(loc.getZ()-1);
																			check=loc.getBlock().getType();
																			if (check==block){
																				loc.setY(loc.getY()-1);
																				check=loc.getBlock().getType();
																				if (check==block){
																					loc.setZ(loc.getZ()-1);
																					check=loc.getBlock().getType();
																					if (check==block){
																						loc.setY(loc.getY()-1);
																						check=loc.getBlock().getType();
																						if (check==block){
																							loc.setZ(loc.getZ()-1);
																							check=loc.getBlock().getType();
																							if (check==block){
																								loc.setY(loc.getY()-1);
																								check=loc.getBlock().getType();
																								if (check==block){
																									loc.setZ(loc.getZ()-1);
																									check=loc.getBlock().getType();
																									if (check==block){
																										loc=master.clone();
																										loc.setY(loc.getY()-1);
																										loc.setX(loc.getX()+1);
																										check=loc.getBlock().getType();
																										if (check==block){
																											loc.setY(loc.getY()-1);
																											check=loc.getBlock().getType();
																											if (check==block){
																												loc.setX(loc.getX()+1);
																												check=loc.getBlock().getType();
																												if (check==block){
																													loc.setY(loc.getY()-1);
																													check=loc.getBlock().getType();
																													if (check==block){
																														loc.setX(loc.getX()+1);
																														check=loc.getBlock().getType();
																														if (check==block){
																															loc.setY(loc.getY()-1);
																															check=loc.getBlock().getType();
																															if (check==block){
																																loc.setX(loc.getX()+1);
																																check=loc.getBlock().getType();
																																if (check==block){
																																	loc.setY(loc.getY()-1);
																																	check=loc.getBlock().getType();
																																	if (check==block){
																																		loc.setX(loc.getX()+1);
																																		check=loc.getBlock().getType();
																																		if (check==block){
																																			loc.setY(loc.getY()-1);
																																			check=loc.getBlock().getType();
																																			if (check==block){
																																				loc.setX(loc.getX()+1);
																																				check=loc.getBlock().getType();
																																				if (check==block){
																																					loc=master.clone();
																																					loc.setY(loc.getY()-1);
																																					loc.setX(loc.getX()-1);
																																					check=loc.getBlock().getType();
																																					if (check==block){
																																						loc.setY(loc.getY()-1);
																																						check=loc.getBlock().getType();
																																						if (check==block){
																																							loc.setX(loc.getX()-1);
																																							check=loc.getBlock().getType();
																																							if (check==block){
																																								loc.setY(loc.getY()-1);
																																								check=loc.getBlock().getType();
																																								if (check==block){
																																									loc.setX(loc.getX()-1);
																																									check=loc.getBlock().getType();
																																									if (check==block){
																																										loc.setY(loc.getY()-1);
																																										check=loc.getBlock().getType();
																																										if (check==block){
																																											loc.setX(loc.getX()-1);
																																											check=loc.getBlock().getType();
																																											if (check==block){
																																												loc.setY(loc.getY()-1);
																																												check=loc.getBlock().getType();
																																												if (check==block){
																																													loc.setX(loc.getX()-1);
																																													check=loc.getBlock().getType();
																																													if (check==block){
																																														loc.setY(loc.getY()-1);
																																														check=loc.getBlock().getType();
																																														if (check==block){
																																															loc.setX(loc.getX()-1);
																																															check=loc.getBlock().getType();
																																															if (check==block){
																																																loc=master.clone();
																																																loc.setY(loc.getY()-3);
																																																loc.setX(loc.getX()-1);
																																																loc.setZ(loc.getZ()-1);
																																																check=loc.getBlock().getType();
																																																if (check==block){
																																																	loc.setY(loc.getY()-1);
																																																	loc.setZ(loc.getZ()-1);
																																																	check=loc.getBlock().getType();
																																																	if (check==block){
																																																		loc.setX(loc.getX()-1);
																																																		check=loc.getBlock().getType();
																																																		if (check==block){
																																																			loc.setZ(loc.getZ()+1);
																																																			check=loc.getBlock().getType();
																																																			if (check==block){
																																																				loc.setY(loc.getY()-1);
																																																				loc.setX(loc.getX()-1);
																																																				check=loc.getBlock().getType();
																																																				if (check==block){
																																																					loc.setZ(loc.getZ()-2);
																																																					check=loc.getBlock().getType();
																																																					if (check==block){
																																																						loc.setX(loc.getX()+2);
																																																						check=loc.getBlock().getType();
																																																						if (check==block){
																																																							loc.setZ(loc.getZ()-1);
																																																							loc.setY(loc.getY()-1);
																																																							check=loc.getBlock().getType();
																																																							if (check==block){
																																																								loc.setX(loc.getX()-1);
																																																								loc.setZ(loc.getZ()+1);
																																																								check=loc.getBlock().getType();
																																																								if (check==block){
																																																									loc.setX(loc.getX()-1);
																																																									loc.setZ(loc.getZ()+1);
																																																									check=loc.getBlock().getType();
																																																									if (check==block){
																																																										loc.setX(loc.getX()-1);
																																																										loc.setZ(loc.getZ()+1);
																																																										check=loc.getBlock().getType();
																																																										if (check==block){
																																																											loc.setZ(loc.getZ()-3);
																																																											loc.setY(loc.getY()+1);
																																																											check=loc.getBlock().getType();
																																																											if (check==block){
																																																												loc.setX(loc.getX()-1);
																																																												loc.setZ(loc.getZ()-1);
																																																												loc.setY(loc.getY()-1);
																																																												check=loc.getBlock().getType();
																																																												if (check==block){
																																																													loc=master.clone();
																																																													loc.setY(loc.getY()-3);
																																																													loc.setX(loc.getX()+1);
																																																													loc.setZ(loc.getZ()-1);
																																																													check=loc.getBlock().getType();
																																																													if (check==block){
																																																														loc.setY(loc.getY()-1);
																																																														loc.setX(loc.getX()+1);
																																																														check=loc.getBlock().getType();
																																																														if (check==block){
																																																															loc.setZ(loc.getZ()-1);
																																																															check=loc.getBlock().getType();
																																																															if (check==block){
																																																																loc.setX(loc.getX()-1);
																																																																check=loc.getBlock().getType();
																																																																if (check==block){
																																																																	loc.setY(loc.getY()-1);
																																																																	loc.setZ(loc.getZ()-1);
																																																																	check=loc.getBlock().getType();
																																																																	if (check==block){
																																																																		loc.setX(loc.getX()+2);
																																																																		check=loc.getBlock().getType();
																																																																		if (check==block){
																																																																			loc.setZ(loc.getZ()+2);
																																																																			check=loc.getBlock().getType();
																																																																			if (check==block){
																																																																				loc.setY(loc.getY()-1);
																																																																				loc.setX(loc.getX()+1);
																																																																				check=loc.getBlock().getType();
																																																																				if (check==block){
																																																																					loc.setZ(loc.getZ()-1);
																																																																					loc.setX(loc.getX()-1);
																																																																					check=loc.getBlock().getType();
																																																																					if (check==block){
																																																																						
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
	
	
	public int getLevel(Location loc){
		tier3(loc);
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
