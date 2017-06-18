package net.jamesdaniel.cms.dao;

import java.util.List;

import net.jamesdaniel.cms.model.SystemCustomers;

public interface SystemCustomerDao {

	public List<SystemCustomers> listAllSystemCustomers();
	
	public void saveOrUpdate(SystemCustomers systemCustomer);
	
	public SystemCustomers findSystemCustomerById(String id);
	
	public void deleteSystemCustomer(String id);

}
