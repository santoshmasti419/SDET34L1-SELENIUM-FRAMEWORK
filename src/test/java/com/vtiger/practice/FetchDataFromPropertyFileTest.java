package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainJavaUtility;

public class FetchDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
		/*convert the pysical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		
		//create the object for property class
		Properties property = new Properties();
		
		//load all the keys
		property.load(fis);
		
		//fetch the data by using keys
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		String timeout = property.getProperty("timeout");
		String browser = property.getProperty("browser");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(timeout);
		System.out.println(browser);*/
		
		MainFileUtility.openPropertyfile(MainIconstantPath.PROPERTY_FILE_PATH);
		
		String url = MainFileUtility.fetchdataFromPropertyFile("url");
		String username =  MainFileUtility.fetchdataFromPropertyFile("username");
		String password = MainFileUtility.fetchdataFromPropertyFile("password");
		String timeout =  MainFileUtility.fetchdataFromPropertyFile("timeout");
		String browser = MainFileUtility.fetchdataFromPropertyFile("browser");
		


	}

}
