package ua.lviv.ua.model.dao;

import java.util.List;

public interface DataAccess<T> {
	List<T> getAll();

	T getById(Integer id);

	T create(T entity);
}
