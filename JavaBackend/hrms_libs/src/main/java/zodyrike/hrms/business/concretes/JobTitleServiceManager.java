package zodyrike.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.JobTitleService;
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
	public List<JobTitle> getAll() {
		// TODO Auto-generated method stub
		return this.jobTitleDao.findAll();
	}

}
