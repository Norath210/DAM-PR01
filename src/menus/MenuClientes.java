package src.menus;

import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Clientes;
import src.models.comun.DbObject;

public class MenuClientes extends Menu {
	
	
	public String toString() {
		// TODO Auto-generated method stub
		return 
				"¿Qué acción quiere realizar? \n"+
				"1.Crear nueva cliente \n"+
				"2.Ver clientes\n"+
				"3.Ver detalles de un cliente\n"+
				"4.Actualizar una cliente \n"+
				"5.Borrar una cliente \n"+				
				
				"0.Volver"	;
	}
	
	
	
	
	@Override
	protected Menu siguienteMenu(String opcion) {
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
		String datos;
		boolean valido = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre que quiere dar a la categoría");
		datos = keyboard.nextLine();
		while (!valido ) {
			valido = !datos.contains(",");
			if( !valido ) {
				System.out.println("Los campos introducidos no pueden contener el carácter ','");
			}else {				
				cli.setNombre(datos);
			}			
		}
		keyboard.close();
	}
	private String comprobarCampo() {
		Clientes cli = new Clientes();
		String datos;
		boolean valido = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre que quiere dar a la categoría");
		datos = keyboard.nextLine();
		while (!valido ) {
			valido = !datos.contains(",");
			if( !valido ) {
				System.out.println("Los campos introducidos no pueden contener el carácter ','");
			}else {				
				cli.setNombre(datos);
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
		String datos;
		boolean valido = false;
		Scanner keyboard = new Scanner(System.in);
		Integer id;
		
		
		Categoria cat = new Categoria();
		System.out.println("Introduzca la ID de la categoría que quiere actualizar");
		verCliente();
		id = Integer.parseInt(keyboard.nextLine());
		cat = (Categoria) cat.getByid(id);
		if (cat != null) {
			System.out.println("Introduzca el nombre que quiere dar a la categoría (Actual: "+cat.getNombre());
			datos = keyboard.nextLine();
			while (!valido ) {
				valido = !datos.contains(",");
				if( !valido ) {
					System.out.println("Los campos introducidos no pueden contener el carácter ','");
				}else {				
					cat.setNombre(datos);
					cat.save();				
				}			
				System.out.println("Nombre de Categoría "+cat.getId()+" cambiado a "+cat.getNombre());
			}
		}else {
			System.out.println("La categoría introducida no existe");
		}
		keyboard.close();
		
	}
	private void borrarCliente() {
		Scanner keyboard = new Scanner(System.in);
		Integer id;
	
		Categoria cat = new Categoria();
		System.out.println("Introduzca la ID de la categoría que quiere actualizar");
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
