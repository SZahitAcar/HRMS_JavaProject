package zodyrike.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zodyrike.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User,Integer>{
	User getByEmail(String email);
}
