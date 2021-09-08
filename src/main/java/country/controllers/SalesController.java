package country.controllers;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import country.persistence.entities.Sales;
import country.persistence.repository.SalesRepository;
import country.service.SalesService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalesController {
	
	@Autowired
	private OppoController oppo;
	
	@Autowired
	private SalesRepository repo;
	
	@Autowired
	private SalesService service;
	
	@GetMapping("/TotalSales")
	public List<Sales> all(){
		return this.repo.findAll();
	}

	@PostMapping("/insertSales")
	public Sales addSales(@RequestBody Sales sales) throws Exception {
		String tempMonth = sales.getMonth();
		int tempSales = sales.getTotalSales();
		if(tempMonth !=null && !"".equals(tempMonth)) {
			Sales salesObj = service.fetchByMonth(tempMonth);
			if(salesObj!=null)
			{           
				int totalSales = salesObj.getTotalSales() + tempSales;
				sales.setTotalSales(totalSales);
				System.out.println(salesObj.getSid());
				this.oppo.updateSales(salesObj.getSid(), totalSales);
				throw new Exception("Month "+tempMonth+" is already exist");

			}
		}
		Sales salesObj = null;
		salesObj = service.saveSales(sales);
		return salesObj;
	}
	
	
}
