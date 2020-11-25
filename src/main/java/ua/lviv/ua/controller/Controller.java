package ua.lviv.ua.controller;

public interface Controller<T> {
	void getAll();

	T getById();

	void create();

	void update();

	void deleteById();
}
