package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.AccountEntity;

public class AccountDataAccess extends AbstractDataAccess<AccountEntity> {

	public AccountDataAccess() {
		super(AccountEntity.class);
	}

}
