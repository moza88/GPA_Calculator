package tables;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateTable{
	
	//Initializing variables
	private Connection con;
	public Statement stm;
	private ResultSet rs;
	ReadPropertyFile prop_value = new ReadPropertyFile(); 

	public CreateTable() {
		System.out.println("Now we're in the CreateTable class");
		System.out.println("Driver: " + prop_value.driver);
		System.out.println("URL: " + prop_value.URL);
		System.out.println("User ID: " + prop_value.userid);
		System.out.println("Password: " + prop_value.password);
		
		try {
			Class.forName(prop_value.driver);
			
			con = DriverManager.getConnection(prop_value.URL, prop_value.userid, prop_value.password);
			System.out.println("Connected");
		} catch(Exception ex) {
			System.out.print("Error" + ex);
		}
	}
	
	public void getData() throws SQLException {
		try{
			stm = con.createStatement();
			
		try {
		stm.executeUpdate(SQL_Queries.createCourse);
		} catch (SQLException ex) {
				stm.executeUpdate("drop table course");
				stm.executeUpdate(SQL_Queries.createCourse);
		} 
		
		try{
		stm.executeUpdate(SQL_Queries.createStudent);
		} catch (SQLException ex) {
			stm.executeUpdate("drop table student");
			stm.executeUpdate(SQL_Queries.createStudent);
		} 
		
            stm.executeUpdate(SQL_Queries.populateCouse);
			System.out.println("Pulled data from " + SQL_Queries.Data_Path + "\\coursestaken.data");

            stm.executeUpdate(SQL_Queries.populateStudent);
			System.out.println("Pulled data from " + SQL_Queries.Data_Path + "\\student.data");
            
            stm.executeUpdate(SQL_Queries.primaryKeyCourse);
            stm.executeUpdate(SQL_Queries.primaryKeyStudent);
            
            stm.executeUpdate(SQL_Queries.GPAScoreCol);
            stm.executeUpdate(SQL_Queries.GPAScore);
          
        try{
            stm.executeUpdate(SQL_Queries.calculateAvgGPA);
        } catch (SQLException ex) {
        	stm.executeUpdate("drop table reportcard");
            stm.executeUpdate(SQL_Queries.calculateAvgGPA);
        }
        
        

        
        rs = stm.executeQuery("select * from reportcard;");
        if (rs.next()) {
          	String firstName = rs.getString("First_Name");
        	String lastName = rs.getString("Last_Name");
        	String GPA = rs.getString("GPA");
        	System.out.println("Sample Data Output");
        	System.out.println("First Name: " + firstName);
        	System.out.println("Last Name: " + lastName);
        	System.out.println("GPA:" + GPA);
        	rs.close();
        }
        } finally {
            // ... cleanup that will execute whether or not an error occurred ...
        }
	}}
       
        
            
		

		
	
