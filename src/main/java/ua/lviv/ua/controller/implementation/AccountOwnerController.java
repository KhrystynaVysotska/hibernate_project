package ua.lviv.ua.controller.implementation;

import java.util.Scanner;

import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.AccountOwnerEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.AccountOwnerService;

public class AccountOwnerController extends AbstractController<AccountOwnerEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private AccountOwnerService accountOwnerService = new AccountOwnerService();

	@Override
	protected Service<AccountOwnerEntity> getService() {
		return accountOwnerService;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
	}

	public AccountOwnerEntity findByEmail() {
		System.out.println("Enter owner email: ");
		String accountOwnerEmail = input.nextLine();
		while (!accountOwnerEmail.matches("^[\\w-\\.]+@[\\w]+[\\.][\\w-]{2,4}$")) {
			System.out.println("Wrong format! Please, input correct email");
			accountOwnerEmail = input.nextLine();
		}
		return accountOwnerService.findByEmail(accountOwnerEmail);
	}
}
