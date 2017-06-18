package net.jamesdaniel.cms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.jamesdaniel.cms.model.Customers;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Customers> listAllCustomers() {
		return (List<Customers>)getSession().createQuery("from Customers").list();
	}

	public void saveOrUpdate(Customers customers) {
		getSession().saveOrUpdate(customers);

	}

	public Customers findCustomerById(String customerId) {
		Customers customer = getSession().get(Customers.class, customerId);
		return customer;
	}

	public void deleteCustomer(String customerId) {
		Customers customers = getSession().get(Customers.class, customerId);
		getSession().delete(customers);

	}

}
