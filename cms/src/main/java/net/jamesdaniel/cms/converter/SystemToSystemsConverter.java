package net.jamesdaniel.cms.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import net.jamesdaniel.cms.model.Systems;
import net.jamesdaniel.cms.service.SystemService;

@Component
public class SystemToSystemsConverter implements Converter<Object, Systems> {

	@Autowired
	SystemService systemService;
	
	@Override
	public Systems convert(Object systemId) {
		Systems system = systemService.findSystemById((String)systemId);		
		return system;
	}

}
