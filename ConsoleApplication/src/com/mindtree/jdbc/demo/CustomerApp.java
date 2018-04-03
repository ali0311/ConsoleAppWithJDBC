package com.mindtree.jdbc.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class CustomerApp {

	private static TreeSet<Customer> list;

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		int choice;
		CustomerDao dao =new CustomerDao();
		
		System.out.println(" Please enter any of the following choice : ");
		System.out.println(" Press 1: List all customers ");
		System.out.println(" Press 2: List customer based on id ");
		System.out.println(" Press 3. Add Customer ");
		System.out.println(" Press 4: Update Customer ");
		System.out.println(" Press 5: Remove Customer ");
		System.out.println(" Press 6: Add Multiple Customers ");
		
		
		
			System.out.println(" Please enter your choice ");
			choice= sc.nextInt();
			
			switch(choice){
			
			case 1:
				List list = dao.getAllCustomers();
				System.out.println(list);
				
				break;
				
				
			case 2:
				
				Customer ct = dao.findCustomer(103);
				System.out.println(" Name of the customer : "+ ct.getCustomer_name());
				System.out.println(" Birth date of customer : "+ ct.getDate_of_birth());
				System.out.println(" Balance in Account : "+ ct.getBalance());
				
				break;
				
				
			case 3:
			
			boolean added = dao.addCustomer(new Customer(107, "Ram", "1990-02-16", 30000.58));
			if(added){
				System.out.println("Customer added");
			}
			else{
				System.out.println("error in adding");
					
			}	
			
			break;
			
			case 4:
				
				dao.updateCustomer(301, new Customer(107,"Charles", "1989-02-16", 45000.58) );
				System.out.println("Customer name updated");
				
				
				 
				break;
				
				
			case 5:
				
				dao.removeCustomer(209);
				System.out.println(" Customer row of 209 customer id gets deleted");
				
				break;
				
				
			case 6:
				TreeSet<Customer> al=new TreeSet<Customer>(new CusComp());
				
				al.add(new Customer(204, "Matt", "1988-06-15", 76890.98));
				al.add(new Customer(209, "Jio", "1974-09-14", 96890.98));
				
				
				dao.addMultipleCustomers(al);
				
				System.out.println(" Multiple records added ");
				
				break;
					
			}
	}
}
				
					
				
	
			 			
		
		
	

		
	


