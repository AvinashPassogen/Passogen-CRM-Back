package country.controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import country.persistence.entities.OtPassword;
import country.persistence.entities.User;
import country.persistence.repository.RegistrationRepository;
import country.service.EmailService;
import country.service.OtpService;
import country.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
Random random = new Random(1000);

	@Autowired
	private OtpService otpService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RegistrationRepository regiRepo;
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/register")
	public  User registerUser(@RequestBody User user) throws Exception {
        String tempUsername = user.getUsername();
        String tempEmailId = user.getEmail();
        if(tempEmailId !=null && !"".equals(tempEmailId)) {
            User userObject = service.fetchUserByEmailId(tempEmailId);
            if(userObject!=null) {
                throw new Exception("User with "+tempEmailId+" is already exist");
            }
            
            if(tempUsername !=null && !"".equals(tempUsername)) {
                User userObjec = service.fetchUserByUsername(tempUsername);
                if(userObjec!=null) {
                    throw new Exception("User with "+tempUsername+" is already exist");
                }
                
            }
        }
        
            
        User userObject = null;
        userObject = service.saveUser(user);
        return userObject;
    }
	

	@PostMapping("/send-otp")
	public String sendOTP(@RequestBody OtPassword user,HttpSession session)
	{
		String email = user.getEmail();
		System.out.println("EMAIL "+email);
		//generating otp of 4 digit

		int otp = random.nextInt(999999);
		
		System.out.println("OTP "+otp);
		OtPassword otpPass = otpService.fetchUserByEmailId(email);
		if(otpPass!=null) {
			
			otpPass.setOtp(otp);
        	this.otpService.saveOtp(otpPass);

			//write code for send otp to email...
			
			
			String subject="OTP From Passogen CRM Team";
			String message=""
					+ "<div style='border:1px solid #e2e2e2; padding:20px'>"
					+ "<h1>"
					+ "OTP is "
					+ "<b>"+otp
					+ "</n>"
					+ "</h1> "
					+ "</div>";
			String to=email;
			
			boolean flag = this.emailService.sendEmail(subject, message, to);
			
		}else {
			
			return "Email Id Is Not Valid";
			
		}
		
		return "verify otp";
	
	}
	
	//verify otp
		@PostMapping("/forgot")
		public String verifyOtp(@RequestBody OtPassword otp)
		{
			int myOtp=otp.getUserotp();
			System.out.println("Our OTP "+myOtp);
			String email = otp.getEmail();
			System.out.println("my otp"+email);
			
			OtPassword otpPass = otpService.fetchUserByEmailId(email);

			if(otpPass!=null) {
				
				int userotp = otpPass.getOtp();
				System.out.println("User Otp "+userotp);
				if(myOtp==userotp)
				{
					System.out.println("Validate");
					return "validate";
				}
				
			}else {
				
				return "Email Id Is Not Valid";
				
			}
					
			
			
			return "Send";
		}
	
		//change password
		@PostMapping("/change-password")
		public String changePassword(@RequestBody User user)
		{

			String email = user.getEmail();
			String newpassword = user.getPassword();
			System.out.println("password "+newpassword);
	        User userObject = service.fetchUserByEmailId(email);
	        if(userObject!=null) {
	    		userObject.setPassword(newpassword);
	        	this.service.saveUser(userObject);
				System.out.println("password change");
				return "password changed successfully..";
	    	}else {
	    		return "Email Is Not Valid";
	    	}
			
		}
		
		@PostMapping("/aaa")
		public  User forgotPassword(@RequestBody User user, HttpSession session) throws Exception 
		{
	        String tempEmailId = user.getEmail();
	        String email=(String)session.getAttribute("email");
	        
	        if(tempEmailId !=null && !"".equals(tempEmailId)) {
	            User userObject = service.fetchUserByEmailId(tempEmailId);
	            if(userObject!=null) {
	            	userObject.setPassword(user.getPassword());
	        		this.service.saveUser(userObject);

	            }
	        }
	        User userObject = null;
	        return userObject;
	    }
		
		
	
}
