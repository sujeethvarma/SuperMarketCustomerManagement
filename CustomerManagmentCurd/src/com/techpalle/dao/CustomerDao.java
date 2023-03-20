package com.techpalle.dao;

import java.sql.*;
import java.util.*;

import com.techpalle.model.*;

public class CustomerDao 
{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/customer_management";
	private static final String dbUsername = "root";
    private static final String dbPassword  = "Sujeeth@970";
    
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static Statement stm = null;
    private static ResultSet rs = null;
    
    private static final String customersListQuery  = "select * from customer";
    private static final String customerInsert = "insert into customer(name, email, mobile) values(?,?,?)";
    
    public static void addCustomer(Customer customer)
    {
    	con = getConnectionDef();
    	try 
    	{
        	con = getConnectionDef();
			ps = con.prepareStatement(customerInsert);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			
			ps.executeUpdate();

		}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	finally {
    		if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
    }
    
    public static Connection getConnectionDef() 
    {
        try 
        {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} 
        catch (ClassNotFoundException e) 
        {
			e.printStackTrace();
		} 
        catch (SQLException e) 
        {
			e.printStackTrace();
	    }
        return con;
    }
  
    public static ArrayList<Customer> getAllCustomers()
    {  
    	ArrayList<Customer> al = new ArrayList<Customer>();
         try 
         {
            con = getConnectionDef();
			stm = con.createStatement();
			
			rs = stm.executeQuery(customersListQuery);
			
			while(rs.next())
			{
				int i = rs.getInt("id");
				String n = rs.getString("name");
				String e = rs.getString("email");
				long m = rs.getLong("mobile");
				
				Customer c = new Customer(i, n, e, m); 
				
				al.add(c);
			}
		} 
         catch (SQLException e) 
         {
			e.printStackTrace();
		}
        finally
        {
        	if(rs != null) {
        		try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        	if(stm != null) {
        		try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        	if(con != null) {
        		try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        	
        }
		return al;
    	
    }
}
