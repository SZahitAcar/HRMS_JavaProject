package zodyrike.hrms.business.abstracts;

import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.dataTransferObject.CandidatesForRegisterDto;
import zodyrike.hrms.entities.dataTransferObject.EmployerForRegisterDto;

public interface AuthService {

	Result registerForCandidates(CandidatesForRegisterDto candidatesRegister);
	Result registerForEmployer(EmployerForRegisterDto employerRegister);
	
}
