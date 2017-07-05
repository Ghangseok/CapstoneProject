package net.jamesdaniel.cms.service;

import java.util.List;

import net.jamesdaniel.cms.model.SystemCustomers;

public interface SystemCustomer {

	public List<SystemCustomers> listAllSystemCustomers();
	
	public void saveOrUpdate(SystemCustomers systemCustomer);
	
	public SystemCustomers findSystemCustomerById(String id);
	
	public void deleteSystemCustomer(String id);
}
