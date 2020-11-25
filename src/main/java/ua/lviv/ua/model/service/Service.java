package ua.lviv.ua.model.service;

import java.util.List;

public interface Service<T> {
	List<T> getAll();

	T getById(Integer id);

	T create(T entity);
}
