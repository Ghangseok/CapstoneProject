package net.jamesdaniel.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.jamesdaniel.cms.model.Customers;
import net.jamesdaniel.cms.model.Systems;
import net.jamesdaniel.cms.service.CustomerService;
import net.jamesdaniel.cms.service.SystemService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	@Autowired
	SystemService systemService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		LOGGER.debug("index");
		ModelAndView model = new ModelAndView("index");

		return model;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, Object> list() {
		LOGGER.debug("list");

		Map<String, Object> map = new HashMap<String, Object>();
		List<Customers> list = customerService.listAllCustomers();
		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);
		} else {
			map.put("status", "500");
			map.put("message", "Data not found");
		}

		return map;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public ModelAndView update(@RequestParam(value = "customerId") String customerId) {
		ModelAndView model = new ModelAndView("form");
		Customers customer = customerService.findCustomerById(customerId);
		model.addObject("customerForm", customer);

		return model;
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public ModelAndView add(@RequestParam(value = "id") String customerId) {
		ModelAndView model = new ModelAndView("form");
		Customers customer = new Customers();
		customer.setCustomerId(customerId);
		List<Systems> systemList = systemService.listAllSystems();
		model.addObject("customerForm", customer);
		model.addObject("systemList", systemList);

		return model;
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public ModelAndView save(@Valid @ModelAttribute("customerForm") Customers customer, BindingResult errors) {

		if (errors.hasErrors()) {
			System.out.println(errors.toString());
		}
		LOGGER.debug("save");
		try {
			String passowrdByMD5 = DigestUtils.md5DigestAsHex(customer.getPassword().getBytes());
			String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			
			customer.setPassword(passowrdByMD5);
			customer.setCurrentFlag("1");
			customer.setCreateDt(currentDate);
			customer.setUpdateDt(currentDate);
			customerService.saveOrUpdate(customer);
		} catch (Exception e) {

		}

		return new ModelAndView("redirect:/customer/index");
	}


}
