package net.jamesdaniel.cms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.jamesdaniel.cms.model.SystemCustomers;

@Repository
public class SystemCustomerDaoImpl implements SystemCustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemCustomers> listAllSystemCustomers() {
		return (List<SystemCustomers>)getSession().createQuery("from SystemCustomers").list();
	}

	@Override
	public void saveOrUpdate(SystemCustomers systemCustomer) {
		getSession().saveOrUpdate(systemCustomer);

	}

	@Override
	public SystemCustomers findSystemCustomerById(String id) {
		SystemCustomers systemCustomer = getSession().get(SystemCustomers.class, id);
		return systemCustomer;
	}

	@Override
	public void deleteSystemCustomer(String id) {
		SystemCustomers systemCustomer = getSession().get(SystemCustomers.class, id);
		getSession().delete(systemCustomer);

	}

}
