package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.CityDataAccess;
import ua.lviv.ua.model.entity.CityEntity;
import ua.lviv.ua.model.service.AbstractService;

public class CityService extends AbstractService<CityEntity> {

	@Override
	protected DataAccess<CityEntity> getDao() {
		return new CityDataAccess();
	}

}
