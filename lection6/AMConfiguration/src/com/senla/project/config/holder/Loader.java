package com.senla.project.config.holder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loader {
	private static final String PROPERTIES_PATH = "config.properties";
    private static Logger LOG = LogManager.getLogger(Loader.class);

    public static Properties readFile() {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
            prop.load(input);
            return prop;
        } catch (IOException e) {
            LOG.error(e);
            return null;
        }

    }
}
