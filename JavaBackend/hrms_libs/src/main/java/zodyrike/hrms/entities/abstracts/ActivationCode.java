package zodyrike.hrms.entities.abstracts;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="activation_codes")
@Inheritance(strategy = InheritanceType.JOINED)
public class ActivationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "activation_code")
	private String activationCode;

	@Column(name = "is_confirmed")
	private boolean isVerified;

	@Column(name = "confirm_date", columnDefinition = "Data default CURRENT_DATE")
	private LocalDate verifiedDate;

}
