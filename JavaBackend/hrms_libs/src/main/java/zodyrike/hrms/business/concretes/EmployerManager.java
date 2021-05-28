package zodyrike.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.EmployerService;
import zodyrike.hrms.core.utilities.business.BusinessRules;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.ErrorResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.EmployerDao;
import zodyrike.hrms.entities.concretes.Employers;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	public Result checkIfInformation(Employers employer) {
		if (employer.getEmail() == "" || employer.getCompanyName() == "" || employer.getPassword() == ""
				|| employer.getPhoneNumber() == "" || employer.getWebAdress() == "") {
			return new ErrorResult("Tum alanlar doldurulmak zorundadir!");
		}
		return new SuccessResult();
	}
	
	@Override
	public Result add(Employers employer) {
		var result = BusinessRules.run(checkIfInformation(employer));
		if (result != null) {
			return result;
		}
		employerDao.save(employer);
		return new SuccessResult("İşveren eklendi");
	}
	
	

	@Override
	public DataResult<List<Employers>> getAll() {

		return new SuccessDataResult<List<Employers>>
		(this.employerDao.findAll(),"Veriler Listelendi");
	}

	@Override
	public DataResult<Employers> getById(int id) {

		return new SuccessDataResult<Employers>
		(this.employerDao.getById(id),"Veriler Listelendi");
	}
	
}
