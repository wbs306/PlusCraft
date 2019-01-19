package com.wbs.pluscraft.util;

import com.google.gson.JsonObject;
import com.wbs.pluscraft.ModResources;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.io.IOException;

public class AdapterPublisher {

	private static SocketClient client;

	public AdapterPublisher() throws IOException {
		client = new SocketClient(ModResources.IP, ModResources.PORT);
	}

	public static void publishMessage(String message) throws IOException {
		if (message.equals("stop")) {
			client.disconnect();
			return;
		}
		JsonObject json = new JsonObject();
		json.addProperty("type", "message");
		json.addProperty("message", message);
		publishJson(json);
	}

	public static void publishBlockEvent(String action, EntityPlayer player, World world, BlockPos pos, IBlockState state) throws IOException {
		JsonObject json = new JsonObject();
		JsonObject position = new JsonObject();
		position.addProperty("x", pos.getX());
		position.addProperty("y", pos.getY());
		position.addProperty("z", pos.getZ());
		json.addProperty("type", "blockevent");
		json.addProperty("world", world.getWorldType().getName());
		json.addProperty("biome", world.getBiome(pos).getBiomeName());
		json.add("position", position);
		json.addProperty("block", state.getBlock().getUnlocalizedName());
		json.addProperty("action", action);
		json.addProperty("player", player.getName());
		publishJson(json);
	}

	public static void publishPlayerEvent(String action, EntityPlayer player) {
		JsonObject json = new JsonObject();
		json.addProperty("type", "event");
		json.addProperty("action", action);
		json.addProperty("player", player.getName());
	}

	public static void publishJson(JsonObject json) throws IOException {
		if (json.has("type"))
			client.sendMessage(json.toString());
		else
			System.out.println("type value must in json!");
	}
}
