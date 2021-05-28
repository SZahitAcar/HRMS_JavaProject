package zodyrike.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employers_activation_by_employees")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerActivationByEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "is_confirmed")
	private boolean isVerified;

	@Column(name = "confirm_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate verifiedDate;
}
