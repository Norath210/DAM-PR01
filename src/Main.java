package src; 

import src.menus.MenuController;
import src.models.Categoria;

public class Main {
	
	/**
	 * <strong>EJERCICIOS</strong>
	 * <strong>Entrega: 6 de Noviembre (Github)</strong>
	 * 
	 * 1.- Actualizar vuestros repositorio con este
	 * 2.- Interface Comandos:
	 * 	-> Categoria: CRUD
	 *  -> Producto: CRUD // NOTA: Un producto tiene un id_Categoria obligatorio, y tiene existir la categoria
	 *  -> Cliente: CRUD
	 * 
	 * 2.- Listar:
	 *  -> Productos de una Categoria // Dado un ID de categoria; tener todos los productos
	 * 
	 * 3*.- Validaciones:
	 *  -> Los datos del C/U (Create/Update) tienen que cumplir condiciones coherentes. 
	 *  => PISTA: regex
	 * 
	 * *-> Para nota ;)
	 * 
	 */

	public static void main(String[] args) {	
		
		 MenuController.getInstance().callMenus();	
	 
	}

}
