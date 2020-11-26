package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.BuildingDataAccess;
import ua.lviv.ua.model.entity.BuildingEntity;
import ua.lviv.ua.model.service.AbstractService;

public class BuildingService extends AbstractService<BuildingEntity> {

	@Override
	protected DataAccess<BuildingEntity> getDao() {
		return new BuildingDataAccess();
	}

}
