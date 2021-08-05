package country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import country.persistence.entities.Contacts;
import country.persistence.entities.Leads;
import country.persistence.repository.ContactsRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactsRepository repo;

	public Contacts fetchContByEmailId(String email) {
		// TODO Auto-generated method stub
		return repo.findByemail(email);
	}

	public Contacts saveContacts(Contacts contacts) {
		// TODO Auto-generated method stub
		return repo.save(contacts);
	}

	
}
