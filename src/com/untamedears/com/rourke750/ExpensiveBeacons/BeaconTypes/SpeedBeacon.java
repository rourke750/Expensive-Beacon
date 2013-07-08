package com.untamedears.com.rourke750.ExpensiveBeacons.BeaconTypes;



import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;

import com.untamedears.rourke750.ExpensiveBeacons.ExpensiveBeaconsplugin;

public class SpeedBeacon {
	private int level=0;
	public void tier1(Location loc){
		Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
		Location master= loc.clone();
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
			level++;
		}
		else {logger.info("Beacon Form was incorrect");
			}
	}
	public void tier2(Location loc){
		Location master= loc;
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		loc.setY(-1);
		Material check=loc.getBlock().getType();
		if (check==block){
			loc.setY(-1);
			loc.setX(+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(-2);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setX(+1);
					loc.setZ(+1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(-2);
						check=loc.getBlock().getType();
						if (check==block){
							loc=master;
							loc.setY(-3);
							loc.setX(+2);
							detector++;
							check=loc.getBlock().getType();
						}
					}
				}
			}
		}
		else if (check==block){
				loc.setX(-4);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setX(+2);
					loc.setZ(+2);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(-4);
						check=loc.getBlock().getType();
						if (check==block){
							loc=master;
							loc.setY(-4);
							loc.setX(+3);
							detector++;
							check=loc.getBlock().getType();
						}
					}
				}
			}
		else if (check==block){
			loc.setX(-6);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(+3);
				loc.setZ(+3);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setZ(-6);
					check=loc.getBlock().getType();
					if (check==block){
						loc=master;
						loc.setY(-4);
						detector++;
						check=loc.getBlock().getType();
					}
				}
			}
		}
		if (detector==3){
			level++;
			tier1(loc);
		}
		else {tier1(loc);}
	}
	public void tier3(Location loc){
		Location master= loc;
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		loc.setY(-1);
		Material check=loc.getBlock().getType();
		if (check==block){
			loc.setX(+3);
			loc.setZ(-3);
			check=loc.getBlock().getType();
			if(check==block){
				loc.setY(-1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setY(-1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setY(-1);
						check=loc.getBlock().getType();
						if (check==block){
							detector++;
							loc=master;
							loc.setZ(+3);
							loc.setX(+3);
							check=loc.getBlock().getType();
						}
					}
				}
			}
		}
		else if (check==block){
			loc.setY(-1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setY(-1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setY(-1);
					check=loc.getBlock().getType();
					if (check==block){
						detector++;
						loc=master;
						loc.setX(-3);
						loc.setZ(+3);
						check=loc.getBlock().getType();
					}
				}
			}
		}
		else if (check==block){
			loc.setY(-1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setY(-1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setY(-1);
					check=loc.getBlock().getType();
					if (check==block){
						detector++;
						loc=master;
						loc.setX(-3);
						loc.setZ(-3);
						check=loc.getBlock().getType();
					}
				}
			}
		}
		else if (check==block){
			loc.setY(-1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setY(-1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setY(-1);
					check=loc.getBlock().getType();
					if (check==block){
						detector++;
						loc=master;
						loc.setX(+3);
						loc.setZ(+3);
						loc.setY(-4);
						check=loc.getBlock().getType();
					}
				}
			}
		}
		else if (check==block){
			loc.setZ(-1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setZ(-1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setZ(-2);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(-1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setZ(-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setX(+1);
								detector++;
								check=loc.getBlock().getType();
							}
						}
					}
				}
			}
		}
		else if (check==block){
			loc.setX(+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(+2);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setX(+1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setX(+1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setZ(+1);
							detector++;
							check=loc.getBlock().getType();
						}
					}
				}
			}
		}
		else if (check==block){
			loc.setZ(+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setZ(+2);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setZ(+1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(+1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setX(-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setX(-1);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setX(-2);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setX(-1);
										check=loc.getBlock().getType();
										if (check==block){
											loc=master;
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
		if (detector==7){
			level++;
			tier2(loc);
		}
		else {tier2(loc);}
	}
	public void tier4(Location loc){
		Location master= loc;
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		Material check=loc.getBlock().getType();
		for (int i=1; i<=2; i++){
		loc.setY(-i);
		check=loc.getBlock().getType();
		if (check==block){
			loc.setX(+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(-2);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setX(+1);
					loc.setZ(+1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(-2);
						if (check==block){
							loc.setX(-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setX(+2);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setZ(+2);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setZ(-2);
										check=loc.getBlock().getType();
										if (check==block){
											loc=master;
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
		loc.setY(-3);
		check=loc.getBlock().getType();
		if(check==block){
			loc.setY(-4);
			check=loc.getBlock().getType();
			if(check==block){
				loc=master;
				loc.setY(-3);
				loc.setZ(+2);
				loc.setX(+2);
				check=loc.getBlock().getType();
				if(check==block){
					loc.setZ(-4);
					check=loc.getBlock().getType();
					if(check==block){
						loc.setX(+4);
						check=loc.getBlock().getType();
						if(check==block){
							loc.setZ(+4);
							check=loc.getBlock().getType();
							if(check==block){
								loc=master;
								detector++;
								loc.setY(-4);
								loc.setZ(+3);
								loc.setX(-3);
								check=loc.getBlock().getType();
							}
						}
					}
				}
			}
			else if (check==block){
				loc.setZ(-6);
				check=loc.getBlock().getType();
				if(check==block){
					loc.setX(+6);
					check=loc.getBlock().getType();
					if(check==block){
						loc.setZ(+6);
						check=loc.getBlock().getType();
						if(check==block){
							loc.setY(-1);
							detector++;
							check=loc.getBlock().getType();
						}
					}
				}
			}
			else if(check==block){
				loc.setX(-1);
				check=loc.getBlock().getType();
				if(check==block){
					loc.setX(-1);
					check=loc.getBlock().getType();
					if(check==block){
						loc.setX(-1);
						check=loc.getBlock().getType();
						if(check==block){
							loc.setX(-1);
							check=loc.getBlock().getType();
							if(check==block){
								loc.setX(-1);
								check=loc.getBlock().getType();
								if(check==block){
									loc.setX(-1);
									check=loc.getBlock().getType();
									if(check==block){
										loc.setZ(-1);
										check=loc.getBlock().getType();
										if(check==block){
											loc.setZ(-1);
											check=loc.getBlock().getType();
											if(check==block){
												loc.setZ(-1);
												check=loc.getBlock().getType();
												if(check==block){
													loc.setZ(-1);
													check=loc.getBlock().getType();
													if(check==block){
														loc.setZ(-1);
														check=loc.getBlock().getType();
														if(check==block){
															loc.setZ(-1);
															check=loc.getBlock().getType();
															if(check==block){
																loc.setX(+1);
																detector++;
																check=loc.getBlock().getType();
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
			else if (check==block){
				loc.setX(+1);
				check=loc.getBlock().getType();
				if(check==block){
					check=loc.getBlock().getType();
					if(check==block){
						loc.setX(+1);
						check=loc.getBlock().getType();
						if(check==block){
							loc.setX(+1);
							check=loc.getBlock().getType();
							if(check==block){
								loc.setX(+1);
								check=loc.getBlock().getType();
								if(check==block){
									loc.setX(+1);
									check=loc.getBlock().getType();
									if(check==block){
										loc.setZ(+1);
										check=loc.getBlock().getType();
										if(check==block){
											loc.setZ(+1);
											check=loc.getBlock().getType();
											if(check==block){
												loc.setZ(+1);
												check=loc.getBlock().getType();
												if(check==block){
													loc.setZ(+1);
													check=loc.getBlock().getType();
													if(check==block){
														loc.setZ(+1);
														check=loc.getBlock().getType();
														if(check==block){
															loc=master;
															loc.setY(-6);
															loc.setZ(+3);
															check=loc.getBlock().getType();
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
			else if (check==block){
				loc.setY(-1);
				check=loc.getBlock().getType();
				if(check==block){
					loc.setX(-3);
					loc.setZ(-3);
					check=loc.getBlock().getType();
					if(check==block){
						loc.setY(+1);
						check=loc.getBlock().getType();
						if(check==block){
							loc.setZ(-3);
							loc.setX(+3);
							check=loc.getBlock().getType();
							if(check==block){
								loc.setY(-1);
								check=loc.getBlock().getType();
								if(check==block){
									loc.setX(+3);
									loc.setZ(+3);
									check=loc.getBlock().getType();
									if(check==block){
										loc.setY(+1);
										check=loc.getBlock().getType();
										if(check==block){
											detector++;
											loc=master;
											loc.setY(-4);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (detector==6){
			level++;
			tier3(loc);
		}
		else {tier3(loc);}
	}
	public void tier5(Location loc){
		level=0;
		Location master= loc;
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		loc.setY(-1);
		Material check=loc.getBlock().getType();
		if (check==block){
			loc.setY(-1);
			loc.setZ(-1);
			loc.setX(+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setZ(+1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setZ(+1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setX(+1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setZ(-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setZ(-1);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setX(-1);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setZ(+1);
										check=loc.getBlock().getType();
										if (check==block){
											loc.setZ(+1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setY(-1);
												loc.setZ(+1);
												loc.setX(-1);
												detector++;
												check=loc.getBlock().getType();
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
		else if (check==block){
			loc.setX(+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(+1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setX(+1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setX(+1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setZ(-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setZ(-1);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setZ(-1);check=loc.getBlock().getType();
									if (check==block){
										check=loc.getBlock().getType();
										if (check==block){
											loc.setZ(-1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setX(-1);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setZ(+1);
													check=loc.getBlock().getType();
													if (check==block){
														loc.setZ(+1);
														check=loc.getBlock().getType();
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
		else if (check==block){
			loc.setZ(+1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setX(-1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setX(-1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setX(-1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setZ(-1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setZ(-1);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setZ(-1);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setX(+1);
										check=loc.getBlock().getType();
										if (check==block){
											loc.setX(+1);
											check=loc.getBlock().getType();
											if (check==block){
												loc.setZ(+1);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setZ(+1);
													check=loc.getBlock().getType();
													if (check==block){
														loc.setX(-1);
														check=loc.getBlock().getType();
														if (check==block){
															loc.setZ(-1);
															check=loc.getBlock().getType();
															if (check==block){
																loc.setZ(-2);
																loc.setY(-1);
																loc.setX(-2);
																check=loc.getBlock().getType();
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
		else if (check==block){
			loc.setY(-1);
			check=loc.getBlock().getType();
			if (check==block){
				check=loc.getBlock().getType();
				if (check==block){
					loc.setY(-1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(+6);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setY(+1);
							check=loc.getBlock().getType();
							if (check==block){
								loc.setY(+1);
								check=loc.getBlock().getType();
								if (check==block){
									loc.setX(+6);
									check=loc.getBlock().getType();
									if (check==block){
										loc.setY(-1);
										check=loc.getBlock().getType();
										if (check==block){
											check=loc.getBlock().getType();
											if (check==block){
												loc.setY(-1);
												check=loc.getBlock().getType();
												if (check==block){
													loc.setZ(-6);
													check=loc.getBlock().getType();
													if (check==block){
														loc.setY(+1);
														check=loc.getBlock().getType();
														if (check==block){
															loc.setY(+1);
															check=loc.getBlock().getType();
															if (check==block){
																detector++;
																loc=master;
																loc.setY(-3);
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
		Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
		if (detector==4){
			logger.info("Tier 5 is correct");
			level++;
			tier4(loc);
		}
		else{
			logger.info("Tier 5 is incorrect");
			tier4(loc);}
	}
	public int getLevel(Location loc){
		tier1(loc);
		return level;
	}
}