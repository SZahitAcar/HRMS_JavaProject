package zodyrike.hrms.business.abstracts;

import java.util.List;

import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.Employees;

public interface EmployeeService {
	
	DataResult<List<Employees>> getAll();
	Result add(Employees employee);
	
}
