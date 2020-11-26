package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.StreetDataAccess;
import ua.lviv.ua.model.entity.StreetEntity;
import ua.lviv.ua.model.service.AbstractService;

public class StreetService extends AbstractService<StreetEntity> {

	@Override
	protected DataAccess<StreetEntity> getDao() {
		return new StreetDataAccess();
	}

}
