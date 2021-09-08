package country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import country.persistence.repository.OpportunityRepository;

@Service
public class OppoService {
	
	@Autowired
	private OpportunityRepository opporepo;
	
	

}
