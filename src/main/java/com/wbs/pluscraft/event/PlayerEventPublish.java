package com.wbs.pluscraft.event;

import com.wbs.pluscraft.util.AdapterPublisher;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEventPublish {

	@SubscribeEvent
	public void onPlayerGetAdvancement(AdvancementEvent event) {
		AdapterPublisher.publishPlayerEvent("get advancement:" + event.getAdvancement().toString(), event.getEntityPlayer());
	}


}
