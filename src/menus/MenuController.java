package src.menus;

import java.util.Scanner;

public class MenuController {
	
	private Menu menu;
	private Scanner keyboard;
	private static MenuController instance;
	
	
	
	private MenuController() {
		this.keyboard = new Scanner(System.in);
	}

	public static MenuController getInstance() {
		if (instance == null) {
			instance = new MenuController();
		}
		return instance;
	}
	
	
	public void startMenus() {
		menu = new MenuPrincipal();
		String opcion;
		
		
		System.out.println(menu.toString());
		opcion = this.keyboard.nextLine();
		menu = menu.eligeOpcion(opcion);
		
		System.out.println(menu.toString());
		opcion = this.keyboard.nextLine();
		menu = menu.eligeOpcion(opcion);
		
	}
	public void navegarMenu() {
		String opcion;
		System.out.println(menu.toString());
		opcion = this.keyboard.nextLine();
		menu = menu.eligeOpcion(opcion);
	}
	
	
	
	
	
}
