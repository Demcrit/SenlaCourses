package restaurant;

import cook.*;
import menu.*;

public class Restaurant {

	private static Menu menu = new Menu();
	private static Drink coffee = new Drink(EDrinks.COFFEE, 7);
	private static MainDish pizza = new MainDish(EMainDishes.PIZZA, 25);
	
	private static CookManager cookManager = new CookManager();
	private static Cook sergCook = new Cook("Serg");
	private static Cook alexCook = new Cook("Alex");
	
	private static Table[] tables = new Table[4];

	public static void main(String[] args) {
		System.out.println("Menu:");
		fillingMenu();
		System.out.println("Cooks:");
		workWithCookManager();
		System.out.println("Orders:");
		workWithTablesAndOrders();
		System.out.println("Free cook:");
		workWithCooksAndOrders();
		System.out.println("Orders for tables:");
		printOrders();
		System.out.println("Cooks and orders:");
		cookManager.printCooks();
		System.out.println();
		System.out.println("Print Menu:");
		menu.printMenu();
		

	}

	private static void fillingMenu() {
		menu.addDish(coffee);
		menu.addDish(pizza);
		System.out.println();
	}

	private static void workWithCookManager() {
		cookManager.addCook(sergCook);
		cookManager.addCook(alexCook);
		cookManager.deleteCook(sergCook);
		System.out.println();
	}

	private static void workWithTablesAndOrders() {
		for (int i = 0; i<tables.length; i++)
			tables[i] = new Table(i + 1);
		tables[0].createNewOrder(1, new ADish[] { menu.getDish(coffee), menu.getDish(pizza) });
		tables[1].createNewOrder(2, new ADish[] { menu.getDish(coffee) });
		tables[1].cancelOrder();
		System.out.println();
	}

	private static void workWithCooksAndOrders() {
		cookManager.addOrderToFreeCook(tables[0].getOrder());
		System.out.println();
	}
	private static void printOrders(){
		for (Table t : tables)
			t.printOrder();
		System.out.println();
	}

}
