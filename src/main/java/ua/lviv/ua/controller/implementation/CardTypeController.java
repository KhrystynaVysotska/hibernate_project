package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.CardTypeEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.CardTypeService;

public class CardTypeController extends AbstractController<CardTypeEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private CardTypeService cardTypeService = new CardTypeService();

	@Override
	protected Service<CardTypeEntity> getService() {
		return cardTypeService;
	}

	@Override
	public void create() {
		CardTypeEntity cardTypeEntity = generateEntity();
		if (cardTypeEntity != null) {
			cardTypeService.create(cardTypeEntity);
			if (cardTypeEntity.getId() != null) {
				System.out.println("Your have just created:\n" + cardTypeEntity.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public CardTypeEntity generateEntity() {
		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		try {
			System.out.println("Enter type of card: ");
			String cardName = input.nextLine();
			cardTypeEntity.setName(cardName);
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return cardTypeEntity;
	}

	public CardTypeEntity getByType() {
		System.out.println("Enter card type: ");
		String cardName = input.nextLine();
		return cardTypeService.getByField("name", cardName);
	}
}
