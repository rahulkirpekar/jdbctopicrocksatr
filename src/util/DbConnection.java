package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection 
{
	// 2) create getConnection method
	public static Connection getConnection() 
	{
		FileInputStream fin = null;
		Properties prop = new Properties();
		try 
		{
			fin = new FileInputStream("C:\\Users\\Royal\\eclipse-workspace\\jdbctopicrocksatr\\dbconfig.properties");
			
			prop.load(fin);
			
		} catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		String URLNAME = prop.getProperty("URLNAME").trim();
		String DRIVERCLASS = prop.getProperty("DRIVERCLASS").trim();
		String USERNAME = prop.getProperty("USERNAME").trim();
		String PASSWORD = prop.getProperty("PASSWORD").trim();
		
		Connection conn = null;
		try 
		{
			// 3) load Driver Class
			Class.forName(DRIVERCLASS);

			// 4) pass credential into DriverManager's getConnection method
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) 
	{
		Connection conn = DbConnection.getConnection();
		
		
	}
}