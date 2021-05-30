package zodyrike.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<JobAdvertisement> changeStatus(int employers, int id, boolean isActive);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getByApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployers_CompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getByEmployers(int id);
	
	
}
