package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.Candidates;

public interface CandidateDao extends JpaRepository<Candidates,Integer>{
	Candidates getByIdentityNumber(String identityNumber);
}
