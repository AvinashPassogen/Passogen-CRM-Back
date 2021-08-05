package country.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import country.controllers.exception.ResourceNotFoundException;
import country.persistence.entities.Contacts;
import country.persistence.entities.Leads;
import country.persistence.repository.ContactsRepository;
import country.service.ContactService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Contactscontroller {

	@Autowired
	private ContactsRepository ContactsRepository;
	
	@Autowired
	private ContactService service;
	
	 @GetMapping("/Contacts")
	  public ResponseEntity<List<Contacts>> getAllTutorials(@RequestParam(required = false) String title) {
	    try {
	      List<Contacts> tutorials = new ArrayList<Contacts>();

	      if (title == null)
	    	  ContactsRepository.findAll().forEach(tutorials::add);
	      else
	    	  ContactsRepository.findByTitleContaining(title).forEach(tutorials::add);

	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	@GetMapping("/Contacts/{id}")
	public ResponseEntity<Contacts> getContactsById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException{
		Contacts contacts = ContactsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("not found for this id ::" + id));
		return ResponseEntity.ok().body(contacts);
	}
	
	 @DeleteMapping("/Contacts/{id}")
	    public Map<String, Boolean> deleteContacts(@PathVariable(value = "id") Long id)
	         throws ResourceNotFoundException {
	        Contacts contacts = ContactsRepository.findById(id)
	       .orElseThrow();

	        ContactsRepository.delete(contacts);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	 
	 @PutMapping("/Contacts/{id}")
	    public ResponseEntity<Contacts> updateContacts(@PathVariable(value = "id") Long id,
	         @Validated @RequestBody Contacts ContactsDetails) throws ResourceNotFoundException {
	        Contacts contacts = ContactsRepository.findById(id)
	        .orElseThrow();

	        contacts.setsalutation(ContactsDetails.getsalutation());
	        contacts.setfirst_Name(ContactsDetails.getfirst_Name());
	        contacts.setmiddle_Name(ContactsDetails.getmiddle_Name());
	        contacts.setlast_Name(ContactsDetails.getlast_Name());
	        contacts.setcontacts_owner(ContactsDetails.getcontacts_owner());
	        contacts.setaccount_Name(ContactsDetails.getaccount_Name());
	        contacts.setreports_To(ContactsDetails.getreports_To());
	        contacts.setTitle(ContactsDetails.getTitle());
	        contacts.setDepartment(ContactsDetails.getDepartment());
	        contacts.setEmail(ContactsDetails.getEmail());
	        contacts.setFax(ContactsDetails.getFax());
	        contacts.setphone_Number(ContactsDetails.getphone_Number());
	        contacts.setmobile_Number(ContactsDetails.getmobile_Number());
	        contacts.setaddress(ContactsDetails.getaddress());
	        contacts.setstreet(ContactsDetails.getstreet());
	        contacts.setcity(ContactsDetails.getcity());
	        contacts.setstate(ContactsDetails.getstate());
	        contacts.setpincode(ContactsDetails.getpincode());
	        contacts.setcountry(ContactsDetails.getcountry());
	        final Contacts updatedContacts = ContactsRepository.save(contacts);
	        return ResponseEntity.ok(updatedContacts);
	    }
	 
	 
	 @PostMapping(value ="/Contacts")
	 public Contacts postContacts(@RequestBody Contacts contacts) throws Exception{

		 String tempEmailId = contacts.getEmail();
	        if(tempEmailId!=null && !"".equals(tempEmailId)) {
	        	Contacts userObject = service.fetchContByEmailId(tempEmailId);
	            if(userObject!=null) {
	                throw new Exception("Contact with "+tempEmailId+" is already exist");
	            }
	        }
	        
	        Contacts userObject = null;
	        userObject = service.saveContacts(contacts);
	        return userObject;
	 }
	

}
