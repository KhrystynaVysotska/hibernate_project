package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.StreetEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.StreetService;

public class StreetController extends AbstractController<StreetEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private StreetService streetService = new StreetService();

	@Override
	protected Service<StreetEntity> getService() {
		return streetService;
	}

	@Override
	public void create() {
		StreetEntity street = generateEntity();
		if (street != null) {
			streetService.create(street);
			if (street.getId() != null) {
				System.out.println("Your have just created:\n" + street.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public StreetEntity generateEntity() {
		StreetEntity street = new StreetEntity();
		try {
			System.out.println("Enter name of your street: ");
			String streetName = input.nextLine();
			street.setName(streetName);
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return street;
	}

	public StreetEntity getByName() {
		System.out.println("Enter street name: ");
		String streetName = input.next();
		return streetService.getByField("name", streetName);
	}
}
