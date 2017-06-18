package net.jamesdaniel.cms.dao;

import java.util.List;

import net.jamesdaniel.cms.model.Systems;

public interface SystemDao {
	
	public List<Systems> listAllSystems();
	
	public void saveOrUpdate(Systems system);
	
	public Systems findSystemById(String systemId);
	
	public void deleteSystem(String systemId);

}
