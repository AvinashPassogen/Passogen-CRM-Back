package country.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import country.controllers.exception.ResourceNotFoundException;
import country.persistence.entities.Account;
import country.persistence.entities.Contacts;
import country.persistence.entities.Leads;
import country.persistence.repository.LeadRepository;
import country.persistence.repository.LeadsRepository;
import country.service.AccountService;
import country.service.ContactService;
import country.service.LeadsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LeadsController {

		@Autowired
	    private ContactService contservice;
		
		@Autowired
	    private AccountService accservice;
    
	    @Autowired
	    private LeadsRepository leadsRepo;
	    
	    @Autowired
	    private  LeadRepository leadRepo;
	    
	    @Autowired
	    private LeadsService service;
	    
	    @DeleteMapping("/leads/{id}")
	    public Map<String, Boolean> deleteLeads(@PathVariable(value = "id") Long leadsId)
	         throws RelationNotFoundException {
	        Leads leads = leadsRepo.findById(leadsId)
	       .orElseThrow();

	        leadsRepo.delete(leads);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
	    @GetMapping("/leadsAll")
	    public List<Leads> all(){
	    	return this.leadsRepo.findAll();
	    	}
	    
	    @GetMapping("/leads")
	    public ResponseEntity<List<Leads>> getAllTutorials(@RequestParam(required = false) String company)
	    {
	    	System.out.println(company);
	    	try {
	    		List<Leads> tutorials = new ArrayList<Leads>();
	    		if(company == null)
	    			leadsRepo.findAll().forEach(tutorials::add);
	    		else
	    			leadsRepo.findByCompanyContaining(company).forEach(tutorials::add);
	    		
	    		if(tutorials.isEmpty()) {
	    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    		}
	    		
	    		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    	}catch (Exception e) {
	    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }
	    
	    
	    
	    @GetMapping("/leads/{id}")
  		public ResponseEntity<Leads> getLeadsById(@PathVariable(value = "id") Long leadsId)
  				throws ResourceNotFoundException {
  			Leads leads = leadsRepo.findById(leadsId)
  					.orElseThrow(() -> new ResourceNotFoundException("not found for this id :: " +leadsId));
  			return ResponseEntity.ok().body(leads);
         }
	    
	    @PostMapping(value ="/leads")
	 	 public Leads postLeads(@RequestBody Leads leads) throws Exception {
	 	    
	        String tempEmailId = leads.getEmail();
	        if(tempEmailId!=null && !"".equals(tempEmailId)) {
	            Contacts userObject = contservice.fetchContByEmailId(tempEmailId);
	            if(userObject!=null) {
	                throw new Exception("Contact with "+tempEmailId+" is already exist");
	            }
	            
	            if(tempEmailId!=null && !"".equals(tempEmailId)) {
		            Account contObject = accservice.fetchAccByEmailId(tempEmailId);
		            if(contObject!=null) {
		                throw new Exception("Account with "+tempEmailId+" is already exist");
		            }
		        }
	        }
	        
	        Leads userObject = null;
	        userObject = service.saveLeads(leads);
	        return userObject;

	 	  }
	    
	    @PutMapping("/leads/{id}")
	    public ResponseEntity<Leads> updateLeads(@PathVariable(value = "id") Long leadstId,
	         @Validated @RequestBody Leads leadsDetails) throws RelationNotFoundException {
	        Leads leads = leadsRepo.findById(leadstId)
	        .orElseThrow();
            leads.setEmail(leadsDetails.getEmail());
	        leads.setSalutation(leadsDetails.getSalutation());
	        leads.setFirst_Name(leadsDetails.getFirst_Name());
	        leads.setMiddle_Name(leadsDetails.getMiddle_Name());
	        leads.setLast_Name(leadsDetails.getLast_Name());
	        leads.setTitle(leadsDetails.getTitle());
	        leads.setCompany(leadsDetails.getCompany());
	        leads.setIndustry(leadsDetails.getIndustry());
	        leads.setPhone_Number(leadsDetails.getPhone_Number());
	        leads.setMobile_Number(leadsDetails.getMobile_Number());
	        leads.setLead_Status(leadsDetails.getLead_Status());
	        leads.setOwner(leadsDetails.getOwner());
	        leads.setNo_Of_Employees(leadsDetails.getNo_Of_Employees());
	        leads.setLead_Source(leadsDetails.getLead_Source());
	        leads.setAddress(leadsDetails.getAddress());
	        leads.setPincode(leadsDetails.getPincode());
	        leads.setCountry(leadsDetails.getCountry());
	        leads.setState(leadsDetails.getState());
	        leads.setCity(leadsDetails.getCity());
	        leads.setRating(leadsDetails.getRating());
	        final Leads updatedLeads =leadsRepo.save(leads);
	        return ResponseEntity.ok(updatedLeads);
	    }
	    
	    @RequestMapping(value = "/leadcount", method = RequestMethod.GET)
		@ResponseBody
		public long countEntities() {
			long count = leadRepo.count();
			return count;
		}

}
