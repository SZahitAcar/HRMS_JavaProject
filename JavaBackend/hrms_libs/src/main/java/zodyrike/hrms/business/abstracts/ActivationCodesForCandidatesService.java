package zodyrike.hrms.business.abstracts;

import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.ActivationCodesForCandidates;


public interface ActivationCodesForCandidatesService {

	
	Result add(ActivationCodesForCandidates activationCodesForCandidates);

	Result verify(String code);

	DataResult<ActivationCodesForCandidates> getByCandidateId(int id);
}
