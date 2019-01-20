package com.wbs.pluscraft.event.json;

import com.google.gson.JsonObject;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

	public static JsonObject getBlockJson(String action, World world, BlockPos pos, IBlockState state) {
		JsonObject blockJson = getEventJson("block_event");
		blockJson.addProperty("action", action);
		blockJson.addProperty("world", world.getWorldType().getName());
		blockJson.addProperty("biome", world.getBiome(pos).getBiomeName());
		blockJson.addProperty("block", state.getBlock().getUnlocalizedName());
		blockJson.add("position", getPosition(pos));

		return blockJson;
	}

	public static JsonObject getPlayerJson(String action, World world, EntityPlayer player) {
		JsonObject playerJson = getEventJson("player_event");
		playerJson.addProperty("action", action);
		playerJson.addProperty("world", world.getWorldType().getName());
		playerJson.addProperty("player", player.getName());

		return playerJson;
	}
}
