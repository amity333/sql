package com.cg.mps.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mps.Exception.CustomerException;

public class DBUtil
{
	//to read the data from dbInfo
	static String unm;
	static String pwd;
	static String url;
	static String driver;
	static Connection con=null;
	//responsible for connecting the database 
	public static Connection getCon() throws CustomerException, IOException, ClassNotFoundException, SQLException
	{
		try
		{
		Properties dbProp=getDBInfo();
		unm=dbProp.getProperty("dbUsername");
		pwd=dbProp.getProperty("dbpswd");
		url=dbProp.getProperty("dbUrl1");
		driver=dbProp.getProperty("dbDiver");
		Class.forName(driver);
		con=DriverManager.getConnection(url,unm,pwd);
		return con;
		}
		catch(Exception ee)
		{
			throw new CustomerException(ee.getMessage());
		}
		
	}
	
	public static Properties getDBInfo() throws IOException
	{
		FileReader fr= new FileReader("dbInfo.properties");//FileNOtFoundException
		Properties myprops =new Properties();
		myprops.load(fr);//IOException
		
		return myprops;
	}
}
