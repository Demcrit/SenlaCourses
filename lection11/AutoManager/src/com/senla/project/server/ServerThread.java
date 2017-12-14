package com.senla.project.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.senla.project.facade.Facade;
import com.senla.project.facade.IFacade;
import com.senla.project.injector.Inject;

public class ServerThread extends Thread {

	private static Logger log = LogManager.getLogger(ServerThread.class);
	private IFacade facade =(IFacade) Inject.getClassInstance(IFacade.class);
	private ObjectOutputStream output;
	private ObjectInputStream input;

	public ServerThread(Socket s) throws IOException {
		output = new ObjectOutputStream(s.getOutputStream());
		input = new ObjectInputStream(s.getInputStream());
	}

	private Response executeCommand(Request msg) {
		Class<?>[] paramTypes = new Class[msg.getParameters().length];

		for (int i = 0; i < paramTypes.length; i++) {
			paramTypes[i] = msg.getParameters()[i].getClass();
		}

		Response response;

		try {
			Method method = Facade.class.getMethod(msg.getMethodName(), paramTypes);
			response = new Response(method.invoke(facade, msg.getParameters()));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			log.error(e);
			response = new Response("Server error!");
		}

		return response;
	}

	private void disconnect() {
		try {
			output.close();
			input.close();
		} catch (IOException e) {
			log.error(e);
		} finally {
			this.interrupt();
		}
	}

	public void run() {
		try {
			Request msg;
			while (true) {
				msg = (Request) input.readObject();
				if (msg != null) {
					Response resp = executeCommand(msg);
					output.writeObject(resp);
					output.flush();
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			log.error(e);
		} finally {
			disconnect();
		}
	}

}
