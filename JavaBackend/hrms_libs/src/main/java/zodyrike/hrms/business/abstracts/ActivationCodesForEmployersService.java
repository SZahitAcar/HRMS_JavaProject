package zodyrike.hrms.business.abstracts;

import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.entities.concretes.ActivationCodesForEmployers;

public interface ActivationCodesForEmployersService {

	Result add(ActivationCodesForEmployers activationCodesForEmployers);

	Result verify(String code);

	DataResult<ActivationCodesForEmployers> getByEmployerId(int id);
}
