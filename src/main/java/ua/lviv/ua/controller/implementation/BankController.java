package ua.lviv.ua.controller.implementation;

import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.BankEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.BankService;

public class BankController extends AbstractController<BankEntity> {
	private BankService bankService = new BankService();

	@Override
	protected Service<BankEntity> getService() {
		return bankService;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

}
