package country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import country.persistence.entities.OtPassword;
import country.persistence.repository.otpRepository;


@Service
public class OtpService {
	
	
	@Autowired
	private otpRepository repo;

	
	public OtPassword fetchUserByEmailId(String email) {
		return repo.findByEmail(email);  
	}


	public OtPassword saveOtp(OtPassword utObject) {
        return repo.save(utObject);

	}

	

}
