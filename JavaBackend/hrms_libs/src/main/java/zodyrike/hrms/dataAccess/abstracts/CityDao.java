package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer>{

}
