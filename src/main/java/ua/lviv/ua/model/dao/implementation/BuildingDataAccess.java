package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.BuildingEntity;

public class BuildingDataAccess extends AbstractDataAccess<BuildingEntity> {

	public BuildingDataAccess() {
		super(BuildingEntity.class);
	}

}
