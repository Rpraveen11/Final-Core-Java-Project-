package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class StudentMain extends data
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		data d=new data();
		StudentMain s=new StudentMain();
		d.userInterface();
		d.option();
	}

}
