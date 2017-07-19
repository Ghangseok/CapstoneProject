package net.jamesdaniel.cms.dao;

import java.util.List;

import net.jamesdaniel.cms.model.Customers;

public interface CustomerDao {
	
	public List<Customers> listAllCustomers();
	
	public void saveOrUpdate(Customers customer);
	
	public Customers findCustomerById(String customerId);

}
