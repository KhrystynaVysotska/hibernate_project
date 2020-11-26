package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.BankEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.BankService;

public class BankController extends AbstractController<BankEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private BankService bankService = new BankService();

	@Override
	protected Service<BankEntity> getService() {
		return bankService;
	}

	@Override
	public void create() {
		BankEntity bank = generateEntity();
		if (bank != null) {
			bankService.create(bank);
			System.out.println("Your have just created:\n" + bank.toString());
		}
	}

	public BankEntity generateEntity() {
		BankEntity bank = new BankEntity();
		try {
			System.out.println("Enter identification code(up to 10 digits): ");
			Integer identificationCode = input.nextInt();
			bank.setIdentificationCode(identificationCode);

			System.out.println("Enter state registration code(up to 10 digits): ");
			Integer stateRegistrationCode = input.nextInt();
			input.nextLine();
			bank.setStateRegistrationCode(stateRegistrationCode);

			System.out.println("Enter full bank name: ");
			String fullBankName = input.nextLine();
			bank.setFullBankName(fullBankName);

			System.out.println("Enter short bank name: ");
			String shortBankName = input.nextLine();
			bank.setShortBankName(shortBankName);

			System.out.println("Enter bank license number(up to 10 digits): ");
			Integer bankLicenseNumber = input.nextInt();
			input.nextLine();
			bank.setBankLicenseNumber(bankLicenseNumber);

			System.out.println("Enter bank license date in yyyy-mm-dd format: ");
			String bankLicenseDate = input.nextLine();
			while (!bankLicenseDate.matches("[\\d]{4}([-][\\d]{2}){2}")) {
				System.out.println("Wrong format! Please, input date in format yyyy-mm-dd");
				bankLicenseDate = input.nextLine();
			}
			try {
				bank.setBankLicenseDate(java.sql.Date.valueOf(bankLicenseDate));
			} catch (IllegalArgumentException e) {
				System.out.println("Your date is incorrect! Check and try again!\n");
				return null;
			}
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return bank;
	}
}
