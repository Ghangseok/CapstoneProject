package net.jamesdaniel.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jamesdaniel.cms.dao.CustomerDao;
import net.jamesdaniel.cms.model.Customers;



@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	CustomerDao customerDao;
	
	@Autowired
	private void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customers> listAllCustomers() {
		return customerDao.listAllCustomers();
	}

	public void saveOrUpdate(Customers customer) {
		customerDao.saveOrUpdate(customer);

	}

	public Customers findCustomerById(String customerId) {
		return customerDao.findCustomerById(customerId);
	}

	public void deleteCustomer(String customerId) {
		customerDao.deleteCustomer(customerId);
	}

}
