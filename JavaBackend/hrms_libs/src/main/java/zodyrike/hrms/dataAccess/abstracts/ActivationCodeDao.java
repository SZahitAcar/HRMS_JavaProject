package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.abstracts.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode,Integer>{

}
