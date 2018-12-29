package com.wbs.pluscraft.event;

import com.wbs.pluscraft.util.AdapterPublisher;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

public class BlockEventPublish {

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) throws IOException {
		AdapterPublisher.publishBlockEvent("break", event.getPlayer(), event.getWorld(), event.getPos(), event.getState());
	}

	@SubscribeEvent
	public void onBlockPlaced(BlockEvent.PlaceEvent event) throws IOException {
		AdapterPublisher.publishBlockEvent("place", event.getPlayer(), event.getWorld(), event.getPos(), event.getState());
	}
}
