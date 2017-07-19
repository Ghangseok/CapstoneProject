package net.jamesdaniel.cms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		return (List<Customers>)getSession().createQuery("from Customers where currnet_flag='1'").list();
	}

	public void saveOrUpdate(Customers customers) {
		getSession().saveOrUpdate(customers);

	}

	public Customers findCustomerById(String customerId) {
		Customers customer = null;
		Query query = getSession().createQuery("from Customers where customer_id=:customerId and current_flag = '1' ");
		query.setParameter("customerId", customerId);		
		List<Customers> list = query.list();
		if (list.size() > 0) {
			customer = list.get(0);
		}
		return customer;
	}

}
