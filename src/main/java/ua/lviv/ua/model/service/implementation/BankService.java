package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.BankDataAccess;
import ua.lviv.ua.model.entity.BankEntity;
import ua.lviv.ua.model.service.AbstractService;

public class BankService extends AbstractService<BankEntity> {

	@Override
	protected DataAccess<BankEntity> getDao() {
		return new BankDataAccess();
	}
}
