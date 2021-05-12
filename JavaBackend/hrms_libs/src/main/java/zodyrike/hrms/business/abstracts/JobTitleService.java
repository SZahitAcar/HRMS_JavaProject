package zodyrike.hrms.business.abstracts;

import java.util.List;

import zodyrike.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
