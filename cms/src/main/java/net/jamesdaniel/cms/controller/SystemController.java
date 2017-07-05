package net.jamesdaniel.cms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.jamesdaniel.cms.model.Systems;
import net.jamesdaniel.cms.service.SystemService;

@Controller
@RequestMapping(value="/system")
public class SystemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

	@Autowired
	SystemService systemService;
	
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public ModelAndView index() {
		LOGGER.debug("info");
		ModelAndView model = new ModelAndView("systemInfo");
	
		return model;		
	}
	
	@RequestMapping(value="/list", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String,Object> list() {
		LOGGER.debug("list");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Systems> list = systemService.listAllSystems();
		if (list !=null) {
			map.put("status",  "200");
			map.put("message", "Data found");
			map.put("data", list);
		} else {
			map.put("status", "500");
			map.put("message", "Data not found");
		}
		
		return map;		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(@RequestParam(value="systemId") String systemId) {
		ModelAndView model = new ModelAndView("form");
		Systems system = systemService.findSystemById(systemId);
		model.addObject("systemForm", system);
		
		return model;		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("form");
		Systems system = new Systems();
		model.addObject("systemForm", system);
		
		return model;		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("systemForm") Systems system) {
		system.setCreateDt("20170619153900");
		system.setUpdateDt("20170619153900");
		systemService.saveOrUpdate(system);
		
		return new ModelAndView("redirect:/system/info");		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="systemId") String systemId) {
		systemService.deleteSystem(systemId);
		
		return new ModelAndView("redirect:/system/info");		
	}
}
