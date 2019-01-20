package com.wbs.pluscraft.event;

import com.google.gson.JsonObject;
import com.wbs.pluscraft.event.json.EventJson;
import com.wbs.pluscraft.util.AdapterPublisher;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

public class BlockEventPublish {

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) throws IOException {
		JsonObject blockJson = EventJson.getBlockJson("break", event.getWorld(), event.getPos(), event.getState());
		blockJson.addProperty("player", event.getPlayer().getName());
		AdapterPublisher.publishJson(blockJson);
	}

	@SubscribeEvent
	public void onBlockPlaced(BlockEvent.PlaceEvent event) throws IOException {
		JsonObject blockJson = EventJson.getBlockJson("place", event.getWorld(), event.getPos(), event.getState());
		blockJson.addProperty("player", event.getPlayer().getName());
		AdapterPublisher.publishJson(blockJson);
	}
}
