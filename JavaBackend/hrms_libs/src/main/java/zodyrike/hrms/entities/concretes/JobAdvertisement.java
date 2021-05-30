package zodyrike.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisement")


public class JobAdvertisement {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_position")
	private int openPosition;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employers employers;
	
	@ManyToOne()
	@JoinColumn(name="job_id")
	private JobTitle jobTitle;
	
	
	
	
	
	
	
	
	
	
	
	
}
