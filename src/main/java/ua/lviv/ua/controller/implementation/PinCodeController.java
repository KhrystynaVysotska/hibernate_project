package ua.lviv.ua.controller.implementation;

import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.PinCodeEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.PinCodeService;

public class PinCodeController extends AbstractController<PinCodeEntity> {
	private PinCodeService pinCodeService = new PinCodeService();

	@Override
	protected Service<PinCodeEntity> getService() {
		return pinCodeService;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

}
