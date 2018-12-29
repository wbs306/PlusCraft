package com.wbs.pluscraft.util;

import com.wbs.pluscraft.ModResources;
import com.wbs.pluscraft.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;

import java.io.IOException;

@Mod(modid = ModResources.MOD_ID, name = ModResources.MOD_NAME, version = ModResources.MOD_VERSION)
public class PlusCraftEntry {

	@Instance(ModResources.MOD_ID)
	public static PlusCraftEntry instance;

	@SidedProxy(clientSide = "com.wbs.pluscraft.client.ClientProxy", serverSide = "com.wbs.pluscraft.common.CommonProxy")
	private static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void serverStaring(FMLServerStartingEvent event) throws IOException {
		AdapterPublisher.publishMessage(event.getEventType());
	}

	@EventHandler
	public void serverStopping(FMLServerStoppingEvent event) throws IOException {
		AdapterPublisher.publishMessage("stop");
	}
}
