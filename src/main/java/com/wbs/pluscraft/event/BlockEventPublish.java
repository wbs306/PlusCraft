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
		JsonObject blockJson = EventJson.getBlockJson("break", event);
		blockJson.addProperty("player", event.getPlayer().getName());
		AdapterPublisher.publishJson(blockJson);
	}

	@SubscribeEvent
	public void onBlockPlaced(BlockEvent.PlaceEvent event) throws IOException {
		JsonObject blockJson = EventJson.getBlockJson("place", event);
		blockJson.addProperty("player", event.getPlayer().getName());
		AdapterPublisher.publishJson(blockJson);
	}

	//@SubscribeEvent
	public void onBlockNotifiedByNeighbor(BlockEvent.NeighborNotifyEvent event) throws IOException{
		JsonObject blockJson = EventJson.getBlockJson("notified", event);
		blockJson.addProperty("side", event.getNotifiedSides().toString());
		AdapterPublisher.publishJson(blockJson);
	}

	@SubscribeEvent
	public void onCropGrow(BlockEvent.CropGrowEvent.Pre event) throws IOException {
		AdapterPublisher.publishJson(EventJson.getBlockJson("crop_grow", event));
	}

	@SubscribeEvent
	public void onCropGrowSuccessfully(BlockEvent.CropGrowEvent.Post event) throws IOException {
		JsonObject blockJson = EventJson.getBlockJson("crop_grow_successfully", event);
		blockJson.addProperty("origin", event.getOriginalState().getBlock().getUnlocalizedName());
		AdapterPublisher.publishJson(blockJson);
	}

	@SubscribeEvent
	public void onFarmlandTrample(BlockEvent.FarmlandTrampleEvent event) throws IOException {
		JsonObject blockJson = EventJson.getBlockJson("farmland_trample", event);
		blockJson.addProperty("entity_name", event.getEntity().getName());
		blockJson.addProperty("height", event.getFallDistance());
		AdapterPublisher.publishJson(blockJson);
	}
}
