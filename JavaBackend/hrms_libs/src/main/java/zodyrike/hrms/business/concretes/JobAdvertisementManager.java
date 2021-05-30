package zodyrike.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.JobAdvertisementService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.ErrorDataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.JobAdvertisementDao;
import zodyrike.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

		LocalDate now = LocalDate.now();
		jobAdvertisement.getReleaseDate().equals(now);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Is ilanlari Basariyla Listelendi");
	}

	@Override
	public DataResult<JobAdvertisement> changeStatus(int employers, int id, boolean isActive) {
		List<JobAdvertisement> advertisements = this.jobAdvertisementDao.getByEmployers(employers);
		
		for(JobAdvertisement jobAdvertisement : advertisements) {
			jobAdvertisement.setActive(isActive);
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
		}
		
		return new ErrorDataResult<JobAdvertisement>("Hata Olustu");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByApplicationDeadlineLessThanEqual(LocalDate date) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByApplicationDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndApplicationDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployers_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployers_CompanyName(companyName));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployers(int id) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployers(id));
	}

}
