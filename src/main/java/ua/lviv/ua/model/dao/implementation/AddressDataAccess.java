package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.AdressEntity;

public class AddressDataAccess extends AbstractDataAccess<AdressEntity> {

	public AddressDataAccess() {
		super(AdressEntity.class);
	}

}
