package com.wbs.pluscraft.event;

import net.minecraftforge.common.MinecraftForge;

public class EventPublish {

	public EventPublish() {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new BlockEventPublish());
	}
}
