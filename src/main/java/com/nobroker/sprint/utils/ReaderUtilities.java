package com.nobroker.sprint.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReaderUtilities {
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fs = new FileInputStream("./src/main/resources/Common.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String value = prop.getProperty(key);
		return value;
	}

}
