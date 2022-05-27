package com.SDET34L1.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains only specific database common methods
 * @author USER1
 *
 */
public class MainDataBaseUtility {


	/**
	 * this method is used to open the connection and initialize the connection ,statement
	 */
	static Connection connection;
	static Statement statement;

	public static void openDBConnection(String DBUrl,String DBUsername,String DBPassword) throws SQLException {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		connection = DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
		statement = connection.createStatement();
	}

	/**
	 * this method is used for fetch the data from db or to do DQL actions on database.
	 * @param query
	 * @param coumnName
	 * @return
	 * @throws SQLException
	 */

	public static ArrayList<String> getDataFromDB(String query, String coumnName) throws SQLException {

		ArrayList<String> List=new ArrayList<>();
		ResultSet result = statement.executeQuery(coumnName);
		while(result.next())
		{
			List.add(result.getString(coumnName));
		}
		return List;

	}
	/**
	 * this method is used to validate the data whether it is present in db or not
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */


	public static boolean validateDataInDB(String query, String columnName,String expectedData) throws SQLException
	{
		ArrayList<String> List=getDataFromDB(query, columnName);
		boolean flag=false;
		for(String actualData:List)
		{
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	/**
	 * this method is used to store/modified/insert/delete the db or to do the dml and ddl actions on db
	 * @param query
	 * @throws SQLException
	 */

	public static void setDataInDataBase(String query) throws SQLException
	{
		int result=statement.executeUpdate(query);
		if(result==1) {
			System.out.println("Data entered/modified successfully");
		}
	}

	public static void closeConnection() 
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
