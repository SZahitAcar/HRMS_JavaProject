package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.Employees;

public interface EmployeeDao extends JpaRepository<Employees,Integer>{

}
