package ua.lviv.ua.controller;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ua.lviv.ua.controller.implementation.AccountController;
import ua.lviv.ua.controller.implementation.AccountOwnerController;
import ua.lviv.ua.controller.implementation.AccountTypeController;
import ua.lviv.ua.controller.implementation.AdressController;
import ua.lviv.ua.controller.implementation.BankCardController;
import ua.lviv.ua.controller.implementation.BankController;
import ua.lviv.ua.controller.implementation.BuildingController;
import ua.lviv.ua.controller.implementation.CardTypeController;
import ua.lviv.ua.controller.implementation.CityController;
import ua.lviv.ua.controller.implementation.CurrencyController;
import ua.lviv.ua.controller.implementation.PinCodeController;
import ua.lviv.ua.controller.implementation.StreetController;
import ua.lviv.ua.controller.implementation.TransferController;
import ua.lviv.ua.model.entity.AccountEntity;
import ua.lviv.ua.model.entity.AccountOwnerEntity;
import ua.lviv.ua.model.entity.AccountTypeEntity;
import ua.lviv.ua.model.entity.AdressEntity;
import ua.lviv.ua.model.entity.BankCardEntity;
import ua.lviv.ua.model.entity.BankEntity;
import ua.lviv.ua.model.entity.BuildingEntity;
import ua.lviv.ua.model.entity.CardTypeEntity;
import ua.lviv.ua.model.entity.CityEntity;
import ua.lviv.ua.model.entity.CurrencyEntity;
import ua.lviv.ua.model.entity.PinCodeEntity;
import ua.lviv.ua.model.entity.StreetEntity;
import ua.lviv.ua.model.entity.TransferEntity;
import ua.lviv.ua.model.service.Service;

public abstract class AbstractController<T> implements Controller<T> {
	private static Scanner input = new Scanner(System.in, "UTF-8");

	@SuppressWarnings("rawtypes")
	private static final Map<Class, AbstractController> CUSTOM_JAVA_CLASSES = new HashMap<>();
	static {
		CUSTOM_JAVA_CLASSES.put(AccountEntity.class, new AccountController());
		CUSTOM_JAVA_CLASSES.put(AccountOwnerEntity.class, new AccountOwnerController());
		CUSTOM_JAVA_CLASSES.put(AccountTypeEntity.class, new AccountTypeController());
		CUSTOM_JAVA_CLASSES.put(AdressEntity.class, new AdressController());
		CUSTOM_JAVA_CLASSES.put(BankCardEntity.class, new BankCardController());
		CUSTOM_JAVA_CLASSES.put(BankEntity.class, new BankController());
		CUSTOM_JAVA_CLASSES.put(BuildingEntity.class, new BuildingController());
		CUSTOM_JAVA_CLASSES.put(CardTypeEntity.class, new CardTypeController());
		CUSTOM_JAVA_CLASSES.put(CityEntity.class, new CityController());
		CUSTOM_JAVA_CLASSES.put(CurrencyEntity.class, new CurrencyController());
		CUSTOM_JAVA_CLASSES.put(PinCodeEntity.class, new PinCodeController());
		CUSTOM_JAVA_CLASSES.put(StreetEntity.class, new StreetController());
		CUSTOM_JAVA_CLASSES.put(TransferEntity.class, new TransferController());
	}

	protected abstract Service<T> getService();

	@Override
	public void getAll() {
		List<T> entities = getService().getAll();
		for (T entity : entities) {
			System.out.println(entity);
		}
	}

	@Override
	public T getById() {
		System.out.println("Enter id: ");
		int id = input.nextInt();
		T entity = getService().getById(id);
		if (entity != null) {
			System.out.println(entity);
		} else {
			System.out.println("[ERROR]: This entity doesn't exist!");
		}
		return entity;
	}

	@Override
	public void deleteById() {
		System.out.println("Enter id of object to delete: ");
		int id = input.nextInt();
		boolean deleted = getService().deleteById(id);
		if (deleted) {
			System.out.println("Deleted successfully!");
		} else {
			System.out.println("[ERROR]: This entity doesn't exist!");
		}
	}

	@Override
	public void update() {
		T entity = getById();
		if (entity != null) {
			if (update(entity)) {
				System.out.println("You have just updated: \n" + getService().update(entity));
			} else {
				System.out.println("[ERROR] Couldn't be updated!!!");
			}
		}
	}

	protected boolean update(Object entity) {
		Field field = getFieldToUpdate(entity);
		String name = field.getName();
		if (!name.equals("id") && !name.equals("identificationCode")) {
			try {
				field.setAccessible(true);
				Class<?> type = field.getType();
				if (CUSTOM_JAVA_CLASSES.containsKey(type)) {
					System.out.println("Do you want to replace object or update it? Replace : Update");
					String response = input.next().trim().toLowerCase();
					switch (response) {
					case "replace":
						Object newObject = CUSTOM_JAVA_CLASSES.get(type).getById();
						if (newObject != null) {
							field.set(entity, newObject);
						} else {
							return false;
						}
						break;
					default:
						return update(field.get(entity));
					}
				} else {
					System.out.println("Enter new value for " + name);
					String newValue = input.next();
					if (type == String.class) {
						field.set(entity, newValue);
					} else if (type == Integer.class) {
						field.set(entity, Integer.parseInt(newValue));
					} else if (type == Date.class) {
						while (!newValue.matches("[\\d]{4}([-][\\d]{2}){2}")) {
							System.out.println("Wrong format! Please, input date in format yyyy-mm-dd");
							newValue = input.next();
						}
						try {
							field.set(entity, Date.valueOf(newValue));
						} catch (IllegalArgumentException e) {
							System.out.println("Your date is incorrect! Check and try again!\n");
							return false;
						}

					} else if (type == Long.class) {
						field.set(entity, Long.parseLong(newValue));
					} else if (type == Time.class) {
						field.set(entity, Time.valueOf(newValue));
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
				System.out.println("[ERROR]: Illegal argument or access!");
				return false;
			}
		} else {
			System.out.println("[ERROR]: Cannot mutate primary key!");
			return false;
		}
		return true;
	}

	protected Field getFieldToUpdate(Object entity) {
		Field fieldToUpdate = null;
		try {
			System.out.println("Enter the name of field you'd like to update");
			Field[] fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				System.out.println(field.getName());
			}
			String fieldName = input.next();
			fieldToUpdate = entity.getClass().getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			System.out.println("[ERROR]: Cannot access or find this field!");
		}
		return fieldToUpdate;
	}
}
