package com.wbs.pluscraft.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient extends Socket {

	public SocketClient(String ip, int port) throws IOException {
		super(ip, port);
	}

	public String sendMessage(String message) throws IOException {
		PrintWriter output = new PrintWriter(this.getOutputStream());
		output.write(message);
		output.flush();
		return new BufferedReader(new InputStreamReader(this.getInputStream())).readLine();
	}

	public void disconnect() throws IOException {
		sendMessage("quit");
		this.close();
	}
}
