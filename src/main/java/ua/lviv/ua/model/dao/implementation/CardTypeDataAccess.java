package ua.lviv.ua.model.dao.implementation;

import ua.lviv.ua.model.dao.AbstractDataAccess;
import ua.lviv.ua.model.entity.CardTypeEntity;

public class CardTypeDataAccess extends AbstractDataAccess<CardTypeEntity> {

	public CardTypeDataAccess() {
		super(CardTypeEntity.class);
	}
}
