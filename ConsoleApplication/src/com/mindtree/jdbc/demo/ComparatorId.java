package com.mindtree.jdbc.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorId {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String driverClass="com.mysql.jdbc.Driver";
         String url="jdbc:mysql://localhost:3306/customerdb";
         String user="root";
         String password="root";
         
         String query = "select * from customer_tbl" ;
 		 List<Customer> list = new ArrayList<Customer>(); 
         try {
             Class.forName(driverClass);//load the jdbc driver
             Connection con=DriverManager.getConnection(url, user, password);
             Statement st=con.createStatement();//create the statement object on which query can be executed
             ResultSet rs=st.executeQuery(query);
             	while(rs.next()){
     			int customer_id=rs.getInt(1);
     			String customer_name =rs.getString(2);
    			String date_of_birth =rs.getString(3);
    			Double balance =rs.getDouble(4);
    			
    			Customer customer= new Customer();
    			customer.setCustomer_id(customer_id);
    			customer.setCustomer_name(customer_name);
    			customer.setDate_of_birth(date_of_birth);
    			customer.setBalance(balance);
    			list.add(customer);
    			
             
	}
             	
             	System.out.println("Sorting of customers based on Customer_ID\n");
             	
             	 Collections.sort(list,new CustomerIdComp());
             	 for(Customer c:list){
                     System.out.println(c);
                 }
             	 
             	 System.out.println("---------------------------------------------------------------------\n");
             	System.out.println("Sorting of customers based on Customer_Balance\n");
             	Collections.sort(list,new CustomerBalanceComp());
            	 for(Customer c:list){
                    System.out.println(c);
                }
            	 
            	 System.out.println("---------------------------------------------------------------------\n");
              	System.out.println("Sorting of customers based on Customer_Name\n");
            	 Collections.sort(list,new CustomerNameComp());
             	 for(Customer c:list){
                     System.out.println(c);
                 }
             	 
         }catch(Exception e){}
         
        
	}
	
	public static class CustomerIdComp implements Comparator<Customer>{
		 
	    @Override
	    public int compare(Customer c1, Customer c2) {
	        if(c1.getCustomer_id() < c2.getCustomer_id()){
	            return -1;
	        } else {
	            return 1;
	        }
	    }
	}
	
	public static class CustomerBalanceComp implements Comparator<Customer>{
		 
	    @Override
	    public int compare(Customer c1, Customer c2) {
	        if(c1.getBalance() < c2.getBalance()){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}
	
	public static class CustomerNameComp implements Comparator<Customer>{
		 
	    @Override
	    public int compare(Customer c1, Customer c2) {
	    	
	    	return c1.getCustomer_name().compareTo(c2.getCustomer_name());
	    }
	}

}
