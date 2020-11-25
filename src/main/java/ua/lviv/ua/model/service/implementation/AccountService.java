package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.AccountDataAccess;
import ua.lviv.ua.model.entity.AccountEntity;
import ua.lviv.ua.model.service.AbstractService;

public class AccountService extends AbstractService<AccountEntity> {

	@Override
	protected DataAccess<AccountEntity> getDao() {
		return new AccountDataAccess();
	}
}
