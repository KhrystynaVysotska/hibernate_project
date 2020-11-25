package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.CurrencyEntity;

public class CurrencyDataAccess extends AbstractDataAccess<CurrencyEntity> {

	public CurrencyDataAccess() {
		super(CurrencyEntity.class);
	}
}
