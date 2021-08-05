package country.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import country.controllers.exception.RecordNotFoundException;
import country.persistence.entities.Leads;
import country.persistence.repository.LeadsRepository;


@Service
public class LeadsService {

	@Autowired
	private LeadsRepository leadsRepository;
	
	@Autowired
	public LeadsService(LeadsRepository leadsRepository) {
		this.leadsRepository = leadsRepository;
	}
	
	 @Cacheable(value = "findLeadById", key = "#plid")
	    public Optional<Leads> findCountryById(Long plid) {
	        return leadsRepository.findById(plid);
	    }

	    @Cacheable(value = "getAllLeads")
	    public Iterable<Leads> getAllLeads() {
	        return leadsRepository.findAll();
	    }
	    
	    @Cacheable(value = "findById")
	    public Leads findById(Long plid) {
			if(leadsRepository.findById(plid).isPresent()) {
				return leadsRepository.findById(plid).get();
			}
			return null;
		}
	    
	    public Leads createOrUpdateEmployee(Leads entity) throws RecordNotFoundException 
	    {
	        Optional<Leads> employee = leadsRepository.findById(entity.getPlid());
	         
	        if(employee.isPresent()) 
	        {
	        	Leads newEntity = employee.get();
	            newEntity.setEmail(entity.getEmail());
	            newEntity.setFirst_Name(entity.getFirst_Name());
	            newEntity.setLast_Name(entity.getLast_Name());
	            newEntity.setEmail(entity.getEmail());
	 
	            newEntity = leadsRepository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = leadsRepository.save(entity);
	             
	            return entity;
	        }
	    }

		public Leads fetchLeadsByEmailId(String email) {
			// TODO Auto-generated method stub
			return leadsRepository.findByEmail(email);
		}

		public Leads saveLeads(Leads leads) {
			// TODO Auto-generated method stub
			return leadsRepository.save(leads);
		} 
	
}
