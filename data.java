package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class data 
	{
		Scanner sc=new Scanner(System.in);
		
		int ch;
		String name,sex;
		int fee;
		String dob="dd-MM-yyyy";
		int course;
		int year=2022;
		int uni_id;
	void userInterface()
	{
		
		System.out.println("******************************Welcome to ABCD Portal*******************************");
		
		System.out.println("Add student               :Press 1");
		
		System.out.println("View student Details      :Press 2");
		
		System.out.println("Pay Fees                  :Press 3");
		ch=sc.nextInt();
		
	}	
	void option() throws ClassNotFoundException, SQLException
	{
		if(ch==1)
		{
			
		System.out.println("Enter how many new Students will added to DATABASE");
		int count=sc.nextInt();
		int i=0;
	//	while( i==count);
		for(i=1;i<=count;i++)
		{
		System.out.println("Enter The Name of The student....");
		name=sc.next();
//		String pattern="dd-MM-yyyy";
//		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
//		String dob=SimpleDateFormat.format(new Date);
		System.out.println("Enter Date Of Birth");
		dob=sc.next();
		
		System.out.println("Enter sex");
		sex=sc.next();
		System.out.println("Enter your Unique For Your Reference");
		uni_id=sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root" , "root" );
		PreparedStatement ps= con1.prepareStatement("insert into studdata values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,dob);
			ps.setInt(3,year);
			ps.setInt(4,uni_id);
			ps.setString(5,sex);
			int j=ps.executeUpdate();
			System.out.println(j+" records inserted");
			con1.close();
	
		System.out.println("check your entered Details here :\nname : "+name+"\ndate of birth : "+dob+"\nsex : "+sex+"\nyear: "+year+"\nUnique ID :"+uni_id);
			System.out.println("Student Details Adeed Successfully");
			System.out.println("You are Redirected to select course \n Press 3 ");
			ch=sc.nextInt();
			if(ch==3)
			{
				System.out.println("***************Pay FEES**********");
				System.out.println("***********Course Detail*************");
				System.out.println("1.Java and JavaScript");
				System.out.println("2.Python");
				System.out.println("3.c,c++");
				
				course=sc.nextInt();
				switch(course)
				{
				case 1:
					System.out.println("Java and JavaScript Selected Successfully..........");
					System.out.println("Pay Course Fees");
					System.out.println(" Full Fees : 8000 press 1"
							+"press 2 Pay partially"
						+ "FIrst term : 4000"
							+ "Second term :4000"
							+ "Or Pay fully");
			 fee=sc.nextInt();
			   if(fee==1)
			   {
					System.out.println("Payment Method"
							+ "Credit card"
							+ "Debit card"
							+ "UPI");
					System.out.println(" Loaading Please wait 5 sec****");
					System.out.println("Payment made successfully");
					System.out.println("Your Course has Confirmed");
			   }
			   else
			   {
				   System.out.println("Payment Method for Rs.4000"
							+ "Credit card"
							+ "Debit card"
							+ "UPI");
					System.out.println(" Loaading Please wait 5 sec****");
					System.out.println("Payment made successfully");
					System.out.println("Your Course has Confirmed");
			   }
			   break;
			   case 2:
				   System.out.println("Python Selected Successfully..........");
					System.out.println("Pay Course Fees");
					System.out.println(" Full Fees : 8000 press 1"
							+"press 2 Pay partially"
						+ "FIrst term : 4000"
							+ "Second term :4000"
							+ "Or Pay fully");
			  int fee=sc.nextInt();
			  if(fee==1)
			  {
					System.out.println("Payment Method"
							+ "Credit card"
							+ "Debit card"
							+ "UPI");
					System.out.println(" Loaading Please wait 5 sec****");
					System.out.println("Payment made successfully");
					System.out.println("Your Course has Confirmed");
			  }
			  else
			  {
				   System.out.println("Payment Method for Rs.4000"
							+ "Credit card"
							+ "Debit card"
							+ "UPI");
					System.out.println(" Loaading Please wait 5 sec****");
					System.out.println("Payment made successfully");
					System.out.println("Your Python Course has Confirmed");
				
				}
			  break;

			   case 3:
				   System.out.println("C And C++ Selected Successfully..........");
					System.out.println("Pay Course Fees");
					System.out.println(" Full Fees : 6000 press 1"
							+"press 2 Pay partially"
						+ "FIrst term : 4000"
							+ "Second term :2000"
							+ "Or Pay fully");
			   fee=sc.nextInt();
			  if(fee==1)
			  {
					System.out.println("Payment Method"
							+ "Credit card"
							+ "Debit card"
							+ "UPI");
					System.out.println(" Loaading Please wait 5 sec****");
					System.out.println("Payment made successfully");
					System.out.println("Your Course has Confirmed");
			  }
			  else
			  {
				   System.out.println("Payment Method for Rs.4000"
							+ "Credit card"
							+ "Debit card"
							+ "UPI");
					System.out.println(" Loaading Please wait 5 sec****");
					System.out.println("First term Payment made successfully");
					System.out.println("Your C and C++ has Confirmed");
			  }
	  break;
			  default:
				  System.out.println("enterd null");
				  break;
				  
				  
				}
			}}
			}
		
		
		
		else if(ch==2)
		{
			System.out.println("***************Student Details Portal**********");
			System.out.println("                            ");
			System.out.println("click 1 To view Existing student details");
			int c=sc.nextInt();

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root" , "root" );
		
			PreparedStatement ps1=con.prepareStatement("select * from studdata");
			ResultSet rs=ps1.executeQuery();

			while(rs.next())
			{		
				System.out.println("Registred Student Details");
				System.out.println("               ");
				System.out.println("NAME :"+rs.getString(1)+", DATE OF BIRTH :"+rs.getString(2)+", YEAR :"+rs.getInt(3)+", ID NO :"+rs.getInt(4)+", GENDER :"+rs.getString(5));
			}
			
		}
		else if(ch==3)
		{
			System.out.println("***************Pay FEES**********");
			System.out.println("***********Course Detail*************");
			System.out.println("Existing Students List");
			Class.forName("com.mysql.cj.jdbc.Driver");
			{Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root" , "root" );
		
			PreparedStatement ps1=con.prepareStatement("select * from studdata");
			ResultSet rs=ps1.executeQuery();

			while(rs.next())
			{		
		         
				System.out.println("NAME :"+rs.getString(1));
			}
			}
			System.out.println("Select wchich student You want to pay");
		    String n=sc.next();
		    System.out.println(n+" Select Your Course Below ");
		    System.out.println("                                    ");
			System.out.println("1.Java and JavaScript");
			System.out.println("2.Python");
			System.out.println("3.c,c++");
			
			course=sc.nextInt();
			switch(course)
			{
			case 1:
				System.out.println("Java and JavaScript Selected Successfully..........");
				System.out.println("Pay Course Fees");
				
				System.out.println(" Full Fees : 8000 press 1"
						+"press 2 Pay partially"
					+ "FIrst term : 4000"
						+ "Second term :4000"
						+ "Or Pay fully");
		 fee=sc.nextInt();
		   if(fee==1)
		   {
				System.out.println("Payment Method"
						+ "Credit card"
						+ "Debit card"
						+ "UPI");
				System.out.println(" Loaading Please wait 5 sec****");
				System.out.println("Payment made successfully");
				System.out.println(n+"Your Course has Confirmed");
		   }
		   else
		   {
			   System.out.println("Payment Method for Rs.4000"
						+ "Credit card"
						+ "Debit card"
						+ "UPI");
				System.out.println(" Loaading Please wait 5 sec****");
				System.out.println("Payment made successfully");
				System.out.println(n+" Your Course has Confirmed");
		   }
		   break;
		   case 2:
			   System.out.println("Python Selected Successfully..........");
				System.out.println("Pay Course Fees");
				System.out.println(" Full Fees : 8000 press 1"
						+"press 2 Pay partially"
					+ "FIrst term : 4000"
						+ "Second term :4000"
						+ "Or Pay fully");
		  int fee=sc.nextInt();
		  if(fee==1)
		  {
				System.out.println("Payment Method"
						+ "Credit card"
						+ "Debit card"
						+ "UPI");
				System.out.println(" Loaading Please wait 5 sec****");
				System.out.println("Payment made successfully");
				System.out.println(n+" Your Course has Confirmed");
		  }
		  else
		  {
			   System.out.println("Payment Method for Rs.4000"
						+ "Credit card"
						+ "Debit card"
						+ "UPI");
				System.out.println(" Loaading Please wait 5 sec****");
				System.out.println("Payment made successfully");
				System.out.println(n+"  Your Python Course has Confirmed");
			
			}
		  break;

		   case 3:
			   System.out.println("C And C++ Selected Successfully..........");
				System.out.println("Pay Course Fees");
				System.out.println(" Full Fees : 6000 press 1"
						+"press 2 Pay partially"
					+ "FIrst term : 4000"
						+ "Second term :2000"
						+ "Or Pay fully");
		   fee=sc.nextInt();
		  if(fee==1)
		  {
				System.out.println("Payment Method"
						+ "Credit card"
						+ "Debit card"
						+ "UPI");
				System.out.println(" Loaading Please wait 5 sec****");
				System.out.println("Payment made successfully");
				System.out.println(n+"  Your Course has Confirmed");
		  }
		  else
		  {
			   System.out.println("Payment Method for Rs.4000"
						+ "Credit card"
						+ "Debit card"
						+ "UPI");
				System.out.println(" Loaading Please wait 5 sec****");
				System.out.println("First term Payment made successfully");
				System.out.println(n+"  Your C and C++ has Confirmed");
		  }
		  break;
		  default:
			  System.out.println("enterd null");
			
	         }		
	    }
	}
}
	
		
		
	
	