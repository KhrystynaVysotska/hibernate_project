package ua.lviv.ua.model.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.ua.utils.HibernateUtil;

public abstract class AbstractDataAccess<T> implements DataAccess<T> {
	private Class<T> type;
	private String getAll;

	public AbstractDataAccess(Class<T> type) {
		this.type = type;
		getAll = "FROM " + type.getName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		Session session = new HibernateUtil().getSession();
		List<T> entities = session.createQuery(getAll).list();
		new HibernateUtil().closeSession(session);
		return entities;
	}

	@Override
	public T getById(Integer id) {
		Session session = new HibernateUtil().getSession();
		T entity = session.get(type, id);
		new HibernateUtil().closeSession(session);
		return entity;
	}

	@Override
	public T create(T entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = new HibernateUtil().getSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			new HibernateUtil().closeSession(session);
		}
		return entity;
	}

	@Override
	public T getByField(String fieldName, Object value) {
		Session session = null;
		T entity = null;
		try {
			session = new HibernateUtil().getSession();
			entity = session.byNaturalId(type).using(fieldName, value).load();
		} catch (HibernateException exception) {
			System.err.println("Couldn't map class " + exception.getMessage());
		} finally {
			new HibernateUtil().closeSession(session);
		}
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T update(T entity) {
		Session session = new HibernateUtil().getSession();
		Transaction transaction = session.beginTransaction();
		T updatedEntity = (T) session.merge(entity);
		transaction.commit();
		new HibernateUtil().closeSession(session);
		return updatedEntity;

	}

	public boolean deleteById(Integer id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = new HibernateUtil().getSession();
			transaction = session.beginTransaction();
			T entity = session.load(type, id);
			session.delete(entity);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			return false;
		} finally {
			new HibernateUtil().closeSession(session);
		}
		return true;
	}
}
