package ua.lviv.ua.model.dao.implementation;

import org.hibernate.Session;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.CurrencyEntity;
import ua.lviv.ua.utils.HibernateUtil;

public class CurrencyDataAccess extends AbstractDataAccess<CurrencyEntity> {

	public CurrencyDataAccess() {
		super(CurrencyEntity.class);
	}

	public CurrencyEntity getByName(String currency) {
		Session session = null;
		CurrencyEntity entity = null;
		try {
			session = new HibernateUtil().getSession();
			entity = session.byNaturalId(CurrencyEntity.class).using("name", currency).load();
		} finally {
			new HibernateUtil().closeSession(session);
		}
		return entity;
	}

}
