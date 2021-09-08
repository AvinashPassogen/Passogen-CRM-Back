package country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import country.persistence.entities.Sales;
import country.persistence.repository.SalesRepository;

@Service
public class SalesService {
	
	@Autowired
	private SalesRepository Repo;

	public Sales fetchByMonth(String month) {
		// TODO Auto-generated method stub
		return Repo.findByMonth(month);
	}

	public Sales saveSales(Sales sales) {
		// TODO Auto-generated method stub
		return Repo.save(sales);
	}

}
