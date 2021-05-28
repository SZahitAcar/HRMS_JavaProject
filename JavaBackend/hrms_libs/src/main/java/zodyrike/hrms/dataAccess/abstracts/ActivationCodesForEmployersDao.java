package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.ActivationCodesForEmployers;

public interface ActivationCodesForEmployersDao extends JpaRepository<ActivationCodesForEmployers,Integer>{
	ActivationCodesForEmployers getByEmployerId(int id);
}
