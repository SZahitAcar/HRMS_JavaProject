package zodyrike.hrms.entities.dataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatesForRegisterDto {
	
	private String firstName;
	private String lastName;
	private String nationalityId;
	private int birthYear;
	private String email;
	private String password;
	private String passwordRepeat;
}
