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
import country.persistence.entities.task;
import country.persistence.repository.TaskRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskRepository TaskRepository;
	
	@GetMapping("/task")
	  public ResponseEntity<List<task>> getAllTutorials(@RequestParam(required = false) String subject) {
	    try {
	      List<task> tutorials = new ArrayList<task>();

	      if (subject == null)
	    	  TaskRepository.findAll().forEach(tutorials::add);
	      else
	    	  TaskRepository.findBySubjectContaining(subject).forEach(tutorials::add);

	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	@GetMapping("/task/{id}")
	public ResponseEntity<task> getContactById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException{
		task  task = TaskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("not found for this id ::" + id));
		return ResponseEntity.ok().body(task);
	}
	
	 @DeleteMapping("/task/{id}")
	    public Map<String, Boolean> deleteContact(@PathVariable(value = "id") Long id)
	         throws ResourceNotFoundException {
	        task task = TaskRepository.findById(id)
	       .orElseThrow(null);

	        TaskRepository.delete(task);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
	 @PutMapping("/task/{id}")
	    public ResponseEntity<task> updateContact(@PathVariable(value = "id") Long id,
	         @Validated @RequestBody task taskDetails) throws ResourceNotFoundException {
	        task task = TaskRepository.findById(id)
	        .orElseThrow(null);	        
	        task.setsubject(taskDetails.getsubject());
	        task.setassigned(taskDetails.getassigned());
	        task.setdate1(taskDetails.getdate1());
	        task.sett_name(taskDetails.gett_name());
	        task.setcomments(taskDetails.getcomments());
	        task.setpriority(taskDetails.getpriority());
	        task.setstatus(taskDetails.getstatus());
	        task.setdate2(( taskDetails).getdate2());
	        task.settime1(taskDetails.gettime1());
	        final task updatedtask = TaskRepository.save(task);
	        return ResponseEntity.ok(updatedtask);
	    }
	
		
	  
	   /* @PostMapping(value ="/task")
		 public ResponseEntity<task> posttask(@RequestBody task task1){
			 try {
				 TaskRepository.save(task1);
				 return new ResponseEntity<>(task1,Httpstatus.CREATED);
			 } catch (Exception e) {
				 return new ResponseEntity<>(null, Httpstatus.EXPECTATION_FAILED);
			 }
		 }
		*/
	    
	    @PostMapping(value ="/task")
		 public ResponseEntity<task> posttask(@RequestBody task task){
			 try {
				 task _task = TaskRepository.save(new task (0,
						 task.getsubject(),
						 task.getassigned(),
						 task.gett_name(),
						 task.getcomments(),
						 task.getstatus(),
						 task.getpriority(),
						 task.getdate1(),
						 task.getdate2(),
						 task.gettime1()
						 ));
				 return new ResponseEntity<>(_task,HttpStatus.CREATED);
			 } catch (Exception e) {
				 return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			 }
		 }

		 @PostMapping("/insertTask")
			public String insertTask(@RequestBody task task) {
		    	System.out.println(task);
		    	TaskRepository.save(task);
				return "Record Saved";
				
			}
}
