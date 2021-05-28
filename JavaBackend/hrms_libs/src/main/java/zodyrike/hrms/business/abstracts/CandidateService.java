package zodyrike.hrms.business.abstracts;

import java.util.List;

import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.Candidates;

public interface CandidateService {
	DataResult<List<Candidates>> getAll();
	
	Result add(Candidates candidate);

	DataResult<Candidates> getByIdentityNumber(String identityNumber);
	
	
}
