package src.menus;

import java.util.List;
import java.util.Scanner;
import src.models.Categoria;
import src.models.Clientes;
import src.models.comun.DbObject;
import src.models.comun.Tools;

public class MenuClientes extends Menu {
	
	
	public String toString() {
		
		return 
				"¿Qué acción quiere realizar? \n"+
				"1.Crear nuevo cliente \n"+
				"2.Ver clientes\n"+
				"3.Ver detalles de un cliente\n"+
				"4.Actualizar un cliente \n"+
				"5.Borrar un cliente \n"+			
				
				"0.Volver al menú principal"	;
	}
	
	
	
	
	@Override
	public Menu siguienteMenu(String opcion) {
				
				switch (opcion) {
				case "1":
					crearCliente();
					break;
				case "2":
					verCliente();
					break;
				case "3": 
					actualizarCliente();
					break;
				case "4": 
					borrarCliente();
					break;					
				case "0":
					break;
				default:
					System.out.println("Opción no válida");
					break;
				}
		return new MenuPrincipal();		
	}

	private void crearCliente() {
		Clientes cli = new Clientes();
		System.out.println("Introduzca el nombre del cliente");
		cli.setNombre(MenuController.campoValido("^[^,]+$"));
		System.out.println("Introduzca el dni del cliente");
		cli.setDni(MenuController.campoValido("^[^,]+$"));
		System.out.println("Introduzca dirección: ");
		cli.setDireccion(MenuController.campoValido("^[^,]+$"));
		System.out.println("Introduzca telefono: ");
		cli.setTelefono(MenuController.campoValido("^[^,]+$"));
		System.out.println("Introduzca email: ");
		cli.setEmail(MenuController.campoValido("^[A-Za-z0-9+_.-]+@(.+)$"));
		cli.save();		
		
	}
	private void verCliente() {
		Clientes cli = new Clientes();		
		List<DbObject> listaCat = cli.list();
		System.out.println("Tabla Categoria: ");
		System.out.println("ID \t Nombre");
		for(DbObject obj : listaCat) {
			cli = (Clientes)obj;
			System.out.print(cli.getId() +"\t");
			System.out.print(cli.getNombre()+"\n");			
		}		
	}
	
	private void actualizarCliente() {
		
		Clientes  cli = (Clientes) MenuController.getInstance().seleccionarObjeto(new Clientes());
		
		if (cli != null) {
			System.out.println("Introduzca el nombre del cliente");
			cli.setNombre(MenuController.campoValido("^[^,]+$"));
			System.out.println("Introduzca el dni del cliente");
			cli.setDni(MenuController.campoValido("^[^,]+$"));
			System.out.println("Introduzca dirección: ");
			cli.setDireccion(MenuController.campoValido("^[^,]+$"));
			System.out.println("Introduzca telefono: ");
			cli.setTelefono(MenuController.campoValido("^[^,]+$"));
			System.out.println("Introduzca email: ");
			cli.setEmail(MenuController.campoValido("^[A-Za-z0-9+_.-]+@(.+)$"));
			cli.save();
			
		}else {
			System.out.println("El cliente introducido no existe");
		}
		
	}
	private void borrarCliente() {
		Clientes cli = (Clientes) MenuController.getInstance().seleccionarObjeto(new Clientes());	
		
		if (cli != null) {
			cli.delete();
		}else {
			System.out.println("El cliente seleccionado no existe");
		}
	}
	
	

}
