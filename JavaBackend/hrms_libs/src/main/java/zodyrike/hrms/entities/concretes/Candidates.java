package zodyrike.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import zodyrike.hrms.entities.abstracts.User;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
// If this class extends from another table we should use this notation below.
@EqualsAndHashCode(callSuper = false)
@Table(name="Candidates")
public class Candidates extends User{

	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birthdate")
	private Date birthDate;
	
	
}
