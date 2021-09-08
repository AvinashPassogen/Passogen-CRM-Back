package country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import country.persistence.entities.OtPassword;
import country.persistence.entities.User;
import country.persistence.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired 
    private RegistrationRepository repo;
    
    public User saveUser(User user) {
        return repo.save(user);
    }
    
    public User fetchUserByEmailId(String email) { 
        return repo.findByEmail(email);   
    }

	public User fetchUserByUsername(String username) {
		return repo.findByUsername(username);  
	}

	public OtPassword saveOtp(OtPassword notp) {
		// TODO Auto-generated method stub
		return null;
	}


}
