package net.jamesdaniel.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jamesdaniel.cms.dao.SystemDao;
import net.jamesdaniel.cms.model.Systems;

@Service
@Transactional
public class SystemServiceImple implements SystemService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	SystemDao systemDao;
	
	@Autowired
	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}

	@Override
	public List<Systems> listAllSystems() {
		return systemDao.listAllSystems();
	}

	@Override
	public void saveOrUpdate(Systems system) {
		systemDao.saveOrUpdate(system);

	}

	@Override
	public Systems findSystemById(String systemId) {
		return systemDao.findSystemById(systemId);
	}

	@Override
	public void deleteSystem(String systemId) {
		systemDao.deleteSystem(systemId);

	}

}
