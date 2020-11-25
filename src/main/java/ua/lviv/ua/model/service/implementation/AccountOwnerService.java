package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.AccountOwnerDataAccess;
import ua.lviv.ua.model.entity.AccountOwnerEntity;
import ua.lviv.ua.model.service.AbstractService;

public class AccountOwnerService extends AbstractService<AccountOwnerEntity> {

	private AccountOwnerDataAccess accountOwnerDataAccess = new AccountOwnerDataAccess();

	@Override
	protected DataAccess<AccountOwnerEntity> getDao() {
		return accountOwnerDataAccess;
	}

	public AccountOwnerEntity findByEmail(String accountOwnerEmail) {
		return accountOwnerDataAccess.findByEmail(accountOwnerEmail);
	}

}
