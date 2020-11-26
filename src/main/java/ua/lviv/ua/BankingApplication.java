package ua.lviv.ua;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.lviv.ua.view.ConsoleMenu;

public class BankingApplication {
	public static void main(String[] args) {
		Logger log = Logger.getLogger("org.hibernate.SQL");
		log.setLevel(Level.ERROR);
		new ConsoleMenu().showMenu();
	}
}
