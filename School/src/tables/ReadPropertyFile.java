package tables;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

import com.mysql.jdbc.Driver;
 
public class ReadPropertyFile { 
		Properties prop = new Properties(); 
		InputStream input = null;
		public String driver;
		public String URL;
		public String userid;
		public String password;
		
		Properties properties = new Properties(); {
		
		try {
			properties.load(new FileInputStream("C:\\Users\\Mabel\\workspace\\Java_Learning\\School\\src\\META-INF\\db-config.properties"));
			// Display all the values in the form of key value
			System.out.println("Properties File Read");
		} catch (IOException e) {
			System.out.println("Exception Occurred" + e.getMessage());
		}
		
		driver = properties.getProperty("db.driver.class");
		URL = properties.getProperty("db.url");
		userid = properties.getProperty("userid");
		password = properties.getProperty("password");
		
	}

		//Registering JDBC Driver for MySQL
		public void registerDriver() {

		try {
			   Class.forName(driver).newInstance();
			   System.out.println("Driver is Registered");
			}
			catch(ClassNotFoundException ex) {
			   //System.out.println("Error: unable to load driver class!");
				ex.printStackTrace();
				System.exit(1);
			}
			catch(IllegalAccessException ex) {
			   System.out.println("Error: access problem while loading!");
			   System.exit(2);
			}
			catch(InstantiationException ex) {
			   System.out.println("Error: unable to instantiate driver!");
			   System.exit(3);
			}
		}
}

	
