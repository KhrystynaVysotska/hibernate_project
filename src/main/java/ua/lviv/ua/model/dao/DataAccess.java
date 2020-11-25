package ua.lviv.ua.model.dao;

import java.util.List;

public interface DataAccess<T> {
	List<T> getAll();

	T getById(Integer id);

	T create(T entity);

	T getByField(String fieldName, Object value);

	T update(T entity);

	boolean deleteById(Integer id);
}
