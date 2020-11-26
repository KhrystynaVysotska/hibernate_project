package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.AccountOwnerEntity;
import ua.lviv.ua.model.entity.AdressEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.AccountOwnerService;
import ua.lviv.ua.utils.HibernateUtil;

public class AccountOwnerController extends AbstractController<AccountOwnerEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private AccountOwnerService accountOwnerService = new AccountOwnerService();

	@Override
	protected Service<AccountOwnerEntity> getService() {
		return accountOwnerService;
	}

	@Override
	public void create() {
		AccountOwnerEntity accountOwner = generateEntity();
		if (accountOwner != null) {
			accountOwnerService.create(accountOwner);
			if (accountOwner.getId() != null) {
				System.out.println("You have just created:\n" + accountOwner.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public AccountOwnerEntity findByEmail() {
		System.out.println("Enter owner email: ");
		String accountOwnerEmail = input.next();
		while (!accountOwnerEmail.matches("^[\\w-\\.]+@[\\w]+[\\.][\\w-]{2,4}$")) {
			System.out.println("Wrong format! Please, input correct email");
			accountOwnerEmail = input.next();
		}
		return accountOwnerService.getByField("email", accountOwnerEmail);
	}

	public AccountOwnerEntity generateEntity() {
		AccountOwnerEntity accountOwner = new AccountOwnerEntity();
		AdressEntity address = null;
		Session session = null;
		Transaction transaction = null;
		try {
			System.out.println("Enter personal identification number(up to 10 digits): ");
			String personalIdentificationNumber = input.next();
			accountOwner.setPersonalIdentificationNumber(personalIdentificationNumber);

			System.out.println("Enter your name (up to 45 letters): ");
			String name = input.next();
			accountOwner.setName(name);

			System.out.println("Enter your surname (up to 45 letters): ");
			String surname = input.next();
			accountOwner.setSurname(surname);

			System.out.println("Enter your patronym (up to 45 letters): ");
			String patronym = input.next();
			accountOwner.setPatronym(patronym);

			System.out.println("Enter owner's mobile number (up to 13 digits): ");
			String mobileNumber = input.next();
			accountOwner.setMobileNumber(mobileNumber);

			System.out.println("Enter owner's email (up to 45 symbols): ");
			String email = input.next();
			while (!email.matches("^[\\w-\\.]+@[\\w]+[\\.][\\w-]{2,4}$")) {
				System.out.println("Wrong format! Please, input correct email");
				email = input.next();
			}
			accountOwner.setEmail(email);

			System.out.println("Enter owner's birth date in yyyy-mm-dd format: ");
			String birthDate = input.next();
			while (!birthDate.matches("[\\d]{4}([-][\\d]{2}){2}")) {
				System.out.println("Wrong format! Please, input date in format yyyy-mm-dd");
				birthDate = input.next();
			}
			try {
				accountOwner.setBirthDate(java.sql.Date.valueOf(birthDate));
			} catch (IllegalArgumentException e) {
				System.out.println("Your date is incorrect! Check and try again!\n");
				return null;
			}

			try {
				session = new HibernateUtil().getSession();
				transaction = session.beginTransaction();

				System.out.println("Do you want to create new address or add existing one? Create : Existing");
				String response = input.next().trim().toLowerCase();
				address = response.equals("create") ? new AdressController().generateEntity()
						: new AdressController().getById();
				if (address == null) {
					throw new Exception("[ERROR] address undefined! Check your input and try again");
				}
				accountOwner.setAdressByAdressId(address);

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
		return accountOwner;
	}
}
