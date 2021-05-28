package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.Employers;

public interface EmployerDao extends JpaRepository<Employers,Integer>{
	Employers getById(int id);
}
