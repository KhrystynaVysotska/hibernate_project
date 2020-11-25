package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.AccountTypeEntity;

public class AccountTypeDataAccess extends AbstractDataAccess<AccountTypeEntity> {

	public AccountTypeDataAccess() {
		super(AccountTypeEntity.class);
	}
}
