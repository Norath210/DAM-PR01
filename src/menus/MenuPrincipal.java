package src.menus;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Factura;
import src.models.Producto;
import src.models.comun.DbObject;
public class MenuPrincipal extends Menu{
	
	public static Menu eligeTabla(String Opcion) {
		return null;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 
				"�Qu� tabla quiere manejar? \n"+
				"1.Categor�a \n"+
				"2.Clientes \n"+
				"3.Factura \n"+
				"4.Producto \n"+
				
				"0.Salir"	;
	}
	
	@Override
	public Menu siguienteMenu(String opcion) {
	while (!opcion.equals("0")) {			
		
		switch (opcion) {
		case "1":
			return new MenuCategorias();
		case "2":
			return new MenuClientes();
		case "3": 
			return new MenuFacturas();
		case "4": 
			return new MenuProductos();
		case "0":
			return null;
		default:
			System.out.println("Opci�n no v�lida");
			break;
		}
	}
	

		return null;
	}

}
