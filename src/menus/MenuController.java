package src.menus;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import src.models.comun.DbObject;

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
	public void callMenus() {
		menu = new MenuPrincipal();
		while(menu!=null) {
			navegarMenu();
		}
		keyboard.close();
		System.out.println("ByeBye");		
	}
	
	

	public void navegarMenu() {
		String opcion;
		System.out.println(menu.toString());
		opcion = this.keyboard.nextLine();
		menu = menu.siguienteMenu(opcion);
	}
	public  DbObject seleccionarObjeto(DbObject obj) {
		
		int id=-1;
		List<DbObject> tabla =obj.list();
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}
		
		for(DbObject dbo: tabla ) {	
			System.out.println(dbo.getId()+" "+dbo.toString());
		}
		System.out.println("Introduzca la ID del objeto de "+obj.getTable()+ " que quiera seleccionar ");
		try {
			id = Integer.parseInt(this.keyboard.nextLine());
		}catch(Exception ex){
			System.out.println("Id no válida");
		}
		DbObject pedido = obj.getByid(id);
		
		return pedido; 
	}
	public static String campoValido(String regex) {		
		String datos;
		Scanner keyboard = new Scanner(System.in);			
		datos = keyboard.nextLine();		
		
		while (!validarCampo(regex, datos)) {		
				System.out.println("El valor introducido para el campo no es válido");
				datos = keyboard.nextLine();										
		}
		keyboard.close();
		return datos;
	}
	
	private static boolean validarCampo(String regex, String datos){				
		return Pattern.matches(regex, datos);
	}
	
	
	
	
	
}
