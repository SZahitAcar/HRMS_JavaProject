package zodyrike.hrms.business.concretes;


import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.UserService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.dataAccess.abstracts.UserDao;
import zodyrike.hrms.entities.abstracts.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public DataResult<User> getByEmail(String email) {
		
		
		return new SuccessDataResult<User>(this.userDao.getByEmail(email));
	}

}
