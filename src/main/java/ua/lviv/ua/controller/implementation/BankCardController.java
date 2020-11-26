package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.AccountEntity;
import ua.lviv.ua.model.entity.BankCardEntity;
import ua.lviv.ua.model.entity.CardTypeEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.BankCardService;
import ua.lviv.ua.utils.HibernateUtil;

public class BankCardController extends AbstractController<BankCardEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private BankCardService bankCardService = new BankCardService();

	@Override
	protected Service<BankCardEntity> getService() {
		return bankCardService;
	}

	@Override
	public void create() {
		BankCardEntity bankCard = generateEntity();
		if (bankCard != null) {
			bankCardService.create(bankCard);
			if (bankCard.getId() != null) {
				System.out.println("Your have just created:\n" + bankCard.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public BankCardEntity generateEntity() {
		BankCardEntity bankCard = new BankCardEntity();
		AccountEntity account = new AccountEntity();
		CardTypeEntity cardType = new CardTypeEntity();
		Session session = null;
		Transaction transaction = null;
		try {
			System.out.println("Enter cvc2 of your bank card: ");
			Integer cvc2 = input.nextInt();
			bankCard.setCvc2(cvc2);

			System.out.println("Enter date of your card's expiration in yyyy-mm-dd format: ");
			String dateOfExpire = input.next();
			while (!dateOfExpire.matches("[\\d]{4}([-][\\d]{2}){2}")) {
				System.out.println("Wrong format! Please, input date in format yyyy-mm-dd");
				dateOfExpire = input.next();
			}
			try {
				bankCard.setDateOfExpire(java.sql.Date.valueOf(dateOfExpire));
			} catch (IllegalArgumentException e) {
				System.out.println("Your date is incorrect! Check and try again!\n");
				return null;
			}
			try {
				session = new HibernateUtil().getSession();
				transaction = session.beginTransaction();

				System.out.println("Do you want to create new account or use existing one? Create : Existing");
				String response = input.next().trim().toLowerCase();
				account = response.equals("create") ? new AccountController().generateEntity()
						: new AccountController().getById();
				if (account == null) {
					throw new Exception("[ERROR] account undefined! Check your input and try again");
				}
				bankCard.setAccountByAccountId(account);

				System.out.println("Do you want to create new card type or use existing one? Create : Existing");
				response = input.next().trim().toLowerCase();
				cardType = response.equals("create") ? new CardTypeController().generateEntity()
						: new CardTypeController().getByType();
				if (cardType == null) {
					throw new Exception("[ERROR] card type undefined! Check your input and try again");
				}
				bankCard.setCardTypeByCardTypeId(cardType);

				transaction.commit();
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
				transaction.rollback();
				return null;
			} finally {
				new HibernateUtil().closeSession(session);
			}
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return bankCard;
	}
}
