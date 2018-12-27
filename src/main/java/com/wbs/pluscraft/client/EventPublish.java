package com.wbs.pluscraft.client;

import net.minecraftforge.common.MinecraftForge;

public class EventPublish {

	public EventPublish() {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
