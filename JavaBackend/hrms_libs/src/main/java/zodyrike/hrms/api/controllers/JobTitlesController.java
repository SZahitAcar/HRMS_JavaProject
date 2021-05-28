package zodyrike.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zodyrike.hrms.business.abstracts.JobTitleService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
	
	JobTitleService jobTitleManager;
	
	@Autowired
	public JobTitlesController(JobTitleService jobTitleManager) {
		super();
		this.jobTitleManager = jobTitleManager;
	}

	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll(){
		
		return this.jobTitleManager.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleManager.add(jobTitle);
		
	}
	
	
}
