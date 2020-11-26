package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.AddressDataAccess;
import ua.lviv.ua.model.entity.AdressEntity;
import ua.lviv.ua.model.service.AbstractService;

public class AddressService extends AbstractService<AdressEntity> {

	@Override
	protected DataAccess<AdressEntity> getDao() {
		return new AddressDataAccess();
	}

}
