package ua.lviv.ua.controller;

import java.util.List;
import java.util.Scanner;

import ua.lviv.ua.model.service.Service;

public abstract class AbstractController<T> implements Controller<T> {
	private static Scanner input = new Scanner(System.in, "UTF-8");

	protected abstract Service<T> getService();

	@Override
	public void getAll() {
		List<T> entities = getService().getAll();
		if (entities != null) {
			for (T entity : entities) {
				System.out.println(entity);
			}
		} else {
			System.out.println("[ERROR]: Couldn't get list of entities!");
		}
	}

	@Override
	public void getById() {
		System.out.println("Enter id: ");
		int id = input.nextInt();
		T entity = getService().getById(id);
		if (entity != null) {
			System.out.println(entity);
		} else {
			System.out.println("[ERROR]: This entity doesn't exist!");
		}
	}
}
