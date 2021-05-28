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
@Table(name="activation_code_candidates")
public class ActivationCodesForCandidates extends ActivationCode{

	
	@Column(name="candidate_user_id")
	private int candidateId;
}
