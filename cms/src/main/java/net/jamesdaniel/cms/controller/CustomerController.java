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

import net.jamesdaniel.cms.model.Customers;
import net.jamesdaniel.cms.service.CustomerService;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index() {
		LOGGER.debug("index");
		ModelAndView model = new ModelAndView("index");
	
		return model;		
	}
	
	@RequestMapping(value="/list", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String,Object> list() {
		LOGGER.debug("list");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Customers> list = customerService.listAllCustomers();
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
	public ModelAndView update(@RequestParam(value="customerId") String customerId) {
		ModelAndView model = new ModelAndView("form");
		Customers customer = customerService.findCustomerById(customerId);
		model.addObject("customerForm", customer);
		
		return model;		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("form");
		Customers customer = new Customers();
		model.addObject("customerForm", customer);
		
		return model;		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("customerForm") Customers customer) {
		customer.setCreateDt("20170619153900");
		customer.setUpdateDt("20170619153900");
		customerService.saveOrUpdate(customer);
		
		return new ModelAndView("redirect:/customer/index");		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="customerId") String customerId) {
		customerService.deleteCustomer(customerId);
		
		return new ModelAndView("redirect:/customer/index");		
	}
	
	
	
}