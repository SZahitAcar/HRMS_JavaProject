package zodyrike.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.JobTitleService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.JobTitleDao;
import zodyrike.hrms.entities.concretes.JobTitle;


@Service
public class JobTitleServiceManager implements JobTitleService{
	
	private JobTitleDao jobTitleDao;

	
	@Autowired
	public JobTitleServiceManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findAll(), "Veriler Listelendi");
				
				
	}

	@Override
	public Result add(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Meslek Tipi eklendi");
	}

}
