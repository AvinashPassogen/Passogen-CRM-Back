package country.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.RelationNotFoundException;

import org.hibernate.mapping.Set;
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
import country.persistence.entities.Leads;
import country.persistence.entities.Opportunity;
import country.persistence.entities.Sales;
import country.persistence.entities.task;
import country.persistence.repository.OppoRepo;
import country.persistence.repository.OpportunityRepository;
import country.persistence.repository.SalesRepository;
import country.service.SalesService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OppoController {
	
	@Autowired
	private SalesRepository repo;
	
	@Autowired
	private SalesService service;

	@Autowired
	OppoRepo oppoRepo;
	
	@Autowired
	private OpportunityRepository OppoRepo;
	
	@PostMapping("/Oppo")
	public String insertOppo(@RequestBody Opportunity oppo) {
		System.out.println(oppo);
		oppoRepo.save(oppo);
		return "Record Saved";
	}
	
	@GetMapping("/OppoAll")
    public List<Opportunity> all(){
        return this.oppoRepo.findAll();
    }
	
	@GetMapping("/Oppo")
	  public ResponseEntity<List<Opportunity>> getAllTutorials(@RequestParam(required = false) String opportunity) {
	    System.out.println(opportunity);
		try {
	      List<Opportunity> tutorials = new ArrayList<Opportunity>();

	      if (opportunity == null)
	    	  oppoRepo.findAll().forEach(tutorials::add);
	      else
	    	  oppoRepo.findByOpportunityContaining(opportunity).forEach(tutorials::add);

	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/Oppo/{id}")
		public ResponseEntity<Opportunity> getOppoById(@PathVariable(value = "id") Long opportunityId)
				throws ResourceNotFoundException {
			Opportunity oppo = oppoRepo.findById(opportunityId)
					.orElseThrow(() -> new ResourceNotFoundException("not found for this id :: " +opportunityId));
			return ResponseEntity.ok().body(oppo);
     }
	
	@DeleteMapping("/Oppo/{id}")
    public Map<String, Boolean> deleteLeads(@PathVariable(value = "id") Long opportunityId)
         throws RelationNotFoundException {
		Opportunity oppo = oppoRepo.findById(opportunityId)
       .orElseThrow();

        oppoRepo.delete(oppo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	@PutMapping("/Oppo/{id}")
    public ResponseEntity<Opportunity> updateOppo(@PathVariable(value = "id") Long id,
         @Validated @RequestBody Opportunity oppoDetails) throws RelationNotFoundException {
        Opportunity oppo = oppoRepo.findById(id)
        .orElseThrow();
        oppo.setOpportunity(oppoDetails.getOpportunity());
        oppo.setOpportunity_owner(oppoDetails.getOpportunity_owner());
        oppo.setType(oppoDetails.getType());
        oppo.setPrimary_csource(oppoDetails.getPrimary_csource());
        oppo.setPrimary_csource(oppoDetails.getPrimary_csource());
        oppo.setBudget_confirmed(oppoDetails.getBudget_confirmed());
        oppo.setClose_date(oppoDetails.getClose_date());
        oppo.setAccount_name(oppoDetails.getAccount_name());
        oppo.setNext_step(oppoDetails.getNext_step());
        oppo.setLead_source(oppoDetails.getLead_source());
        oppo.setProbability(oppoDetails.getProbability());
        oppo.setROI_Analysis_Completed(oppoDetails.getROI_Analysis_Completed());
        oppo.setDiscovery_Completed(oppoDetails.getDiscovery_Completed());
        oppo.setStage(oppoDetails.getStage());
        oppo.setAmount(oppoDetails.getAmount());
        oppo.setDescription(oppoDetails.getDescription());
        oppo.setLoss_reason(oppoDetails.getLoss_reason());

        final Opportunity updatedOppo =oppoRepo.save(oppo);
        return ResponseEntity.ok(updatedOppo);
    }
	
	@GetMapping("/countOppo")
    public List<Opportunity> findOppo(){
        return this.OppoRepo.allOppo();
    }
	
	@PutMapping("/sales/{sid}")
	public void updateSales(long sid, int totalSales) {
		// TODO Auto-generated method stub
		Sales sales = repo.findById(sid)
				.orElseThrow();
		sales.setTotalSales(totalSales);
		final Sales updateSales = repo.save(sales);
	}
	
	
}
