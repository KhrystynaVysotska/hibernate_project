package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.PinCodeDataAccess;
import ua.lviv.ua.model.entity.PinCodeEntity;
import ua.lviv.ua.model.service.AbstractService;

public class PinCodeService extends AbstractService<PinCodeEntity> {

	@Override
	protected DataAccess<PinCodeEntity> getDao() {
		return new PinCodeDataAccess();
	}
}
