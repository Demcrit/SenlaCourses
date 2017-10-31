package com.senla.project.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CsvUtil {
	private static final String LINE_BREAK = "\n";
	private static Logger log = LogManager.getLogger(CsvUtil.class);

	public static boolean writeFile(String path, List<String> values) {
		try (FileWriter writer = new FileWriter(path)) {
			for (String str : values) {
				writer.append(str).append(LINE_BREAK);
			}
			return true;
		} catch (IOException e) {
			log.error(e);
			return false;
		}
	}

	public static List<String> readFile(String path) {
		List<String> result = new ArrayList<String>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
			return result;
		} catch (IOException e) {
			log.error(e);
			return null;
		}
	}

}
