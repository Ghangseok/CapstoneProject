package net.jamesdaniel.cms.webapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.jamesdaniel.cms.controller.CustomerController;
import net.jamesdaniel.cms.model.Customers;
import net.jamesdaniel.cms.service.CustomerService;
import net.jamesdaniel.cms.service.SystemService;

@RestController
@RequestMapping("/webapi/customer")
public class CustomerWebApiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerWebApiController.class);

	@Autowired
	CustomerService customerService;

	@Autowired
	SystemService systemService;

	@GetMapping(value = "/add")
	public @ResponseBody Map<String, String> addCustomer(@RequestParam(value = "id") String customer_id) {

		LOGGER.debug("id : [" + customer_id + "]");
		Map<String, String> result = new HashMap<String, String>();

		if (customer_id != null) {
			Customers customer = customerService.findCustomerById(customer_id);

			if (customer == null) {

				boolean validEmail = EmailValidator.getInstance().isValid(customer_id);
				if (validEmail) {
					final String username = "customer.manager.system@gmail.com";
					final String password = "zaq1xsw2cde3!@#";

					Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");

					Session session = Session.getInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});

					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress("customer.manager.system@gmail.com"));
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customer_id));
						message.setSubject("Welcome to Customer Management System.");
						message.setText("Dear Customer," + "\n\n Thanks for registering an account with our system."
								+ "\n Please, Click on the below link to keep registering an account." + "\n\n"
								+ "http://localhost:8080/cms/customer/add?id=" + customer_id + "\n\n Thank you.");

						Transport.send(message);

						result.put("CODE", "S0010");
						result.put("MSG", "You got mail successfully!");

						LOGGER.debug(customer_id + ", Done!");

					} catch (MessagingException e) {
						result.put("CODE", "E0012");
						result.put("MSG", "Failure to send your email!");
						e.printStackTrace();
					}
				} else {
					result.put("CODE", "E0010");
					result.put("MSG", "Sorry, we have to input valid email address to join us!");
				}
			} else {
				result.put("CODE", "E0013");
				result.put("MSG", "Sorry, This id already exist. Please, try another id!");
			}
		} else {
			result.put("CODE", "E0011");
			result.put("MSG", "You have to input ID!");
		}

		return result;
	}

	@GetMapping(value = "/login")
	public @ResponseBody Map<String, String> login(@RequestParam(value = "id") String customer_id,
			@RequestParam(value = "pw") String customer_pw) {
		LOGGER.debug("id : [" + customer_id + "], pwd : [" + customer_pw + "]");
		Map<String, String> result = new HashMap<String, String>();

		if (customer_id != null && customer_pw != null) {
			String passowrdByMD5 = DigestUtils.md5DigestAsHex(customer_pw.getBytes());
			Customers customer = customerService.findCustomerById(customer_id);
			if (customer == null) {
				result.put("CODE", "E0002");
				result.put("MSG",
						"Sorry, we can't seem to find an account with this username. Please try again or contact us if you need help.");
			} else if (customer.getPassword() != null && customer.getPassword().intern() != passowrdByMD5) {
				result.put("CODE", "E0003");
				result.put("MSG", "Sorry, the password you¡¯ve entered is incorrect. Please try again.");
			}
			result.put("CODE", "S0001");
			result.put("MSG", "Welcome, " + customer.getLastName() + ", " + customer.getFirstName());
		} else {
			result.put("CODE", "E0001");
			result.put("MSG", "You have to input ID and Password!");
		}

		return result;

	}
	
	@GetMapping(value = "/withdraw")
	public @ResponseBody Map<String, String> withdraw(@RequestParam(value = "id") String customer_id) {
		// String customer_id = (String)params.getFirst("id");
		LOGGER.debug("id : [" + customer_id + "]");
		Map<String, String> result = new HashMap<String, String>();
		
		if (customer_id != null) {
			Customers customer = customerService.findCustomerById(customer_id);
			if (customer == null) {
				result.put("CODE", "E0022");
				result.put("MSG",
						"Sorry, we can't seem to find an account with this username. Please try again or contact us if you need help.");
			} else {
				String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				
				customer.setCurrentFlag("0");
				customer.setUpdateDt(currentDate);
				customerService.saveOrUpdate(customer);
				
				result.put("CODE", "S0020");
				result.put("MSG", "Good bye, " + customer.getLastName() + ", " + customer.getFirstName());
			}
			
		} else {
			result.put("CODE", "E0021");
			result.put("MSG", "You have to input ID!");
		}

		return result;

	}
	
	

}
