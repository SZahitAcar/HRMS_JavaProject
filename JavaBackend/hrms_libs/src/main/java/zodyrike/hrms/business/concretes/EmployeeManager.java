package zodyrike.hrms.business.concretes;

import java.util.List;

import zodyrike.hrms.business.abstracts.EmployeeService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.EmployeeDao;
import zodyrike.hrms.entities.concretes.Employees;

public class EmployeeManager implements EmployeeService{

	EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employees>> getAll() {

		return new SuccessDataResult<List<Employees>>(this.employeeDao.findAll());
	}

	@Override
	public Result add(Employees employee) {
		
		this.employeeDao.save(employee);
		return new SuccessResult("Calisan eklendi");
	}

}
