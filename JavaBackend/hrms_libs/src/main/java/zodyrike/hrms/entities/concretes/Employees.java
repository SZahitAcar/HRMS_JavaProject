package zodyrike.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
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
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = false)
@Table(name="Employees")
public class Employees extends User{
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	
}
