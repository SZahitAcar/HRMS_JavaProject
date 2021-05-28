package zodyrike.hrms.business.concretes;

import java.time.LocalDate;

import zodyrike.hrms.business.abstracts.ActivationCodesForEmployersService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.ErrorDataResult;
import zodyrike.hrms.core.utilities.results.ErrorResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.ActivationCodesForEmployersDao;
import zodyrike.hrms.entities.concretes.ActivationCodesForEmployers;

public class ActivationCodesForEmployersManager implements ActivationCodesForEmployersService{

	ActivationCodesForEmployersDao activationCodesForEmployersDao;
	
	
	public ActivationCodesForEmployersManager(ActivationCodesForEmployersDao activationCodesForEmployersDao) {
		super();
		this.activationCodesForEmployersDao = activationCodesForEmployersDao;
	}

	@Override
	public Result add(ActivationCodesForEmployers activationCodesForEmployers) {
		this.activationCodesForEmployersDao.save(activationCodesForEmployers);
		return new SuccessResult("Is arayanlar eklendi!");
	}

	@Override
	public Result verify(String code) {
		
		
		String[] parse = code.split("-");
		var result = getByEmployerId(Integer.parseInt(parse[1]));
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		if (!result.getData().getActivationCode().equals(code)) {
			return new ErrorResult("Doğrulama geçersiz");
		}
		result.getData().setVerified(true);
		result.getData().setVerifiedDate(LocalDate.now());
		activationCodesForEmployersDao.save(result.getData());
		return new SuccessResult("Doğrulama başarılı");
		
	}

	@Override
	public DataResult<ActivationCodesForEmployers> getByEmployerId(int id) {
		
		
		var result = activationCodesForEmployersDao.getByEmployerId(id);
		if (result == null) {
			return new ErrorDataResult<ActivationCodesForEmployers>("Kullanıcıya ait kod bulunamadı");
		}
		return new SuccessDataResult<ActivationCodesForEmployers>(result);
	}

}
