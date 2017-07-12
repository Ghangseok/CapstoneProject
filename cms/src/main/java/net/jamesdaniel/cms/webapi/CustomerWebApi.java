package net.jamesdaniel.cms.webapi;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import net.jamesdaniel.cms.model.Customers;
import net.jamesdaniel.cms.service.CustomerService;



@Path("/webapi")
public class CustomerWebApi {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerWebApi.class);
	
	@Autowired
	CustomerService customerService;

	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public String getCustomerLoginInfo() {
		String customerId = "";
		Customers customer = customerService.findCustomerById(customerId);
		return "";
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public String addCustomer() {
		String customerId = "";
		// To send email for registration.
		return "";
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public String withdrawCustomer() {
		String customerId = "";
		customerService.deleteCustomer(customerId);
		return "";
	}
	
	
}
