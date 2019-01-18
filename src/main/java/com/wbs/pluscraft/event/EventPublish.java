package com.wbs.pluscraft.event;

import com.google.gson.JsonObject;
import com.wbs.pluscraft.util.AdapterPublisher;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

public class EventPublish {

	public EventPublish() {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new BlockEventPublish());
	}

	@SubscribeEvent
	public void onServerChat(ServerChatEvent event) throws IOException {
		JsonObject chatJson = new JsonObject();
		chatJson.addProperty("type", "serverevent");
		chatJson.addProperty("player", event.getUsername());
		chatJson.addProperty("message", event.getMessage());
		AdapterPublisher.publishJson(chatJson);
	}
}
