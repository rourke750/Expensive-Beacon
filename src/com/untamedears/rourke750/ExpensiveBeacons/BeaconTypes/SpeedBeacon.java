package com.untamedears.com.rourke750.ExpensiveBeacons.BeaconTypes;



import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;

import com.untamedears.rourke750.ExpensiveBeacons.ExpensiveBeaconsplugin;

public class SpeedBeacon {
	Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
	private int level=0;
	private int level1=0;
	private int level2=0;
	private int level3=0;
	private int level4=0;
	private int level5=0;
	public void tier1(Location master){
		level1=0;
		Location loc= master.clone();
		logger.info("Location of tier 1"+loc);
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		loc.setY(loc.getY()-1);
		Material check=loc.getBlock().getType();
		logger.info(loc.toString());
		if (check==block){
			logger.info("Went through the first if");
			loc.setX(loc.getX()+1);//
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(loc.getX()+1);//
				check=loc.getBlock().getType();
				if (check==block){
					loc.setX(loc.getX()+1);//
					check=loc.getBlock().getType();
					if (check==block){
						loc.setX(loc.getX()-1);
						loc.setZ(loc.getZ()+1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setZ(loc.getZ()-2);//
							check=loc.getBlock().getType();
							if (check==block){
								detector++;
								logger.info("Ending of the if loc "+loc.toVector());
								loc=master.clone();
								loc.setY(loc.getY()-1);
								loc.setX(loc.getX()-1);
								check=loc.getBlock().getType();
								logger.info("First check complete\n"+loc.toVector());
								if (check==block){
									logger.info("first else if");
									loc.setX(loc.getX()-1);
									check=loc.getBlock().getType();
									if (check==block){
										logger.info("line 57");
										loc.setZ(loc.getZ()+1);
										check=loc.getBlock().getType();
										if (check==block){
											logger.info("line 61");
											loc.setZ(loc.getZ()-2);
											check=loc.getBlock().getType();
											if (check==block){
												logger.info("line 65");
												loc.setZ(loc.getZ()+1);
												loc.setX(loc.getX()-1);
												check=loc.getBlock().getType();
												if (check==block){
													logger.info("line 70");
													detector++;
													loc=master.clone();
													loc.setY(loc.getY()-1);
													loc.setZ(loc.getZ()+1);
													check=loc.getBlock().getType();
													logger.info("Second check complete"+loc.toString()+master.toString());
													if (check==block){ logger.info("line 72");
														loc.setZ(loc.getZ()+1);
														check=loc.getBlock().getType();
														if (check==block){
															loc.setX(loc.getX()-1);
															check=loc.getBlock().getType();
															if (check==block){
																logger.info("Line 79");
																loc.setX(loc.getX()+2);
																check=loc.getBlock().getType();
																if (check==block){
																	logger.info("Line 83");
																	loc.setX(loc.getX()-1);
																	loc.setZ(loc.getZ()+1);
																	check=loc.getBlock().getType();
																	if (check==block){
																		logger.info("Line 88");
																		detector++;
																		loc=master.clone();
																		loc.setY(loc.getY()-1);
																		loc.setZ(loc.getZ()-1);
																		check=loc.getBlock().getType();
																		logger.info("Third check complete");
																		if (check==block){
																			logger.info("line 96");
																			loc.setZ(loc.getZ()-1);
																			check=loc.getBlock().getType();
																			if (check==block){
																				logger.info("line 100");
																				loc.setZ(loc.getZ()-1);
																				check=loc.getBlock().getType();
																				if (check==block){
																					logger.info("line 104");
																					loc.setZ(loc.getZ()+1);
																					loc.setX(loc.getX()+1);
																					check=loc.getBlock().getType();
																					if (check==block){
																						logger.info("line 109");
																						loc.setX(loc.getX()-2);
																						check=loc.getBlock().getType();
																							if (check==block){
																								logger.info("line 113");
																								detector++;
																								loc=master.clone();
																								check=loc.getBlock().getType();
																								logger.info("Fourth check complete");
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

		
		
		if (detector==4){
			logger.info("Beacon Form was correct");
			level1++;
		}
		else {logger.info("Beacon Form was incorrect");
			}
	}
	public void tier2(Location master){
		level2=0;
		Location loc= master.clone();
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		loc.setY(loc.getY()-1);
		Material check=loc.getBlock().getType();
		if (check==block){
			logger.info("line 164");
			loc.setY(loc.getY()-1);
			loc.setX(loc.getX()+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(loc.getX()-2);
				check=loc.getBlock().getType();
				if (check==block){
					logger.info("Line 172"+loc);
					loc.setX(loc.getX()+1);
					loc.setZ(loc.getZ()+1);
					check=loc.getBlock().getType();
					if (check==block){
						logger.info("Line 177"+loc);
						loc.setZ(loc.getZ()-2);
						check=loc.getBlock().getType();
						if (check==block){
							logger.info("Line 181"+loc);
							detector++;
							loc.setY(loc.getY()-1);
							loc.setZ(loc.getZ()-1);
							check=loc.getBlock().getType();
							if (check==block){
								logger.info("Line 185"+loc);
								loc.setZ(loc.getZ()+2);
								loc.setX(loc.getX()-2);
								check=loc.getBlock().getType();
								if (check==block){
									logger.info("Line 192"+loc);
									loc.setZ(loc.getZ()+2);
									loc.setX(loc.getX()+2);
									check=loc.getBlock().getType();
									if (check==block){
										logger.info("Line 196"+loc);
										loc.setZ(loc.getZ()-2);
										loc.setX(loc.getX()+2);
										check=loc.getBlock().getType();
										if (check==block){
											loc.setY(loc.getY()-1);
											loc.setX(loc.getX()+1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setZ(loc.getZ()-3);
												loc.setX(loc.getX()-3);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setX(loc.getX()-3);
													loc.setZ(loc.getZ()+3);
													check=loc.getBlock().getType();
													if (check==block){
														loc.setZ(loc.getZ()+3);
														loc.setX(loc.getX()+3);
														check=loc.getBlock().getType();
														if (check==block){
												logger.info("Tier 2 ended line 199"+detector);
												detector++;
											}}}}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		
		if (detector==2){
			loc=master.clone();
			loc.setY(loc.getY()-4);
			level2++;
			logger.info("location of tier 2 beacon becomign beacon one"+loc);
			tier1(loc);
		}
		else {
			loc=master.clone();
			tier1(loc);}
	}
	public void tier3(Location master){
		level3=0;
		Location loc=master.clone();
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		loc.setY(loc.getY()-1);
		logger.info("Tier 3 start "+loc);
		Material check=loc.getBlock().getType();
		if (check==block){
			logger.info("Line 208");
			loc.setX(loc.getX()+3);
			loc.setZ(loc.getZ()-3);
			check=loc.getBlock().getType();
			if(check==block){
				logger.info("Line 214");
				loc.setY(loc.getY()-1);
				check=loc.getBlock().getType();
				if (check==block){
					logger.info("Line 218");
					loc.setY(loc.getY()-1);
					check=loc.getBlock().getType();
					if (check==block){
						logger.info("Line 222");
						loc.setY(loc.getY()-1);
						check=loc.getBlock().getType();
						if (check==block){
							logger.info("Line 226");
							loc.setY(loc.getY()-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setX(loc.getX()-1);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setX(loc.getX()-1);
									check=loc.getBlock().getType();
									if (check==block){
									loc.setX(loc.getX()-2);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setX(loc.getX()-1);
										check=loc.getBlock().getType();
										if (check==block){
											logger.info("Line 239"+loc);
											loc.setX(loc.getX()-1);
											check=loc.getBlock().getType();
											if (check==block){
												logger.info("Line 243"+loc);
												loc.setY(loc.getY()+1);
												check=loc.getBlock().getType();
												if (check==block){
													logger.info("Line 247"+loc);
													loc.setY(loc.getY()+1);
													check=loc.getBlock().getType();
													if (check==block){
														logger.info("Line 249");
														loc.setY(loc.getY()+1);
														check=loc.getBlock().getType();
														if (check==block){
															loc.setY(loc.getY()+1);
															check=loc.getBlock().getType();
															if (check==block){
																loc.setZ(loc.getZ()+6);
																check=loc.getBlock().getType();
																if (check==block){
																	logger.info("Line 259");
																	loc.setY(loc.getY()-1);
																	check=loc.getBlock().getType();
																	if (check==block){
																		loc.setY(loc.getY()-1);
																		check=loc.getBlock().getType();
																		if (check==block){
																			loc.setY(loc.getY()-1);
																			check=loc.getBlock().getType();
																			if (check==block){
																				logger.info("Line 274");
																				loc.setY(loc.getY()-1);
																				check=loc.getBlock().getType();
																				if (check==block){
																					loc.setZ(loc.getZ()-1);
																					check=loc.getBlock().getType();
																					if (check==block){
																						logger.info("Line 281");
																						loc.setZ(loc.getZ()-1);
																						check=loc.getBlock().getType();
																						if (check==block){
																							loc.setZ(loc.getZ()-2);
																							check=loc.getBlock().getType();
																							if (check==block){
																								loc.setZ(loc.getZ()-1);
																								check=loc.getBlock().getType();
																								if (check==block){
																									logger.info("Line 291");
																									loc.setZ(loc.getZ()+5);
																									loc.setX(loc.getX()+1);
																									check=loc.getBlock().getType();
																									if (check==block){
																										logger.info("Line 296");
																										loc.setX(loc.getX()+1);
																										check=loc.getBlock().getType();
																										if (check==block){
																											loc.setX(loc.getX()+2);
																											check=loc.getBlock().getType();
																											if (check==block){
																												logger.info("Line 303");
																												loc.setX(loc.getX()+1);
																												check=loc.getBlock().getType();
																												if (check==block){
																													logger.info("Line 307");
																													loc.setX(loc.getX()+1);
																													check=loc.getBlock().getType();
																													if (check==block){
																														loc.setY(loc.getY()+1);
																														check=loc.getBlock().getType();
																														if (check==block){
																															logger.info("Line 314");
																															loc.setY(loc.getY()+1);
																															check=loc.getBlock().getType();
																															if (check==block){
																																logger.info("Line 318");
																																loc.setY(loc.getY()+1);
																																check=loc.getBlock().getType();
																																if (check==block){
																																	loc.setY(loc.getY()+1);
																																	check=loc.getBlock().getType();
																																	if (check==block){
																																		logger.info("Line 325"+loc);
																																		loc.setY(loc.getY()-4);
																																		loc.setZ(loc.getZ()-1);
																																		check=loc.getBlock().getType();
																																		if (check==block){
																																			logger.info("Line 330");
																																			loc.setZ(loc.getZ()-1);
																																			check=loc.getBlock().getType();
																																			if (check==block){
																																				logger.info("Line 334");
																																				loc.setZ(loc.getZ()-2);
																																				check=loc.getBlock().getType();
																																				if (check==block){
																																					logger.info("Line 238");
																																					loc.setZ(loc.getZ()-1);
																																					check=loc.getBlock().getType();
																																					if (check==block){
																																						detector++;
																																						logger.info("Line 343"+detector);
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
						}}}}}}
							
	if (detector==1){
		logger.info("Tier3 finished");
		loc=master.clone();
		check=loc.getBlock().getType();
			level3++;
			tier2(loc);
		}
		else {
			loc=master.clone();
			check=loc.getBlock().getType();
			tier2(loc);}
	}
	public void tier4(Location master){
		level4=0;
		logger.info("Tier 4 made it");
		Location loc= master.clone();
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		Material check=loc.getBlock().getType();
		logger.info("Line 383 cords"+loc);
		for (int i=1; i<=2; i++){
		loc.setY(loc.getY()-i);
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
						loc.setZ(loc.getZ()-2);//
						if (check==block){
							loc.setX(loc.getX()-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setX(loc.getX()+2);//
								check=loc.getBlock().getType();
								if (check==block){
									loc.setZ(loc.getZ()+2);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setX(loc.getX()-2);
										check=loc.getBlock().getType();
										if (check==block){
											loc=master.clone();
											detector++;
											logger.info("For statement, line 414"+loc);
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
		loc=master.clone();
		logger.info("Line 426"+loc);
		loc.setY(loc.getY()-3);
		check=loc.getBlock().getType();
		if(check==block){
			logger.info("Line 426 made it");
			loc.setY(loc.getY()-1);
			check=loc.getBlock().getType();
			logger.info("The current location"+loc);
			if(check==block){
				loc=master.clone();
				loc.setY(loc.getY()-3);
				loc.setZ(loc.getZ()+2);
				loc.setX(loc.getX()+2);
				logger.info("Line 439"+loc);//I left off here 
				check=loc.getBlock().getType();
				if(check==block){
					loc.setZ(loc.getZ()-4);
					check=loc.getBlock().getType();
					if(check==block){
						loc.setX(loc.getX()-4);
						check=loc.getBlock().getType();
						if(check==block){
							loc.setZ(loc.getZ()+4);
							check=loc.getBlock().getType();
							if(check==block){
								logger.info("Line 451");
								loc=master.clone();
								detector++;
								loc.setY(loc.getY()-4);
								loc.setZ(loc.getZ()+3);
								loc.setX(loc.getX()-3);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setZ(loc.getZ()-6);
									check=loc.getBlock().getType();
									if(check==block){
										logger.info("line 455 made it");
										loc.setX(loc.getX()+6);
										check=loc.getBlock().getType();
										if(check==block){
											loc.setZ(loc.getZ()+6);
											check=loc.getBlock().getType();
											if(check==block){
												loc.setY(loc.getY()-1);//
												detector++;
												check=loc.getBlock().getType();
												if (check==block){
													logger.info("line 473 made it"+loc);
													loc.setX(loc.getX()-1);//
													check=loc.getBlock().getType();
													if(check==block){
														logger.info("Line 477 made it");
															loc.setX(loc.getX()-1);//
															check=loc.getBlock().getType();
															if(check==block){
																logger.info("Line 480");
																loc.setX(loc.getX()-1);//
																check=loc.getBlock().getType();
																if(check==block){
																	loc.setX(loc.getX()-1);//
																	check=loc.getBlock().getType();
																	if(check==block){
																		logger.info("line 487 made it");
																		loc.setX(loc.getX()-1);//
																		check=loc.getBlock().getType();
																		if(check==block){
																			loc.setX(loc.getX()-1);//
																			check=loc.getBlock().getType();
																		if(check==block){
																			logger.info("Line 495");
																			loc.setZ(loc.getZ()-1);
																			check=loc.getBlock().getType();
																			if(check==block){
																				loc.setZ(loc.getZ()-1);
																				check=loc.getBlock().getType();
																				if(check==block){
																					logger.info("Line 502");
																					loc.setZ(loc.getZ()-1);
																					check=loc.getBlock().getType();
																					if(check==block){
																						loc.setZ(loc.getZ()-1);
																						check=loc.getBlock().getType();
																						if(check==block){
																							loc.setZ(loc.getZ()-1);
																							check=loc.getBlock().getType();
																							logger.info("Line 511"+loc);
																								detector++;
																								if(check==block){
																									if(check==block){
																										loc.setZ(loc.getZ()-1);
																										check=loc.getBlock().getType();
																									logger.info("Line 514"+loc);
																									loc.setX(loc.getX()+1);
																									check=loc.getBlock().getType();
																									if(check==block){
																										logger.info("Line 516");
																										loc.setX(loc.getX()+1);
																										check=loc.getBlock().getType();
																										if(check==block){
																											loc.setX(loc.getX()+1);
																											check=loc.getBlock().getType();
																											if(check==block){
																												loc.setX(loc.getX()+1);
																												check=loc.getBlock().getType();
																												if(check==block){
																													loc.setX(loc.getX()+1);
																													check=loc.getBlock().getType();
																													if(check==block){
																														loc.setX(loc.getX()+1);
																														check=loc.getBlock().getType();
																														if(check==block){
																															loc.setZ(loc.getZ()+1);
																															check=loc.getBlock().getType();
																															if(check==block){
																																loc.setZ(loc.getZ()+1);
																																check=loc.getBlock().getType();
																																if(check==block){
																																	loc.setZ(loc.getZ()+1);
																																	check=loc.getBlock().getType();
																																	if(check==block){
																																		loc.setZ(loc.getZ()+1);
																																		check=loc.getBlock().getType();
																																		if(check==block){
																																			loc.setZ(loc.getZ()+1);
																																			check=loc.getBlock().getType();
																																			if(check==block){
																																				loc.setZ(loc.getZ()+1);
																																				check=loc.getBlock().getType();
																																				if(check==block){
																																					logger.info("Line 555."+loc);//left off here
																																					loc.setX(loc.getX()-3);
																																					detector++;
																																					check=loc.getBlock().getType();
																																					if (check==block){
																																						logger.info("Line 560."+loc);
																																						loc.setY(loc.getY()-1);
																																						check=loc.getBlock().getType();
																																						if(check==block){
																																							logger.info("Line 564"+loc);
																																							loc.setX(loc.getX()-3);
																																							loc.setZ(loc.getZ()-3);
																																							check=loc.getBlock().getType();
																																							if(check==block){
																																								logger.info("Line 569");
																																								loc.setY(loc.getY()+1);
																																								check=loc.getBlock().getType();
																																								if(check==block){
																																									logger.info("Line 573.");
																																									loc.setZ(loc.getZ()-3);
																																									loc.setX(loc.getX()+3);
																																									check=loc.getBlock().getType();
																																									if(check==block){
																																										logger.info("Line 578.");
																																										loc.setY(loc.getY()-1);
																																										check=loc.getBlock().getType();
																																										if(check==block){
																																											loc.setX(loc.getX()+3);
																																											loc.setZ(loc.getZ()+3);
																																											check=loc.getBlock().getType();
																																											if(check==block){
																																												loc.setY(loc.getY()+1);
																																												check=loc.getBlock().getType();
																																												if(check==block){
																																													detector++;
																																													logger.info("Tier4 finished"+detector);
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
																			}}
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
							}}
						}
		}
		if (detector==7){
			logger.info("tier 4 is correct");
			loc=master.clone();
			loc.setY(loc.getY()-4);
			level4++;
			tier3(loc);
		}
		else {
			loc=master.clone();
			tier3(loc);}
	}
	public void tier5(Location master){
		level5=0;
		Location loc= master.clone();
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		loc.setY(loc.getY()-1);
		Material check=loc.getBlock().getType();
		if (check==block){
			loc.setY(loc.getY()-1);
		
			if (check==block){
			loc.setY(loc.getY()-1);
			loc.setZ(loc.getZ()-1);
			loc.setX(loc.getX()+1);
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
							loc.setZ(loc.getZ()-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setZ(loc.getZ()-1);
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
												loc.setZ(loc.getZ()+1);
												loc.setX(loc.getX()-3);
												detector++;
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
																	loc.setZ(loc.getZ()-1);
																	check=loc.getBlock().getType();
																	if (check==block){
																		loc.setZ(loc.getZ()-1);
																		check=loc.getBlock().getType();
																		if (check==block){
																			loc.setZ(loc.getZ()-1);
																			check=loc.getBlock().getType();
																			if (check==block){
																				check=loc.getBlock().getType();
																				if (check==block){
																					loc.setZ(loc.getZ()-1);
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
																								detector++;
																								if (check==block){
																									loc.setZ(loc.getZ()+1);
																									check=loc.getBlock().getType();
																									if (check==block){
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
																																				loc.setX(loc.getX()-1);
																																				check=loc.getBlock().getType();
																																				if (check==block){
																																					loc.setZ(loc.getZ()-1);
																																					check=loc.getBlock().getType();
																																					if (check==block){
																																						loc.setZ(loc.getZ()-2);
																																						loc.setY(loc.getY()-1);
																																						loc.setX(loc.getX()-2);
																																						check=loc.getBlock().getType();
																																						detector++;
																																						if (check==block){
																																							loc.setY(loc.getY()-1);
																																							check=loc.getBlock().getType();
																																							if (check==block){
																																								check=loc.getBlock().getType();
																																								if (check==block){
																																									loc.setY(loc.getY()-1);
																																									check=loc.getBlock().getType();
																																									if (check==block){
																																										loc.setZ(loc.getZ()+6);
																																										check=loc.getBlock().getType();
																																										if (check==block){
																																											loc.setY(loc.getY()+1);
																																											check=loc.getBlock().getType();
																																											if (check==block){
																																												loc.setY(loc.getY()+1);
																																												check=loc.getBlock().getType();
																																												if (check==block){
																																													loc.setX(loc.getX()+6);
																																													check=loc.getBlock().getType();
																															                                                        if (check==block){
																																														loc.setY(loc.getY()-1);
																																														check=loc.getBlock().getType();
																																														if (check==block){
																																															check=loc.getBlock().getType();
																																															if (check==block){
																																																loc.setY(loc.getY()-1);
																																																check=loc.getBlock().getType();
																																																if (check==block){
																																																	loc.setZ(loc.getZ()-6);
																																																	check=loc.getBlock().getType();
																																																	if (check==block){
																																																		loc.setY(loc.getY()+1);
																																																		check=loc.getBlock().getType();
																																																		if (check==block){
																																																			loc.setY(loc.getY()+1);
																																																			check=loc.getBlock().getType();
																																																			if (check==block){
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
		}}
		
		
		if (detector==4){
			loc=master.clone();
			loc.setY(loc.getY()-3);
			logger.info("Tier 5 is correct you fuckers");
			level5++;
			tier4(loc);
		}
		else{
			loc=master.clone();
			logger.info("Tier 5 is incorrect"+detector);
			tier4(loc);}
	}
	public int getLevel(Location loc){
		logger.info("getlevel in speedbeacon.java ran successfully."+loc);
		tier5(loc);
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