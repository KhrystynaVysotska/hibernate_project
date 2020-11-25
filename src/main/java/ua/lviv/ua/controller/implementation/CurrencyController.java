package ua.lviv.ua.controller.implementation;

import java.util.Scanner;

import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.CurrencyEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.CurrencyService;

public class CurrencyController extends AbstractController<CurrencyEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	CurrencyService currencyService = new CurrencyService();

	@Override
	protected Service<CurrencyEntity> getService() {
		return currencyService;
	}

	public CurrencyEntity getByName() {
		System.out.println("Enter currency: ");
		String currency = input.next();
		return currencyService.getByField("name", currency);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

}
