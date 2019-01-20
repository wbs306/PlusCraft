package com.wbs.pluscraft.event;

import com.google.gson.JsonObject;
import com.wbs.pluscraft.event.json.EventJson;
import com.wbs.pluscraft.util.AdapterPublisher;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.io.IOException;

public class PlayerEventPublish {

	@SubscribeEvent
	public void onPlayerGetAdvancement(AdvancementEvent event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("get_advancement", event.getEntity().world, event.getEntityPlayer());
		playerJson.addProperty("advancement", event.getAdvancement().toString());
		AdapterPublisher.publishJson(playerJson);
	}


}
