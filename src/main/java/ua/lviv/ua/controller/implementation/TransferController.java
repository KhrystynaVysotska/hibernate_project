package ua.lviv.ua.controller.implementation;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.AccountEntity;
import ua.lviv.ua.model.entity.CurrencyEntity;
import ua.lviv.ua.model.entity.TransferEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.TransferService;
import ua.lviv.ua.utils.HibernateUtil;

public class TransferController extends AbstractController<TransferEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private TransferService transferService = new TransferService();

	@Override
	protected Service<TransferEntity> getService() {
		return transferService;
	}

	@Override
	public void create() {
		TransferEntity transfer = generateEntity();
		if (transfer != null) {
			transferService.makeTransaction(transfer);
			if (transfer.getId() != null) {
				System.out.println("Your have just made a transaction:\n" + transfer.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public TransferEntity generateEntity() {
		TransferEntity transfer = new TransferEntity();
		AccountEntity sender = null;
		AccountEntity recipient = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = new HibernateUtil().getSession();
			transaction = session.beginTransaction();

			sender = new AccountController().getByAccountNumber("Enter sender account number: ");
			if (sender == null) {
				throw new Exception("[ERROR] sender undefined! Check your input and try again");
			}
			transfer.setAccountBySenderAccountId(sender);

			recipient = new AccountController().getByAccountNumber("Enter recipient account number: ");
			if (recipient == null) {
				throw new Exception("[ERROR] recipient undefined! Check your input and try again");
			}
			transfer.setAccountByRecipientAccountId(recipient);

			System.out.println("Enter amount of money to send (up to 1 million): ");
			int amount = input.nextInt();
			input.nextLine();
			transfer.setAmount(amount);

			CurrencyEntity currency = new CurrencyController().getByName();
			if (currency == null) {
				throw new Exception("[ERROR] currency undefined! Check your input and try again");
			}
			transfer.setCurrencyByCurrencyId(currency);

			System.out.println("Enter purpose of payment: ");
			String purposeOfPayment = input.nextLine();
			transfer.setPurposeOfPayment(purposeOfPayment);

			Date date = new Date(new java.util.Date().getTime());
			transfer.setDate(date);
			Time time = Time.valueOf(LocalTime.now());
			transfer.setTime(time);

			transaction.commit();
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			new HibernateUtil().closeSession(session);
		}
		return transfer;
	}
}
