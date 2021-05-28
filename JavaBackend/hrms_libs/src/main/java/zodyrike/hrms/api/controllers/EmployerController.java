package zodyrike.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zodyrike.hrms.business.abstracts.EmployerService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.entities.concretes.Employers;

@RestController
@RequestMapping("api/employers")
public class EmployerController {

	private EmployerService employerService;

	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employers>> getAll() {
		
		
		return this.employerService.getAll();
	}
}
