package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.CurrencyDataAccess;
import ua.lviv.ua.model.entity.CurrencyEntity;
import ua.lviv.ua.model.service.AbstractService;

public class CurrencyService extends AbstractService<CurrencyEntity> {
	private CurrencyDataAccess currencyDataAccess = new CurrencyDataAccess();

	@Override
	protected DataAccess<CurrencyEntity> getDao() {
		return currencyDataAccess;
	}
}
