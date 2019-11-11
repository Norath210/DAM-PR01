package src.menus;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.models.Categoria;
import src.models.Clientes;
import src.models.comun.DbObject;

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
		while (!opcion.equals("0")) {			
				
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
			return null;
		}
		return new MenuPrincipal();		
	}

	private void crearCliente() {
		Clientes cli = new Clientes();
		System.out.println("Introduzca el nombre del cliente");
		cli.setNombre(campoValido("^[^,]+$"));
		System.out.println("Introduzca el dni del cliente");
		cli.setDni(campoValido("^[^,]+$"));
		System.out.println("Introduzca dirección: ");
		cli.setDireccion(campoValido("^[^,]+$"));
		System.out.println("Introduzca telefono: ");
		cli.setTelefono(campoValido("^[^,]+$"));
		System.out.println("Introduzca email: ");
		cli.setEmail(campoValido("^[A-Za-z0-9+_.-]+@(.+)$"));
		cli.save();
		
		
	}
	
	private String campoValido(String regexp) {
		Pattern pattern = Pattern.compile(regexp);
		
		
		
		String datos;
		boolean valido = false;
		Scanner keyboard = new Scanner(System.in);	
		
		datos = keyboard.nextLine();
		Matcher matcher = pattern.matcher(datos);
		while (matcher.find() ) {			
			if( !valido ) {
				System.out.println("El campo intoducido debe validar la expresion regular"
						+ " '"+ regexp +"', introduzca un valor válido");
				datos = keyboard.nextLine();
				matcher = pattern.matcher(datos);
			}								
		}
		keyboard.close();
		return datos;
	}
	
	
	
	
	private void verCliente() {
		Categoria cat = new Categoria();		
		List<DbObject> listaCat = cat.list();
		System.out.println("Tabla Categoria: ");
		System.out.println("ID \t Nombre");
		for(DbObject obj : listaCat) {
			cat = (Categoria)obj;
			System.out.print(cat.getId() +"\t");
			System.out.print(cat.getNombre()+"\n");			
		}		
	}
	
	private void actualizarCliente() {
		Scanner keyboard = new Scanner(System.in);
		Integer id;		
		
		Clientes  cli = new Clientes();
		System.out.println("Introduzca la ID del cliente que quiere actualizar");
		verCliente();
		id = Integer.parseInt(keyboard.nextLine());
		cli = (Clientes) cli.getByid(id);
		if (cli != null) {
			System.out.println("Introduzca el nuevo nombre del cliente");
			cli.setNombre(campoValido("^[^,]*$"));
			System.out.println("Introduzca el nuevo dni del cliente");
			cli.setDni(campoValido("^[^,]*$"));
			System.out.println("Introduzca la nueva dirección: ");
			cli.setDireccion(campoValido("^[^,]*$"));
			System.out.println("Introduzca el nuevo telefono: ");
			cli.setTelefono(campoValido("^[^,]*$"));
			System.out.println("Introduzca el nuevo email: ");
			cli.setEmail(campoValido("^[A-Za-z0-9+_.-]+@(.+)$"));
			cli.save();
		}else {
			System.out.println("La categoría introducida no existe");
		}
		keyboard.close();
		
	}
	private void borrarCliente() {
		Scanner keyboard = new Scanner(System.in);
		Integer id;
	
		Categoria cat = new Categoria();
		System.out.println("Introduzca la ID del cliente que quiere borrar");
		verCliente();
		id = Integer.parseInt(keyboard.nextLine());
		cat = (Categoria) cat.getByid(id);
		if (cat != null) {
			cat.delete();
		}else {
			System.out.println("La categoría introducida no existe");
		}
		keyboard.close();
		
	}
	
	

}
