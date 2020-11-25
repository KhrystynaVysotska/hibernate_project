package ua.lviv.ua.model.dao.implementation;

import org.hibernate.Session;
import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.AccountOwnerEntity;
import ua.lviv.ua.utils.HibernateUtil;

public class AccountOwnerDataAccess extends AbstractDataAccess<AccountOwnerEntity> {

	public AccountOwnerDataAccess() {
		super(AccountOwnerEntity.class);
	}

	public AccountOwnerEntity findByEmail(String email) {
		Session session = null;
		AccountOwnerEntity entity = null;
		try {
			session = new HibernateUtil().getSession();
			entity = session.byNaturalId(AccountOwnerEntity.class).using("email", email).load();
		} catch (ExceptionInInitializerError exception) {
			System.err.println("Couldn't open session " + exception.getMessage());
		} finally {
			new HibernateUtil().closeSession(session);
		}
		return entity;
	}
}
