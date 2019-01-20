package com.wbs.pluscraft.util;

import com.google.gson.JsonObject;
import com.wbs.pluscraft.ModResources;

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

	public static void publishJson(JsonObject json) throws IOException {
		if (json.has("type"))
			client.sendMessage(json.toString());
		else
			System.out.println("type value must in json!");
	}
}
