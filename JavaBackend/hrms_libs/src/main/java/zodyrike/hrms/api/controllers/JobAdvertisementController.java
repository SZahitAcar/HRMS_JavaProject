package zodyrike.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zodyrike.hrms.business.abstracts.JobAdvertisementService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {
	
	JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
		
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return this.jobAdvertisementService.getByIsActiveTrue();
		
	}
	
	@GetMapping("/getByApplicationDeadline")
	public DataResult<List<JobAdvertisement>> getByApplicationDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		
		return this.jobAdvertisementService.getByApplicationDeadlineLessThanEqual(date);
	}
	
	@GetMapping("/getByEmployer")
	public DataResult<List<JobAdvertisement>> getByEmployers(@RequestParam int id) {
		return this.jobAdvertisementService.getByEmployers(id);
	}
	
	@GetMapping("/changeStatus")
	public DataResult<JobAdvertisement> changeStatus(@RequestParam int employers, @RequestParam int id, @RequestParam boolean status) {
		return this.jobAdvertisementService.changeStatus(employers, id, status);
	}
	
}
