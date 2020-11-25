package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.AccountOwnerEntity;

public class AccountOwnerDataAccess extends AbstractDataAccess<AccountOwnerEntity> {

	public AccountOwnerDataAccess() {
		super(AccountOwnerEntity.class);
	}
}
