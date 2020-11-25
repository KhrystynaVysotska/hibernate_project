package ua.lviv.ua.view;

import ua.lviv.ua.controller.AbstractController;

@FunctionalInterface
public interface Printable {
	void print(@SuppressWarnings("rawtypes") AbstractController controller);
}
