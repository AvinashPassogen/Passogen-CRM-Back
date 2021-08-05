package country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import country.persistence.entities.Account;
import country.persistence.entities.Contacts;
import country.persistence.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repo;

	public Account fetchAccByEmailId(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}

	

}
