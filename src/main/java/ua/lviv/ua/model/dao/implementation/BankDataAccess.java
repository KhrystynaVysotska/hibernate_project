package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.BankEntity;

public class BankDataAccess extends AbstractDataAccess<BankEntity> {

	public BankDataAccess() {
		super(BankEntity.class);
	}

}
