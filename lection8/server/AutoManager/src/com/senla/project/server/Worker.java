package com.senla.project.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worker {

	private static Logger LOG = LogManager.getLogger(Worker.class);
	private static Worker worker;
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private Worker() {
		
	}
	
	public static Worker getInstance() {
		if (worker == null) {
			worker = new Worker();
		}
		return worker;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException | NullPointerException e) {
			LOG.error(e);
		}
	}
	
	public Response sendMsg(Request msg) {
		try {
			output.writeObject(msg);
			output.flush();
			return (Response) input.readObject();
		} catch (IOException | ClassNotFoundException e) {
			LOG.error(e);
			return null;
		}
	}
	
	public void disconnect() {
		try {
			socket.close();
		} catch (IOException e) {
			LOG.error(e);
		}
	}
}
