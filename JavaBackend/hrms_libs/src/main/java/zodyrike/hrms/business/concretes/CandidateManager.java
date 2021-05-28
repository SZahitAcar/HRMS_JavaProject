package zodyrike.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.CandidateService;
import zodyrike.hrms.core.utilities.business.BusinessRules;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.ErrorResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.CandidateDao;
import zodyrike.hrms.entities.concretes.Candidates;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;

	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}
	
	public Result checkIfInformation(Candidates candidate) {
		if (candidate.getEmail() == "" || candidate.getPassword() == "" || candidate.getLastName() == ""
				|| candidate.getIdentityNumber() == "" || candidate.getFirstName() == "") {
			return new ErrorResult("Tum alanlar doldurulmak zorundadir!");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Candidates>> getAll() {
		
		return new SuccessDataResult<List<Candidates>>(this.candidateDao.findAll(), "Is Arayanlar Listelendi!");
	}

	@Override
	public Result add(Candidates candidate) {
		var result = BusinessRules.run(checkIfInformation(candidate));
		if(result != null) {
			return result;
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Is arayan eklendi");
		
	}

	@Override
	public DataResult<Candidates> getByIdentityNumber(String identityNumber) {
		
		return new SuccessDataResult<Candidates>(this.candidateDao.getByIdentityNumber(identityNumber));
	}


}
