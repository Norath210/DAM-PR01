package src;

import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Factura;
import src.models.Producto;
import src.models.comun.DbController;
import src.models.comun.DbObject;

public class Menu {
	private static final String SALIR = "0";

	static String opcion = "";
	static Scanner keyboardScanner = new Scanner(System.in);
	
	
	
	
	
	public static void menuPrincipal() {
		while (!opcion.equals(SALIR)) {
			System.out.println("Pulse el número de la opcion del menú");
			System.out.println("1.Crear");
			System.out.println("2.Ver");
			System.out.println("3.Actualizar");
			System.out.println("4.Borrar");
			
			System.out.println("0.Salir");		
			
			opcion = keyboardScanner.nextLine();
			switch (opcion) {
			case "1":
				crear();
				break;
			case "2":
				leer();
				break;
			case "3":
				actualizar();
				break;
			case "4":
				borrar();
				break;
			case SALIR:
				System.out.println("ByeBye");
				
				keyboardScanner.close();
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
		}
		
	}
	private static void borrar() {
		System.out.println("Tipo de dato a borrar?");
		mostrarTablas();
		opcion = keyboardScanner.nextLine();
		switch (opcion) {
		case "1":
			System.out.println("Elija el cliente a borrar");
			seleccionarObjeto(new Clientes()).delete();;
			break;
		case "2":
			seleccionarObjeto(new Categoria()).delete();
			break;
		case "3":
			seleccionarObjeto(new Factura()).delete();
			break;
		case "4": 
			seleccionarObjeto(new Producto()).delete();
			break;
		case SALIR:
			System.out.println("ByeBye");
			break;
		default:
			System.out.println("Opción no válida");
			break;
			}
		
	}
	
	private static void crear() {
		String datos;
		mostrarTablas();
		opcion = keyboardScanner.nextLine();
		switch (opcion) {
		case "1":
			datos = rellenarDatos(new Clientes());
			Clientes.createByValues(datos).save();
			break;
		case "2":
			datos = rellenarDatos(new Categoria());
			Categoria.createByValues(datos).save();
			break;
		case "3":
			datos = rellenarDatos(new Factura());
			Factura.createByValues(datos).save();
			break;
		case "4":
			datos = rellenarDatos(new Producto());
			Producto.createByValues(datos).save();
			break;
			
		case SALIR:
			System.out.println("ByeBye");
			break;
		default:
			System.out.println("Opción no válida");
			break;
		}
	}
	private static void mostrarTablas() {		
		System.out.println("1.Clientes");
		System.out.println("2.Categoría");
		System.out.println("3.Facturas");
		System.out.println("4.Productos");
		
		System.out.println("0.Volver");
	}
		
	private static void actualizar() {
		System.out.println("¿Qué tabla desea actualizar?");
		mostrarTablas();
		
		switch (opcion) {
		case "1":
			System.out.println("Elija el cliente a actualizar");
			seleccionarObjeto(new Clientes());
			break;
		case "2":
			seleccionarObjeto(new Categoria());
			break;
		case "3":
			seleccionarObjeto(new Factura());
			break;
		case "4": 
			seleccionarObjeto(new Producto());
			break;
		case SALIR:
			System.out.println("ByeBye");
			break;
		default:
			System.out.println("Opción no válida");
			break;
			}
		
	}

	private static void leer() {
		System.out.println("¿Qué tabla desea ver?");
		mostrarTablas();
		opcion = keyboardScanner.nextLine();
		switch (opcion) {
		case "1":
			System.out.println("Elija el cliente a ver en detalle");
			seleccionarObjeto(new Clientes());
			break;
		case "2":
			System.out.println("Elija la categoría a ver en detalle");
			seleccionarObjeto(new Categoria());
			break;
		case "3":
			System.out.println("Elija la factura a ver en detalle");
			seleccionarObjeto(new Factura());
			break;
		case "4": 
			seleccionarObjeto(new Producto());
			break;
		case SALIR:
			System.out.println("ByeBye");
			keyboardScanner.close();
			break;
		default:
			System.out.println("Opción no válida");
			break;
			}
		
	}

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
	
	private static DbObject seleccionarObjeto(DbObject modelo) {
		
		List<DbObject> tabla = DbController.getInstance().list(modelo);
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}
		for(DbObject obj: tabla ) {	
			System.out.println(obj.getId()+" "+obj.toString());
		}
		System.out.println("Introduzca la ID del objeto de "+modelo.getTable()+ " que quiera seleccionar ");
	
		int id = Integer.parseInt(keyboardScanner.nextLine());
		DbObject pedido = modelo.getByid(id);
		return pedido; 
	}
	

}
