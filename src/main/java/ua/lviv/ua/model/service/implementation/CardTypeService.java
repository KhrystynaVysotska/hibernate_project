package ua.lviv.ua.model.service.implementation;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.CardTypeDataAccess;
import ua.lviv.ua.model.entity.CardTypeEntity;
import ua.lviv.ua.model.service.AbstractService;

public class CardTypeService extends AbstractService<CardTypeEntity> {

	@Override
	protected DataAccess<CardTypeEntity> getDao() {
		return new CardTypeDataAccess();
	}

}
