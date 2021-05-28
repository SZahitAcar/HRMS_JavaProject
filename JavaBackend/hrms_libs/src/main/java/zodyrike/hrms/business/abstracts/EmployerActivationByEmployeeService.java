package zodyrike.hrms.business.abstracts;

import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.EmployerActivationByEmployee;

public interface EmployerActivationByEmployeeService {

	Result add(EmployerActivationByEmployee employerActivationByEmployee);
}
