package com.senla.project.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.project.facade.IFacade;
import com.senla.project.injector.Inject;

public class Runner {
private static final int PORT = 1616;
	
	private static Logger log = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
		
		IFacade facade = (IFacade) Inject.getClassInstance(IFacade.class);
		facade.deserialize();
		
		try (ServerSocket serv = new ServerSocket(PORT)) {
			while (true) {
				Socket s = serv.accept();
				ServerThread servThread = new ServerThread(s);
				servThread.start();
			}
		} catch (IOException e) {
			log.error(e);
		}
	}
}
