package src.menus;

import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.comun.DbObject;

public class MenuCategorias extends Menu {

	public String toString() {
		// TODO Auto-generated method stub
		return 
				"�Qu� acci�n quiere realizar? \n"+
				"1.Crear nueva categor�a \n"+
				"2.Ver categor�as \n"+
				"3.Actualizar una categor�a \n"+
				"4.Borrar una categor�a \n"+				
				
				"0.Volver"	;
	}
	
	
	
	
	@Override
	protected Menu siguienteMenu(String opcion) {
		while (!opcion.equals("0")) {			
				
				switch (opcion) {
				case "1":
					crearCategoria();
					break;
				case "2":
					verCategorias();
					break;

				case "3": 
					actualizarCategoria();
					break;
				case "4": 
					borrarCategoria();
					break;
					
				case "0":
					break;
				default:
					System.out.println("Opci�n no v�lida");
					break;
				}
			return null;
		}
		return new MenuPrincipal();
		
		
	}

	private void crearCategoria() {
		Categoria cat = new Categoria();
		String datos;
		boolean valido = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre que quiere dar a la categor�a");
		datos = keyboard.nextLine();
		while (!valido ) {
			valido = !datos.contains(",");
			if( !valido ) {
				System.out.println("Los campos introducidos no pueden contener el car�cter ','");
			}else {				
				cat.setNombre(datos);
				cat.save();				
			}			
		}
		keyboard.close();
	}
	
	
	private void verCategorias() {
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
	
	private void actualizarCategoria() {
		String datos;
		boolean valido = false;
		Scanner keyboard = new Scanner(System.in);
		Integer id;
		
		
		Categoria cat = new Categoria();
		System.out.println("Introduzca la ID de la categor�a que quiere actualizar");
		verCategorias();
		id = Integer.parseInt(keyboard.nextLine());
		cat = (Categoria) cat.getByid(id);
		if (cat != null) {
			System.out.println("Introduzca el nombre que quiere dar a la categor�a (Actual: "+cat.getNombre());
			datos = keyboard.nextLine();
			while (!valido ) {
				valido = !datos.contains(",");
				if( !valido ) {
					System.out.println("Los campos introducidos no pueden contener el car�cter ','");
				}else {				
					cat.setNombre(datos);
					cat.save();				
				}			
				System.out.println("Nombre de Categor�a "+cat.getId()+" cambiado a "+cat.getNombre());
			}
		}else {
			System.out.println("La categor�a introducida no existe");
		}
		keyboard.close();
		
	}
	private void borrarCategoria() {
		Scanner keyboard = new Scanner(System.in);
		Integer id;
	
		Categoria cat = new Categoria();
		System.out.println("Introduzca la ID de la categor�a que quiere actualizar");
		verCategorias();
		id = Integer.parseInt(keyboard.nextLine());
		cat = (Categoria) cat.getByid(id);
		if (cat != null) {
			cat.delete();
		}else {
			System.out.println("La categor�a introducida no existe");
		}
		keyboard.close();
		
	}


	
	
	

}
