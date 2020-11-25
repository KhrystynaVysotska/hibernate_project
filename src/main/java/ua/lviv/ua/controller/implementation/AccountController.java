package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.AccountEntity;
import ua.lviv.ua.model.entity.PinCodeEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.AccountService;
import ua.lviv.ua.model.service.implementation.BankService;
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
		accountService.create(account);
		System.out.println("Your have just created:\n" + "\n" + account + "\n");
	}

	public AccountEntity generateEntity() {
		AccountEntity account = new AccountEntity();
		PinCodeEntity pinCode = new PinCodeEntity();
		Session session = null;
		Transaction transaction = null;
		try {
			System.out.println("Create account number: ");
			String currentAccountNumber = input.nextLine();
			account.setCurrentAccountNumber(currentAccountNumber);

			System.out.println("Create pin code: ");
			String pin = input.nextLine();
			pinCode.setPin(pin);
			account.setPinCodeByPinCodeId(pinCode);

			System.out.println("Enter amount of money to keep (up to 1 million): ");
			int amount = input.nextInt();
			account.setAmount(amount);

			try {
				session = new HibernateUtil().getSession();
				transaction = session.beginTransaction();

				account.setAccountOwnerByAccountOwnerId(new AccountOwnerController().findByEmail());

				System.out.println("Enter bank identification code (up to 9 digits): ");
				int bankIdentificationCode = input.nextInt();
				account.setBankByBankIdentificationCode(new BankService().getById(bankIdentificationCode));

				account.setCurrencyByCurrencyId(new CurrencyController().getByName());

				account.setAccountTypeByAccountTypeId(new AccountTypeController().getByType());

				transaction.commit();
			} catch (Exception exeption) {
				transaction.rollback();
			} finally {
				new HibernateUtil().closeSession(session);
			}
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
		}
		return account;
	}
}
