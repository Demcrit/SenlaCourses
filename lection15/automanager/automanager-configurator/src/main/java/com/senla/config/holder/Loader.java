package com.senla.config.holder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.*;

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
