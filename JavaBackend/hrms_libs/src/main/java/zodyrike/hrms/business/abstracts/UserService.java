package zodyrike.hrms.business.abstracts;


import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.entities.abstracts.User;


public interface UserService {
		
	DataResult<User> getByEmail(String email);
	
}
