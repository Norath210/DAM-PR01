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
				"¿Qué tabla quiere manejar?"+
				"1.Categoría"+
				"2.Clientes"+
				"3.Factura"+
				"4.Producto"+
				
				"0.Salir"	;
	}
	
	@Override
	protected Menu eligeOpcion(String opcion) {
	while (!opcion.equals("0")) {	
		
		
		switch (opcion) {
		case "1":
			return new MenuCategoria();
			break;
		case "2":
			return new MenuClientes();
			break;
		case "3": 
			return new MenuFactura();
			break;
		case "4": 
			return new MenuProductos();
			break;
		case "0":
			System.out.println("ByeBye");	
			return null;
		default:
			System.out.println("Opción no válida");
			break;
		}
		menuAccion(modelo);	
	}
	
}
		return null;
	}

}
