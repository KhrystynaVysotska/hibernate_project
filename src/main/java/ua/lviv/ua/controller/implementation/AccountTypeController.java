package ua.lviv.ua.controller.implementation;

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

	public AccountTypeEntity getByType() {
		System.out.println("Enter account type: ");
		String accountType = input.nextLine();
		return accountTypeService.getByField("type", accountType);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

}
