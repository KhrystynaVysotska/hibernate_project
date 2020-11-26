package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;

import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.AccountTypeEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.AccountTypeService;

public class AccountTypeController extends AbstractController<AccountTypeEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private AccountTypeService accountTypeService = new AccountTypeService();

	@Override
	protected Service<AccountTypeEntity> getService() {
		return accountTypeService;
	}

	@Override
	public void create() {
		AccountTypeEntity accountType = generateEntity();
		if (accountType != null) {
			accountTypeService.create(accountType);
			if (accountType.getId() != null) {
				System.out.println("Your have just created:\n" + accountType.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public AccountTypeEntity generateEntity() {
		AccountTypeEntity accountType = new AccountTypeEntity();
		try {
			System.out.println("Enter type: ");
			String type = input.nextLine();
			accountType.setType(type);
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return accountType;
	}

	public AccountTypeEntity getByType() {
		System.out.println("Enter account type: ");
		String accountType = input.nextLine();
		return accountTypeService.getByField("type", accountType);
	}
}
