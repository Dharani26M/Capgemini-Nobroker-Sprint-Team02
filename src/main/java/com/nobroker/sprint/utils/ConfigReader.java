package com.nobroker.sprint.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
	Properties prop;
	public ConfigReader(){
	try {
		FileInputStream fis=new FileInputStream("./src/test/resources/common_data/Login.properties");
		 prop=new Properties();
		prop.load(fis);
		
	}
	catch(IOException e) {
        e.printStackTrace();

	}}
	
	public String getbrowser() {
		return prop.getProperty("browser");
	}
	public String geturl() {
		return prop.getProperty("url");
	}
	public String getuserphoneno() {
		return prop.getProperty("userphoneno");
	}
}
