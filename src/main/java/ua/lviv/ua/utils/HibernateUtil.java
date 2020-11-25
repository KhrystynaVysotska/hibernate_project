package ua.lviv.ua.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import ua.lviv.ua.model.entity.AccountEntity;
import ua.lviv.ua.model.entity.AccountOwnerEntity;
import ua.lviv.ua.model.entity.AccountTypeEntity;
import ua.lviv.ua.model.entity.AdressEntity;
import ua.lviv.ua.model.entity.BankCardEntity;
import ua.lviv.ua.model.entity.BankEntity;
import ua.lviv.ua.model.entity.BuildingEntity;
import ua.lviv.ua.model.entity.CardTypeEntity;
import ua.lviv.ua.model.entity.CityEntity;
import ua.lviv.ua.model.entity.CurrencyEntity;
import ua.lviv.ua.model.entity.PinCodeEntity;
import ua.lviv.ua.model.entity.StreetEntity;
import ua.lviv.ua.model.entity.TransferEntity;

public class HibernateUtil {
	private SessionFactory sessionFactory = null;

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
				configuration.addAnnotatedClass(AccountEntity.class);
				configuration.addAnnotatedClass(AccountOwnerEntity.class);
				configuration.addAnnotatedClass(AccountTypeEntity.class);
				configuration.addAnnotatedClass(AdressEntity.class);
				configuration.addAnnotatedClass(BankCardEntity.class);
				configuration.addAnnotatedClass(BankEntity.class);
				configuration.addAnnotatedClass(BuildingEntity.class);
				configuration.addAnnotatedClass(CardTypeEntity.class);
				configuration.addAnnotatedClass(CityEntity.class);
				configuration.addAnnotatedClass(CurrencyEntity.class);
				configuration.addAnnotatedClass(PinCodeEntity.class);
				configuration.addAnnotatedClass(StreetEntity.class);
				configuration.addAnnotatedClass(TransferEntity.class);
				builder.applySettings(configuration.getProperties());
				sessionFactory = configuration.buildSessionFactory(builder.build());
			} catch (Exception exeption) {
				System.err.println("Initial SessionFactory creation failed" + exeption.getMessage());
				throw new ExceptionInInitializerError(exeption);
			}
		}
		return sessionFactory;
	}

	public Session getSession() {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
		} catch (HibernateException | ExceptionInInitializerError exception) {
			System.err.println("Couldn't open session " + exception.getMessage());
		}
		return session;
	}

	public void closeSession(Session session) {
		try {
			if (session != null) {
				session.close();
			}
		} catch (HibernateException exception) {
			System.err.println("Couldn't close session " + exception.getMessage());
		}
	}
}
