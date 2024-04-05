package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class EmployeeTable {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/";
		
		String username = "root";
		
		String password = "Toor";
		
		try {
			
			Connection connect = DriverManager.getConnection(url,username,password);
			
			if(connect !=null) {
				System.out.println("Connection Successful");
			} else {
				System.out.println("Connection is not Successful");
			}
			
			Statement st= connect.createStatement();
			
			String createDB = "create database Employeedetails";
			
			String useDb = "use Employeedetails";
			
			String createTable= "create table EmpDetails(empcode int,empname varchar(50),empage int,esalary int)";
			
			String select= "select * from EmpDetails";
			
			String insert= 
					"""
					 insert into EmpDetails value
					 (101,'Jenny',25,10000),
					 (102,'Jacky',30,20000),
					 (103,'Joe',20,40000),
					 (104,'John',40,80000),
					 (105,'Shameer',25,90000)
					    """;
			
			st.execute(createDB);
			st.execute(useDb);
			st.execute(createTable);
			st.execute(insert);
			
			
			ResultSet result=st.executeQuery(select);
			
			System.out.println("---------------------------------------------------------------------------------------------");
			
			while(result.next()) {
				System.out.println(result.getInt("empcode")+ " "+result.getString("empname")+" "+result.getInt("empage")+" "+result.getInt("esalary"));
			}
			
			connect.close();
	   
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

	}


