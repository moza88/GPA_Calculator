
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import tables.CreateTable;
import tables.ReadPropertyFile;

public class Main {
	  public static void main(String[] args) throws SQLException {		  
		  ReadPropertyFile properties = new ReadPropertyFile();
			properties.registerDriver();
		  	
		  CreateTable connector = new CreateTable();
		  	connector.getData();
	}
}