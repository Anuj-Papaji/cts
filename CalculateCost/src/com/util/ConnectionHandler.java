package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class ConnectionHandler {
	private static Connection con=null;
	private static Properties pro=new Properties();
	
	
	public static Connection handleConnection() {
		FileInputStream fis = null;
		try {
			Properties pops=new Properties();
			fis = new FileInputStream("C:/Users/851451/workspace/CalculateCost/db.properties");
			
			pops.load(fis);
			Class.forName(pops.getProperty("DB_DRIVER_CLASS"));
			
			con = DriverManager.getConnection(pops.getProperty("db_url"),pops.getProperty("username"),pops.getProperty("password"));
			System.out.println("Connection Established");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
		return con;
	}
	
}
