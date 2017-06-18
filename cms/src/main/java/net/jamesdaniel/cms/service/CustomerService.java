package net.jamesdaniel.cms.service;

import java.util.List;

import net.jamesdaniel.cms.model.Customers;

public interface CustomerService {
	public List<Customers> listAllCustomers();
	
	public void saveOrUpdate(Customers customer);
	
	public Customers findCustomerById(String customerId);
	
	public void deleteCustomer(String customerId);
}
