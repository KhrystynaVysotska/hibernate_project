package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.BuildingEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.BuildingService;

public class BuildingController extends AbstractController<BuildingEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private BuildingService buildingService = new BuildingService();

	@Override
	protected Service<BuildingEntity> getService() {
		return buildingService;
	}

	@Override
	public void create() {
		BuildingEntity building = generateEntity();
		if (building != null) {
			buildingService.create(building);
			if (building.getId() != null) {
				System.out.println("Your have just created:\n" + building.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public BuildingEntity generateEntity() {
		BuildingEntity building = new BuildingEntity();
		try {
			System.out.println("Enter your house number: ");
			String houseNumber = input.next();
			building.setHouseNumber(houseNumber);

			System.out.println("Enter your flat number: ");
			String flatNumber = input.next();
			building.setFlatNumber(flatNumber);
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return building;
	}
}
