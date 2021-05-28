package zodyrike.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.ActivationCodesForCandidatesService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.ErrorResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.ActivationCodesForCandidatesDao;
import zodyrike.hrms.entities.concretes.ActivationCodesForCandidates;

@Service
public class ActivationCodesForCandidatesManager implements ActivationCodesForCandidatesService{

	ActivationCodesForCandidatesDao activationCodesForCandidatesDao;
	
	public ActivationCodesForCandidatesManager(ActivationCodesForCandidatesDao activationCodesForCandidatesDao) {
		super();
		this.activationCodesForCandidatesDao = activationCodesForCandidatesDao;
	}
	
	@Override
	public Result add(ActivationCodesForCandidates activationCodesForCandidates) {

		activationCodesForCandidatesDao.save(activationCodesForCandidates);
		return new SuccessResult("Aktivasyon kodu gonderildi!");
	}

	@Override
	public Result verify(String code) {

		String[] parse = code.split("-");
		var result = getByCandidateId(Integer.parseInt(parse[1]));
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		if (!result.getData().getActivationCode().equals(code)) {
			return new ErrorResult("Doğrulama başarısız");
		}
		result.getData().setVerified(true);
		result.getData().setVerifiedDate(LocalDate.now());
		activationCodesForCandidatesDao.save(result.getData());
		return new SuccessResult("Doğrulama başarılı");
	}

	@Override
	public DataResult<ActivationCodesForCandidates> getByCandidateId(int id) {
		
		
		return new SuccessDataResult<ActivationCodesForCandidates>(this.activationCodesForCandidatesDao.getByCandidateId(id));
	}

}
