package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.CityEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.CityService;

public class CityController extends AbstractController<CityEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private CityService cityService = new CityService();

	@Override
	protected Service<CityEntity> getService() {
		return cityService;
	}

	@Override
	public void create() {
		CityEntity city = generateEntity();
		if (city != null) {
			cityService.create(city);
			if (city.getId() != null) {
				System.out.println("Your have just created:\n" + city.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public CityEntity generateEntity() {
		CityEntity city = new CityEntity();
		try {
			System.out.println("Enter city: ");
			String cityName = input.next();
			city.setName(cityName);

			System.out.println("Enter zip code of your city: ");
			Integer zipCode = input.nextInt();
			city.setZipCode(zipCode);

			System.out.println("Enter phone code of your city: ");
			String phoneCode = input.next();
			city.setPhoneCode(phoneCode);
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return city;
	}

	public CityEntity getByName() {
		System.out.println("Enter city name: ");
		String cityName = input.next();
		return cityService.getByField("name", cityName);
	}
}
