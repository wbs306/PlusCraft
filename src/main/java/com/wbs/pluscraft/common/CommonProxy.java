package com.wbs.pluscraft.common;

import com.wbs.pluscraft.event.EventPublish;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {

	}

	public void init(FMLInitializationEvent event) {
		new EventPublish();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}


}
