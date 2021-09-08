package country.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import country.persistence.entities.User;
import country.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NewPasswordController {
	@Autowired
	private RegistrationService service;
	
	//change password
	@PostMapping("/new-password")
	public String newPassword(@RequestBody User user)
	{

		String email = user.getEmail();
		String newpassword = user.getPassword();
        User userObject = service.fetchUserByEmailId(email);
        if(userObject!=null) {
    		userObject.setPassword(newpassword);
        	this.service.saveUser(userObject);
			return "password changed successfully..";
    	}else {
    		return "Email Is Not Valid";
    	}
		
	}

}
