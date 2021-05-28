package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.ActivationCodesForCandidates;


public interface ActivationCodesForCandidatesDao extends JpaRepository<ActivationCodesForCandidates,Integer>{
	ActivationCodesForCandidates getByCandidateId(int id);
}
