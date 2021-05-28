package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.EmployerActivationByEmployee;

public interface EmployerActivationByEmployeeDao extends JpaRepository<EmployerActivationByEmployee,Integer>{

}
