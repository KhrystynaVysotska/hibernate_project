package ua.lviv.ua.model.service;

import java.util.List;

import ua.lviv.ua.model.dao.DataAccess;

public abstract class AbstractService<T> implements Service<T> {

	protected abstract DataAccess<T> getDao();

	@Override
	public List<T> getAll() {
		return getDao().getAll();
	}

	@Override
	public T getById(Integer id) {
		return getDao().getById(id);
	}

	@Override
	public T create(T entity) {
		return getDao().create(entity);
	}

	@Override
	public T getByField(String fieldName, Object value) {
		return getDao().getByField(fieldName, value);
	}

	@Override
	public T update(T entity) {
		return getDao().update(entity);
	}

	@Override
	public boolean deleteById(Integer id) {
		if (getById(id) != null) {
			return getDao().deleteById(id);
		} else {
			return false;
		}
	}
}
