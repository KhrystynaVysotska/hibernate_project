package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.BankCardEntity;

public class BankCardDataAccess extends AbstractDataAccess<BankCardEntity> {

	public BankCardDataAccess() {
		super(BankCardEntity.class);
	}

}
