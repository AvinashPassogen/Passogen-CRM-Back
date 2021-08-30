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
import country.persistence.entities.Opportunity;
import country.persistence.repository.AccountRepository;
import country.persistence.repository.AccountsRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AccountController {
	
	  @Autowired
	  private AccountRepository AccountRepo;
	  
	  @Autowired
	  private AccountsRepository AccountsRepo;
	  
	  
	  @GetMapping("/account")
	  public ResponseEntity<List<Account>> getAllTutorials(@RequestParam(required = false) String type) {
	    try {
	      List<Account> tutorials = new ArrayList<Account>();

	      if (type == null)
	    	  AccountRepo.findAll().forEach(tutorials::add);
	      else
	    	  AccountRepo.findByTypeContaining(type).forEach(tutorials::add);

	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/account/{id}")
		public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Long accountId)
				throws ResourceNotFoundException {
			Account account = AccountRepo.findById(accountId)
					.orElseThrow(() -> new ResourceNotFoundException("not found for this id :: " +accountId));
			return ResponseEntity.ok().body(account);
       }
	  
	  @DeleteMapping("/account/{id}")
	    public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Long accountId)
	         throws RelationNotFoundException {
	        Account account = AccountRepo.findById(accountId)
	       .orElseThrow();

	        AccountRepo.delete(account);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	  
	  
	  @PostMapping(value ="/account")
	   public ResponseEntity<Account> postAccount(@RequestBody Account account) {
	    try {
	    	System.out.println(account);
	    	Account _account = AccountRepo.save(new Account( 0,
	    			account.getAccount_name(),
	    			account.getAccount_owner(),
	    			account.getType(),
	    			
	    			account.getWebsite(),
	    			account.getParent_account(),
	    			account.getDescription(),
	    			account.getIndustry(),
	    			account.getPhone_Number(),
	    			account.getAddress(),
	    			account.getEmail(),
	    			account.getCountry(),
	    			account.getState(),
	    			account.getCity(),
	    			account.getEmployee(),
	    			account.getPincode() ));
	      return new ResponseEntity<>(_account, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  @PutMapping("/account/{id}")
	    public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") Long accountId,
	         @Validated @RequestBody Account accountDetails) throws RelationNotFoundException {
	        Account account =AccountRepo.findById(accountId)
	        .orElseThrow();
	        account.setAccount_name(accountDetails.getAccount_name());
	        account.setAccount_owner(accountDetails.getAccount_owner());
	        account.setType(accountDetails.getType());
	        account.setWebsite(accountDetails.getWebsite());
	        account.setParent_account(accountDetails.getParent_account());
	        account.setDescription(accountDetails.getDescription());
	        account.setIndustry(accountDetails.getIndustry());
	        account.setPhone_Number(accountDetails.getPhone_Number());
	        account.setEmployee(accountDetails.getEmployee());
	        account.setAddress(accountDetails.getAddress());
	        account.setPincode(accountDetails.getPincode());
	        account.setCountry(accountDetails.getCountry());
	        account.setState(accountDetails.getState());
	        account.setCity(accountDetails.getCity());
	       
	        final Account updatedAccount =AccountRepo.save(account);
	        return ResponseEntity.ok(updatedAccount);
	    }
    
	  @RequestMapping(value = "/accountCount", method = RequestMethod.GET)
		@ResponseBody
		public long countEntities() {
			long count = AccountsRepo.count();
			return count;
		}

}
