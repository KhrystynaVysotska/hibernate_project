package ua.lviv.ua.controller.implementation;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.ua.controller.AbstractController;
import ua.lviv.ua.model.entity.AdressEntity;
import ua.lviv.ua.model.entity.BuildingEntity;
import ua.lviv.ua.model.entity.CityEntity;
import ua.lviv.ua.model.entity.StreetEntity;
import ua.lviv.ua.model.service.Service;
import ua.lviv.ua.model.service.implementation.AddressService;
import ua.lviv.ua.utils.HibernateUtil;

public class AdressController extends AbstractController<AdressEntity> {
	private static Scanner input = new Scanner(System.in, "UTF-8");
	private AddressService addressService = new AddressService();

	@Override
	protected Service<AdressEntity> getService() {
		return addressService;
	}

	@Override
	public void create() {
		AdressEntity adress = generateEntity();
		if (adress != null) {
			addressService.create(adress);
			if (adress.getId() != null) {
				System.out.println("Your have just created:\n" + adress.toString());
			} else {
				System.out.println("[WARN] Something went wrong...");
			}
		}
	}

	public AdressEntity generateEntity() {
		AdressEntity addressEntity = new AdressEntity();
		CityEntity city = null;
		StreetEntity street = null;
		BuildingEntity building = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = new HibernateUtil().getSession();
			transaction = session.beginTransaction();

			System.out.println("Do you want to create new city or use existing? Create : Existing");
			String response = input.next().trim().toLowerCase();
			city = response.equals("create") ? new CityController().generateEntity() : new CityController().getByName();
			if (city == null) {
				throw new Exception("[ERROR] city undefined! Check your input and try again");
			}
			addressEntity.setCityByCityId(city);

			System.out.println("Do you want to create new street or use existing? Create : Existing");
			response = input.next().trim().toLowerCase();
			street = response.equals("create") ? new StreetController().generateEntity()
					: new StreetController().getByName();
			if (street == null) {
				throw new Exception("[ERROR] street undefined! Check your input and try again");
			}
			addressEntity.setStreetByStreetId(street);

			System.out.println("Do you want to create new building or use existing? Create : Existing");
			response = input.next().trim().toLowerCase();
			building = response.equals("create") ? new BuildingController().generateEntity()
					: new BuildingController().getById();
			if (building == null) {
				throw new Exception("[ERROR] building undefined! Check your input and try again");
			}
			addressEntity.setBuildingByBuildingId(building);

			transaction.commit();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			new HibernateUtil().closeSession(session);
		}
		return addressEntity;
	}
}
