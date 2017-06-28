package net.jamesdaniel.cms.service;

import java.util.List;

import net.jamesdaniel.cms.model.Systems;

public interface SystemService {

	public List<Systems> listAllSystems();
	
	public void saveOrUpdate(Systems system);
	
	public Systems findSystemById(String systemId);
	
	public void deleteSystem(String systemId);
}
