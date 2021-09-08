package country.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import country.persistence.entities.User;
import country.service.RegistrationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private RegistrationService service;
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	  @ResponseBody
	  public String currentUserName(Principal principal) {
	    System.out.println("name " + principal);
		return principal.getName();
	  }

	@GetMapping("/getUser")
	public User fetchUser(Principal principal) {
		String userName = principal.getName();
		System.out.println("USERNAME " + userName);
		User userObject = service.fetchUserByUsername(userName);
		System.out.println("USEr Data " + userObject);

		return userObject;

	}
	
}
