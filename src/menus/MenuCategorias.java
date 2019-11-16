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
				
				"0.Volver al men� principal"	;
	}
	
	
	
	
	@Override
	public Menu siguienteMenu(String opcion) {
				
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
					return new MenuPrincipal();
					
				default:
					System.out.println("Opci�n no v�lida");
					break;
				}			
				return new MenuCategorias();
		
	}

	private void crearCategoria() {
		Categoria cat = new Categoria();
		System.out.println("Introduzca un nombre para la categor�a");
		cat.setNombre(MenuController.campoValido("^[^,]+$"));
		cat.save();
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
		Categoria cat = MenuController.eligeCategoria();
		if (cat == null) {
			return;
		}
		System.out.println("Introduzca un nombre para la categor�a");
		cat.setNombre(MenuController.campoValido("^[^,]+$"));
		cat.save();		
	}
	private void borrarCategoria() {		
		Categoria cat = MenuController.eligeCategoria();
		if (cat == null) {
			
			return;
		}
		cat.delete();		
	}


	
	
	

}
