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
@Table(name="Employers")

public class Employers extends User{
		
		@Column(name="company_name")
		private String companyName;
		
		@Column(name="web_adress")
		private String webAdress;
		
		@Column(name="phone_number")
		private String phoneNumber;
		
}	
