package zodyrike.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zodyrike.hrms.business.abstracts.CandidateService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.entities.concretes.Candidates;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	CandidateService candidateManager;

	
	@Autowired
	public CandidatesController(CandidateService candidateManager) {
		super();
		this.candidateManager = candidateManager;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidates>> getAll() {
		
	
		return this.candidateManager.getAll();
	}
}
