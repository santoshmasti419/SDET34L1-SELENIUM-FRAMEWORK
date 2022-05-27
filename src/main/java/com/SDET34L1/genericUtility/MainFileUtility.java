package com.SDET34L1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class contains only Handle the Property file
 * @author USER1
 *
 */
public class MainFileUtility {
;
	static Properties property;
	/**
	 * This method is used to open the property file
	 * @throws IOException 
	 */
	public static void openPropertyfile(String filePath) throws IOException {
		
		FileInputStream file = new FileInputStream(filePath);
		property=new Properties();
		property.load(file);;
	}
	
	/**
	 * This method is used for fetch the value from property file
	 */
	
	public static String fetchdataFromPropertyFile(String key) {
		String value = property.getProperty(key);
		return value;
		
		
	}

	public static void openPropertyfile() {
		// TODO Auto-generated method stub
		
	}
	
	
				
		
	

}
