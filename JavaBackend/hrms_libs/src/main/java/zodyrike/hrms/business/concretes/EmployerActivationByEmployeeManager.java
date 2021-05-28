package zodyrike.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.EmployerActivationByEmployeeService;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.EmployerActivationByEmployeeDao;
import zodyrike.hrms.entities.concretes.EmployerActivationByEmployee;

@Service
public class EmployerActivationByEmployeeManager implements EmployerActivationByEmployeeService{

	EmployerActivationByEmployeeDao employerActivationByEmployeeDao;
	
	public EmployerActivationByEmployeeManager(EmployerActivationByEmployeeDao employerActivationByEmployeeDao) {
		super();
		this.employerActivationByEmployeeDao = employerActivationByEmployeeDao;
	}

	@Override
	public Result add(EmployerActivationByEmployee employerActivationByEmployee) {
		employerActivationByEmployee.setVerified(true);
		employerActivationByEmployee.setVerifiedDate(LocalDate.now());
		employerActivationByEmployeeDao.save(employerActivationByEmployee);
		return new SuccessResult("Isveren onayi tamamlandi");
	}

}
