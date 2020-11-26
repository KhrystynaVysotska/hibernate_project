package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
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

	@Override
	public void create() {
		CurrencyEntity currency = generateEntity();
		if (currency != null) {
			currencyService.create(currency);
			if (currency.getId() != null) {
				System.out.println("Your have just created:\n" + currency.toString());
			} else {
				System.out.println("[WARN] Something went wrong...Check uniqueness of your fields");
			}
		}
	}

	public CurrencyEntity generateEntity() {
		CurrencyEntity currency = new CurrencyEntity();
		try {
			System.out.println("Enter new currency name: ");
			String currencyName = input.nextLine();
			currency.setName(currencyName);
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return currency;
	}

	public CurrencyEntity getByName() {
		System.out.println("Enter currency: ");
		String currency = input.next();
		return currencyService.getByField("name", currency);
	}
}
