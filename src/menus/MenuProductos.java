package src.menus;

import java.util.List;

import src.models.Categoria;
import src.models.Producto;
import src.models.comun.DbObject;

public class MenuProductos extends Menu {
	public String toString() {
		// TODO Auto-generated method stub
		return 
				"¿Qué acción quiere realizar? \n"+
				"1.Crear nuevo producto \n"+
				"2.Ver productos \n"+
				"3.Ver productos de una categoría\n"+
				"4.Editar un producto\n"+
				"5.Borrar un producto \n"+	
				
				
				"0.Volver al menú principal"	;
		
	}
	
	public Menu siguienteMenu(String opcion) {
				
				switch (opcion) {
				case "1":
					crearProducto();
					break;
				case "2":
					verProductos();
					break;
				case "3": 
					verProductosCat();
					break;
				case "4": 
					editarProducto();
					break;
				case "5":
					borrarProducto();
					break;				
				case "0":
					break;
				default:
					System.out.println("Opción no válida");
					break;
				
		}
		return new MenuPrincipal();		
	}

	private void crearProducto() {
		Producto prod = new Producto();
		
		prod.save();
	}

	private void verProductos() {
		List<DbObject> prodList =  new Producto().list();
		for(DbObject obj : prodList) {			
			System.out.println(obj.getId()+" "+obj.toString());
		}
	}

	private void verProductosCat() {
		Categoria cat = (Categoria) new Categoria().seleccionarObjeto();
		List<DbObject> prodList =  new Producto().list();
		
		for(DbObject obj : prodList) {
			Producto prod = (Producto) obj;
			if(prod.getId_categoria() == cat.getId()) {
			System.out.println(prod.getId()+" "+prod.toString());
			}
		}
		
		
	}

	private void editarProducto() {
		Producto prod = (Producto) new Producto().seleccionarObjeto();
		
		prod.save();
	}

	private void borrarProducto() {
		Producto prod = (Producto) new Producto().seleccionarObjeto();
		
		prod.delete();
		
	}
	
	
	
	
	
}
