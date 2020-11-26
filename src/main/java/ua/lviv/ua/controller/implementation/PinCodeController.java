package ua.lviv.ua.controller.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.PinCodeEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.PinCodeService;

public class PinCodeController extends AbstractController<PinCodeEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private PinCodeService pinCodeService = new PinCodeService();

	@Override
	protected Service<PinCodeEntity> getService() {
		return pinCodeService;
	}

	@Override
	public void create() {
		PinCodeEntity pinCode = generateEntity();
		if (pinCode != null) {
			pinCodeService.create(pinCode);
			if (pinCode.getId() != null) {
				System.out.println("Your have just created:\n" + pinCode.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public PinCodeEntity generateEntity() {
		PinCodeEntity pinCode = new PinCodeEntity();
		try {
			System.out.println("Create pin code: ");
			String pin = input.next();
			pinCode.setPin(pin);
		} catch (InputMismatchException e) {
			System.out.println("Your input is not valid! Please, follow constraints!\n");
			input.next();
			return null;
		}
		return pinCode;
	}
}
