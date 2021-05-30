package zodyrike.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zodyrike.hrms.business.abstracts.CityService;
import zodyrike.hrms.core.utilities.results.DataResult;
import zodyrike.hrms.core.utilities.results.Result;
import zodyrike.hrms.core.utilities.results.SuccessDataResult;
import zodyrike.hrms.core.utilities.results.SuccessResult;
import zodyrike.hrms.dataAccess.abstracts.CityDao;
import zodyrike.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	CityDao cityDao;
	
	@Autowired
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Sehir bilgisi listelendi");
	}

	@Override
	public Result add(City city) {

		this.cityDao.save(city);
		return new SuccessResult("Sehir basariyla eklendi");
	}

}
