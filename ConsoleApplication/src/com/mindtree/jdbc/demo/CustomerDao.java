package com.mindtree.jdbc.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


public class CustomerDao {

	private Connection connection;

	public CustomerDao() {
		super();
		
		
		String driverClass="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/customerdb";
		String user="root";
		String password="root";
		
		try {
			Class.forName(driverClass);
			connection=DriverManager.getConnection(url, user, password);
				
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}// 
		catch (SQLException e) {
			
			e.printStackTrace();
	}
	} 
	
	public List<Customer> getAllCustomers(){
		
		String query = "select * from customer_tbl" ;
		List list = new ArrayList<>();
		try{
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()){
			int customer_id=rs.getInt(1);
			String customer_name =rs.getString(2);
			String date_of_birth =rs.getString(3);
			Double balance =rs.getDouble(4);
			
			list.addAll(Arrays.asList(customer_id,customer_name, date_of_birth, balance));
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
	}
		return list;
		
		
		
	}
	
	public Customer findCustomer(int customer_id){
		
		Customer ct= null;
		String query = "select * from customer_tbl where customer_id = ?" ;
		try 
		{
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setInt(1, customer_id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				ct=new Customer();
				ct.setCustomer_id(rs.getInt(1));
				ct.setCustomer_name(rs.getString(2));
				ct.setDate_of_birth(rs.getString(3));
				ct.setBalance(rs.getDouble(4));
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ct;
		
	}
	
	public boolean addCustomer(Customer c)
		{
			boolean added =false;
			try {
				PreparedStatement pst=connection.prepareStatement("insert into customer_tbl values(?,?,?,?)");
				pst.setInt(1, c.getCustomer_id());
				pst.setString(2, c.getCustomer_name());
				pst.setString(3, c.getDate_of_birth());
				pst.setDouble(4, c.getBalance());
				int count=pst.executeUpdate();
				if(count>0){
					added=true;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return added;
			
						
		}
		
	public boolean updateCustomer(int customer_id, Customer c){
		
		
		try {
			PreparedStatement pst=connection.prepareStatement("update customer_tbl set customer_name = ? where customer_id = ? ");// Here i'm updating only customer name with his rest parameter will be remain same.
			
			pst.setString(1, c.getCustomer_name());
			pst.setInt(2, customer_id);
			pst.executeUpdate();
			
			
		
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
			
			return false;
		}
		
		public boolean removeCustomer(int customer_id){

			
			try {
				CallableStatement cst = connection.prepareCall("call removecustomer(?)");
				  cst.setInt(1, customer_id);
				  cst.execute();
					connection.close();
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return false;
			
		}
		
		public int addMultipleCustomers(TreeSet<Customer> list){
			
			String query = "insert into customer_tbl values(?,?,?,?)" ;
			try {
	             
	             PreparedStatement pst=connection.prepareStatement(query);//create the statement object on which query can be executed
	             for(Customer c : list)
	             {
	            	 pst.setInt(1, c.getCustomer_id());
	            	 pst.setString(2, c.getCustomer_name());
	            	 pst.setString(3, c.getDate_of_birth());
	            	 pst.setDouble(4, c.getBalance());
	            	 pst.addBatch();
	             }
	             pst.executeBatch();
	             connection.close();
		
}catch (SQLException e) {
	
	e.printStackTrace();
			}
			return 0;
			}
}


