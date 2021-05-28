package zodyrike.hrms.business.abstracts;

import java.util.List;

import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.Employers;

public interface EmployerService {
	DataResult<List<Employers>> getAll();
	
	Result add(Employers employer);
	
	DataResult<Employers> getById(int id);
}
