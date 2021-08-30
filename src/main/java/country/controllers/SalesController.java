package country.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import country.persistence.entities.Sales;
import country.persistence.repository.SalesRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalesController {
	
	@Autowired
	private SalesRepository Repo;
	
	@GetMapping("/TotalSales")
	public List<Sales> all(){
		return this.Repo.findAll();
	}

}
