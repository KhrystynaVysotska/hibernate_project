package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.AccountEntity;
import ua.lviv.ua.model.entity.AccountOwnerEntity;
import ua.lviv.ua.model.entity.AccountTypeEntity;
import ua.lviv.ua.model.entity.BankEntity;
import ua.lviv.ua.model.entity.CurrencyEntity;
import ua.lviv.ua.model.entity.PinCodeEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.AccountService;
import ua.lviv.ua.utils.HibernateUtil;

public class AccountController extends AbstractController<AccountEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private AccountService accountService = new AccountService();

	@Override
	protected Service<AccountEntity> getService() {
		return accountService;
	}

	@Override
	public void create() {
		AccountEntity account = generateEntity();
		if (account != null) {
			accountService.create(account);
			if (account.getId() != null) {
				System.out.println("Your have just created:\n" + account.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public AccountEntity generateEntity() {
		AccountEntity account = new AccountEntity();
		PinCodeEntity pinCode = null;
		Session session = null;
		Transaction transaction = null;
		try {
			System.out.println("Create account number: ");
			String currentAccountNumber = input.next();
			account.setCurrentAccountNumber(currentAccountNumber);

			System.out.println("Enter amount of money to keep (up to 1 million): ");
			int amount = input.nextInt();
			account.setAmount(amount);

			try {
				session = new HibernateUtil().getSession();
				transaction = session.beginTransaction();

				pinCode = new PinCodeController().generateEntity();
				account.setPinCodeByPinCodeId(pinCode);

				AccountOwnerEntity accountOwner = null;
				System.out.println(
						"Do you want to create new account owner or sign in with existing one? Create : Existing");
				String response = input.next().trim().toLowerCase();
				accountOwner = response.equals("create") ? new AccountOwnerController().generateEntity()
						: new AccountOwnerController().findByEmail();
				if (accountOwner == null) {
					throw new Exception("[ERROR] account owner undefined! Check your email and try again");
				}
				account.setAccountOwnerByAccountOwnerId(accountOwner);

				BankEntity bank = null;
				System.out.println("Do you want to create new bank or use existing one? Create : Existing");
				response = input.next().trim().toLowerCase();
				bank = response.equals("create") ? new BankController().generateEntity()
						: new BankController().getById();
				if (bank == null) {
					throw new Exception("[ERROR] bank undefined! Check your input and try again");
				}
				account.setBankByBankIdentificationCode(bank);

				CurrencyEntity currency = new CurrencyController().getByName();
				if (currency == null) {
					throw new Exception("[ERROR] currency undefined! Check your input and try again");
				}
				account.setCurrencyByCurrencyId(currency);

				AccountTypeEntity accountType = new AccountTypeController().getByType();
				if (accountType == null) {
					throw new Exception("[ERROR] account type undefined! Check your input and try again");
				}
				account.setAccountTypeByAccountTypeId(accountType);

				transaction.commit();
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
				if (transaction != null) {
					transaction.rollback();
				}
				return null;
			} finally {
				new HibernateUtil().closeSession(session);
			}
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return account;
	}

	public AccountEntity getByAccountNumber(String message) {
		System.out.println(message);
		String currentAccountNumber = input.next();
		return accountService.getByField("currentAccountNumber", currentAccountNumber);
	}
}
