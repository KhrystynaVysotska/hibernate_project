package ua.lviv.ua.model.dao.implementation;

import org.hibernate.Session;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.AccountTypeEntity;
import ua.lviv.ua.utils.HibernateUtil;

public class AccountTypeDataAccess extends AbstractDataAccess<AccountTypeEntity> {

	public AccountTypeDataAccess() {
		super(AccountTypeEntity.class);
	}

	public AccountTypeEntity getByType(String accountType) {
		Session session = null;
		AccountTypeEntity entity = null;
		try {
			session = new HibernateUtil().getSession();
			entity = session.byNaturalId(AccountTypeEntity.class).using("type", accountType).load();
		} finally {
			new HibernateUtil().closeSession(session);
		}
		return entity;
	}

}
