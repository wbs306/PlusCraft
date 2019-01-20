package com.wbs.pluscraft.event.json;

import com.google.gson.JsonObject;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;

public class EventJson {

	public static JsonObject getEventJson(String type) {
		JsonObject json = new JsonObject();
		json.addProperty("type", type);
		return json;
	}

	public static JsonObject getPosition(BlockPos pos) {
		JsonObject position = new JsonObject();
		position.addProperty("x", pos.getX());
		position.addProperty("y", pos.getY());
		position.addProperty("z", pos.getZ());

		return position;
	}

	public static JsonObject getBlockJson(String action, BlockEvent event) {
		JsonObject blockJson = getEventJson("block_event");
		blockJson.addProperty("action", action);
		blockJson.addProperty("world", event.getWorld().getWorldType().getName());
		blockJson.addProperty("biome", event.getWorld().getBiome(event.getPos()).getBiomeName());
		blockJson.addProperty("block", event.getState().getBlock().getUnlocalizedName());
		blockJson.add("position", getPosition(event.getPos()));

		return blockJson;
	}

	public static JsonObject getPlayerJson(String action, PlayerEvent event) {
		JsonObject playerJson = getEventJson("player_event");
		playerJson.addProperty("action", action);
		playerJson.addProperty("world", event.getEntity().world.getWorldType().getName());
		playerJson.addProperty("player", event.getEntityPlayer().getName());

		return playerJson;
	}
}
