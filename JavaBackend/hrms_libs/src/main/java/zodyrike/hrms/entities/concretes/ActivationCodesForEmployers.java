package zodyrike.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import zodyrike.hrms.entities.abstracts.ActivationCode;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = false)
@Table(name="activation_code_employers")
public class ActivationCodesForEmployers extends ActivationCode{

	
	@Column(name="employer_user_id")
	private int employerId;
}
