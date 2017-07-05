package net.jamesdaniel.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jamesdaniel.cms.dao.SystemCustomerDao;
import net.jamesdaniel.cms.model.SystemCustomers;

@Service
@Transactional
public class SystemCustomerServiceImpl implements SystemCustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	SystemCustomerDao systemCustomerDao;
	
	@Autowired
	public void setSystemCustomerDao(SystemCustomerDao systemCustomerDao) {
		this.systemCustomerDao = systemCustomerDao;
	}

	@Override
	public List<SystemCustomers> listAllSystemCustomers() {
		return systemCustomerDao.listAllSystemCustomers();
	}

	@Override
	public void saveOrUpdate(SystemCustomers systemCustomer) {
		systemCustomerDao.saveOrUpdate(systemCustomer);

	}

	@Override
	public SystemCustomers findSystemCustomerById(String id) {
		return systemCustomerDao.findSystemCustomerById(id);
	}

	@Override
	public void deleteSystemCustomer(String id) {
		systemCustomerDao.deleteSystemCustomer(id);

	}

}
