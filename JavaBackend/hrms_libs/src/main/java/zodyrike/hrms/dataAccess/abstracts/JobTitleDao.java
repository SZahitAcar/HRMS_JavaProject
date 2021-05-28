package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{
	JobTitle getByJobPosition(String jobPosition);
}
