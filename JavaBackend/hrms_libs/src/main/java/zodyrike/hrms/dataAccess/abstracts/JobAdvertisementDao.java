package zodyrike.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{
	
	List<JobAdvertisement> getByIsActiveTrue();
	List<JobAdvertisement> getByApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvertisement> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvertisement> getByIsActiveTrueAndEmployers_CompanyName(String companyName);
	List<JobAdvertisement> getByEmployers(int id);
	
	JobAdvertisement getById(int id);
}
