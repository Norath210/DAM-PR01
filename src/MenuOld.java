package src;

import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Factura;
import src.models.Producto;
import src.models.comun.DbController;
import src.models.comun.DbObject;
import sun.awt.AWTAccessor.MenuAccessor;

public class MenuOld {
	private static final String SALIR = "0";

	
	private static Scanner keyboardScanner = new Scanner(System.in);
	
	private static DbObject modelo;
	
	private static MenuOld instance;

	private MenuOld() {
	}

	public static MenuOld getInstance() {
		if (instance == null) {
			instance = new MenuOld();
		}
		return instance;
	}
		
	public static void menuPrincipal() {
		String opcion = "";
		while (!opcion.equals(SALIR)) {
			System.out.println("¿Qué tabla quiere manejar?");
			System.out.println("1.Categoría");
			System.out.println("2.Clientes");
			System.out.println("3.Factura");
			System.out.println("4.Producto");
			
			System.out.println("0.Salir");		
			
			opcion = keyboardScanner.nextLine();
			switch (opcion) {
			case "1":
				 modelo = new Categoria();
				break;
			case "2":
				modelo = new Clientes(); 
				break;
			case "3": 
				modelo = new Factura();
				break;
			case "4": 
				modelo = new Producto();
				break;
			case SALIR:
				System.out.println("ByeBye");				
				keyboardScanner.close();
				return;
			default:
				System.out.println("Opción no válida");
				break;
			}
			menuAccion(modelo);	
		}
		
	}
	private static void menuAccion(DbObject modelo) {
		
		if(modelo == null) {
			return;
		}
		
		String opcion = "";
		
		while (!opcion.equals(SALIR)) {
			System.out.println("¿Que quieres hacer con "+modelo.getTable()+"");
			System.out.println("1.Ver");
			System.out.println("2.Crear");
			System.out.println("3.Borrar");
			System.out.println("4.Editar");
			
			System.out.println("0.Salir");	
			
			opcion = keyboardScanner.nextLine();
			switch (opcion) {
			case "1":
				modelo.verTodos();
				modelo = modelo.seleccionarObjeto();
				break;
			case "2":
				modelo.save();
				break;
			case "3": 
				modelo = modelo.seleccionarObjeto();				
				modelo.delete();
				break;
			case "4": 
				modelo = modelo.seleccionarObjeto();
				break;
			case SALIR:
				System.out.println("ByeBye");				
				keyboardScanner.close();
				return;
			default:
				System.out.println("Opción no válida");
				break;
			}
		}		
	}

//
//
//	private static void borrar() {
//		String opcion = "";
//		System.out.println("¿Tipo de dato a borrar?");
//		mostrarTablas();
//		opcion = keyboardScanner.nextLine();
//		switch (opcion) {
//		case "1":
//			System.out.println("Elija el cliente a borrar");
//			seleccionarObjeto(new Clientes()).delete();;
//			break;
//		case "2":
//			seleccionarObjeto(new Categoria()).delete();
//			break;
//		case "3":
//			seleccionarObjeto(new Factura()).delete();
//			while(opcion.toLowerCase().equals("n")||opcion.toLowerCase().equals("s")) {
//				System.out.println("Desea borrar las líneas de ésta factura? [S]/[N]");
//				opcion = keyboardScanner.nextLine().
//			}
//			break;
//		case "4": 
//			seleccionarObjeto(new Producto()).delete();
//			break;
//		case SALIR:
//			System.out.println("ByeBye");
//			break;
//		default:
//			System.out.println("Opción no válida");
//			break;
//			}
//		
//	}
//	
//	private static void crear() {
//		String opcion = "";
//		String datos;
//		mostrarTablas();
//		opcion = keyboardScanner.nextLine();
//		switch (opcion) {
//		case "1":
//			datos = rellenarDatos(new Clientes());
//			Clientes.createByValues(datos).save();
//			break;
//		case "2":
//			datos = rellenarDatos(new Categoria());
//			Categoria.createByValues(datos).save();
//			break;
//		case "3":
//			datos = rellenarDatos(new Factura());
//			Factura.createByValues(datos).save();
//			break;
//		case "4":
//			datos = rellenarDatos(new Producto());
//			Producto.createByValues(datos).save();
//			break;
//			
//		case SALIR:
//			System.out.println("ByeBye");
//			break;
//		default:
//			System.out.println("Opción no válida");
//			break;
//		}
//	}
//
//	
//	private static void actualizar() {
//		String opcion = "";	
//		System.out.println("¿Qué tabla desea actualizar?");
//		mostrarTablas();
//		
//		switch (opcion) {
//		case "1":
//			System.out.println("Elija el cliente a actualizar");
//			seleccionarObjeto(new Clientes());
//			break;
//		case "2":
//			seleccionarObjeto(new Categoria());
//			break;
//		case "3":
//			seleccionarObjeto(new Factura());
//			break;
//		case "4": 
//			seleccionarObjeto(new Producto());
//			break;
//		case SALIR:
//			System.out.println("ByeBye");
//			break;
//		default:
//			System.out.println("Opción no válida");
//			break;
//			}
//		
//	}
//
//	private static void leer() {
//		System.out.println("¿Sobre qué tabla desea ver?");
//		mostrarTablas();
//		opcion = keyboardScanner.nextLine();
//		switch (opcion) {
//		case "1":
//			System.out.println("Elija el cliente a ver en detalle");
//			seleccionarObjeto();
//			break;
//		case "2":
//			System.out.println("Elija la categoría a ver en detalle");
//			seleccionarObjeto(new Categoria());
//			break;
//		case "3":
//			System.out.println("Elija la factura a ver en detalle");
//			seleccionarObjeto(new Factura());
//			break;
//		case "4": 
//			seleccionarObjeto(new Producto());
//			break;
//		case SALIR:
//			System.out.println("ByeBye");
//			keyboardScanner.close();
//			break;
//		default:
//			System.out.println("Opción no válida");
//			break;
//			}
//		
//	}

	/**
	* @param modelo - Una clase que descienda de DbObject
	* @return - La lista de valores en el orden en el que vengan en getCampos()
	*/
	private static String rellenarDatos(DbObject modelo){
		
		String[] campos = modelo.getAllCampos().split(",");
		String datos = new String();	
		String entrada = new String();
		
		for(String c:campos) {			
				System.out.println("Introduzca el valor que desea para el campo "+c);
				entrada = keyboardScanner.nextLine();
				if (entrada.isEmpty()) {
					entrada="null";
				}
				if (datos.isEmpty()) {
					datos = entrada;
				}else {
					datos= datos +", "+ entrada;
				}				
			}		
		return datos;
	}
	

	

}
