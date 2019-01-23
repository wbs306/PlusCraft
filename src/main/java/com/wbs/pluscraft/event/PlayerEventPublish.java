package com.wbs.pluscraft.event;

import com.google.gson.JsonObject;
import com.wbs.pluscraft.event.json.EventJson;
import com.wbs.pluscraft.util.AdapterPublisher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.io.IOException;

public class PlayerEventPublish {

	@SubscribeEvent
	public void onPlayerGetAdvancement(AdvancementEvent event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("get_advancement", event);
		playerJson.addProperty("advancement", event.getAdvancement().getId().toString());
		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onPlayerAttackEntity(AttackEntityEvent event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("attack", event);
		playerJson.addProperty("target", event.getTarget().getName());

		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onPlayerCritialHit(CriticalHitEvent event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("critical_hit", event);
		playerJson.addProperty("target", event.getTarget().getName());
		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onPlayerFished(ItemFishedEvent event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("fished", event);
		playerJson.addProperty("item", event.getDrops().get(0).getUnlocalizedName());
		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onOpenContainer(PlayerContainerEvent event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("container", event);
		JsonObject item = new JsonObject();
		NonNullList<ItemStack> inventory = event.getContainer().getInventory();
		for (int i = 0; i < inventory.size(); ++i)
			item.addProperty("item_" + (i + 1), inventory.get(i).getUnlocalizedName());
		playerJson.add("items", item);
		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onItemDestroy(PlayerDestroyItemEvent event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("destroy_item", event);
		playerJson.addProperty("item", event.getOriginal().getUnlocalizedName());
		playerJson.addProperty("hand", event.getHand().toString());
		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onInteractEntity(PlayerInteractEvent.EntityInteract event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("interact_entity", event);
		playerJson.addProperty("target", event.getTarget().getName());
		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onPlayerLeftClick(PlayerInteractEvent.LeftClickBlock event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("left_click", event);
		playerJson.addProperty("block", event.getItemStack().getUnlocalizedName());
		JsonObject position = EventJson.getPosition(event.getPos());
		playerJson.add("position", position);
		AdapterPublisher.publishJson(playerJson);
	}

	@SuppressWarnings("Duplicates")
	@SubscribeEvent
	public void onPlayerRightClick(PlayerInteractEvent.RightClickBlock event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("right_click", event);
		playerJson.addProperty("block", event.getItemStack().getUnlocalizedName());
		JsonObject position = EventJson.getPosition(event.getPos());
		playerJson.add("position", position);
		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onPlayerSleep(PlayerSleepInBedEvent event) throws IOException {
		JsonObject playerJson = EventJson.getPlayerJson("sleep", event);
		JsonObject position = EventJson.getPosition(event.getPos());
		playerJson.add("position", position);
		playerJson.addProperty("result", event.getResult().toString());
		AdapterPublisher.publishJson(playerJson);
	}

	@SubscribeEvent
	public void onPlayerWakeUP(PlayerWakeUpEvent event) throws IOException {
		AdapterPublisher.publishJson(EventJson.getPlayerJson("wakeup", event));
	}
}
