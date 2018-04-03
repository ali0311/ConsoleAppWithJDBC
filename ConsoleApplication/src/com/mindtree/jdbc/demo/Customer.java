package com.mindtree.jdbc.demo;

import java.util.Date;

public class Customer {

	private int customer_id;
	private String customer_name;
	private String date_of_birth ;
	private double balance;
	public Customer(int customer_id, String customer_name, String date_of_birth, double balance) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.date_of_birth = date_of_birth;
		this.balance = balance;
	}
	public Customer() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", date_of_birth="
				+ date_of_birth + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + customer_id;
		result = prime * result + ((customer_name == null) ? 0 : customer_name.hashCode());
		result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (customer_name == null) {
			if (other.customer_name != null)
				return false;
		} else if (!customer_name.equals(other.customer_name))
			return false;
		if (date_of_birth == null) {
			if (other.date_of_birth != null)
				return false;
		} else if (!date_of_birth.equals(other.date_of_birth))
			return false;
		return true;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
	