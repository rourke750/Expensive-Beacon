package com.untamedears.com.rourke750.ExpensiveBeacons.BeaconTypes;



import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;

import com.untamedears.rourke750.ExpensiveBeacons.ExpensiveBeaconsplugin;

public class SpeedBeacon {
	private int level;
	public void tier1(Location loc){
		Location master= loc;
		int detector=0;
		Material block= Material.DIAMOND_BLOCK;
		loc.setY(-1);
		Material check=loc.getBlock().getType();
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
						loc.setX(-1);
						loc.setZ(+1);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setZ(-2);
							check=loc.getBlock().getType();
							if (check==block){
								detector++;
								loc=master;
								loc.setX(-1);
								check=loc.getBlock().getType();
							}
						}
					}
				}
			}
		}
		else if (check==block){
			loc.setX(-1);
			check=loc.getBlock().getType();
			if (check==block){
				loc.setZ(+1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setZ(-2);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setZ(+1);
						loc.setX(-1);
						check=loc.getBlock().getType();
						if (check==block){
							detector++;
							loc=master;
							loc.setZ(+1);
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
				loc.setX(-1);
				check=loc.getBlock().getType();
				if (check==block){
					loc.setX(+2);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setX(-1);
						loc.setZ(+1);
						check=loc.getBlock().getType();
						if (check==block){
							detector++;
							loc=master;
							loc.setZ(-1);
							check=loc.getBlock().getType();
						}
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
					loc.setX(+1);
					check=loc.getBlock().getType();
					if (check==block){
						loc.setX(-2);
						check=loc.getBlock().getType();
						if (check==block){
							loc.setX(+1);
							loc.setZ(-1);
							check=loc.getBlock().getType();
							if (check==block){
								detector++;
								loc=master;
								check=loc.getBlock().getType();
							}
						}
					}
				}
			}
		}
		Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
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
		else {}
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
		else {}
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
		else {}
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
		if (detector==4){
			level++;
			tier4(loc);
		}
		else{}
	}
	public int getLevel(){
		return level;
	}
}