package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.AccountTypeDataAccess;
import ua.lviv.ua.model.entity.AccountTypeEntity;
import ua.lviv.ua.model.service.AbstractService;

public class AccountTypeService extends AbstractService<AccountTypeEntity> {

	private AccountTypeDataAccess accountTypeDataAccess = new AccountTypeDataAccess();

	@Override
	protected DataAccess<AccountTypeEntity> getDao() {
		return accountTypeDataAccess;
	}
}
