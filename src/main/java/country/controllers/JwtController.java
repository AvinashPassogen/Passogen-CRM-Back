package country.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import country.helper.JwtUtil;
import country.persistence.entities.JwtRequest;
import country.persistence.entities.JwtResponse;
import country.service.CustomUserDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {

	
	@Autowired
    private AuthenticationManager authenticationManager;

	@Autowired
	private UserController userCont;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    
    @RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest, HttpSession session) throws Exception
	{
		System.out.println(jwtRequest);
		try {

            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));


        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }catch (BadCredentialsException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
		//fine area..
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT " + token);
		session.setAttribute("user", jwtRequest.getUsername());
		
        //{"token":"value"}
        
        return ResponseEntity.ok(new JwtResponse(token));

	}
    
    @GetMapping("/getToken")
	public ResponseEntity<?> getToken(HttpSession session)
	{
    	String token = (String) session.getAttribute("token");
    	System.out.println("token = " + token);
    	return ResponseEntity.ok(token);
	}
    
  
	
}
