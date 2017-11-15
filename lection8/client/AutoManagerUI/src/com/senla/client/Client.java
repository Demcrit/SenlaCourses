package com.senla.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.senla.project.server.Worker;
import com.senla.project.ui.api.IMenuController;
import com.senla.project.ui.entity.MenuController;
import com.senla.project.utils.PrintUtil;

public class Client {
	private final static Logger log = LogManager.getLogger(Client.class);

	private final static int PORT = 1616;

	private Socket s;

	public Client() {

		try {
			s = new Socket(InetAddress.getLocalHost(), PORT);
		} catch (IOException e) {
			log.error(e);
			PrintUtil.printMessage("Connection Error");
		}

	}

	public void run() throws ReflectiveOperationException {
		Worker.getInstance().setSocket(s);
		IMenuController contr = (IMenuController) new MenuController();
		contr.run();
	}
}
