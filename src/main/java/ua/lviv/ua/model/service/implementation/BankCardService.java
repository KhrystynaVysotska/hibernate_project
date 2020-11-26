package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.BankCardDataAccess;
import ua.lviv.ua.model.entity.BankCardEntity;
import ua.lviv.ua.model.service.AbstractService;

public class BankCardService extends AbstractService<BankCardEntity> {

	@Override
	protected DataAccess<BankCardEntity> getDao() {
		return new BankCardDataAccess();
	}

}
