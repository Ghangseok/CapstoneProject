package net.jamesdaniel.cms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.jamesdaniel.cms.model.Systems;

public class SystemDaoImpl implements SystemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Systems> listAllSystems() {
		return (List<Systems>)getSession().createQuery("from Systems").list();
	}

	@Override
	public void saveOrUpdate(Systems system) {
		getSession().saveOrUpdate(system);
	}

	@Override
	public Systems findSystemById(String systemId) {
		Systems system = getSession().get(Systems.class, systemId);
		return system;
	}

	@Override
	public void deleteSystem(String systemId) {
		Systems system = getSession().get(Systems.class, systemId);
		getSession().delete(system);
	}

}
