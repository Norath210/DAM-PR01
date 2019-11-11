package src.menus;

public class MenuFacturas extends Menu {
	public String toString() {
		// TODO Auto-generated method stub
		return 
				"¿Qué acción quiere realizar? \n"+
				"1.Crear nueva factura \n"+
				"2.Añadir una linea a una factura existente \n"+
				"3.Ver facturas\n"+
				"4.Ver lineas de una factura\n"+
				"5.Editar una factura \n"+
				"6.Borrar una factura \n"+	
				"6.Borrar una linea de una factura \n"+
				
				"0.Volver al menú principal"	;
	}
	
	public Menu siguienteMenu(String opcion) {
		while (!opcion.equals("0")) {			
				
				switch (opcion) {
				case "1":
					crearFactura();
					break;
				case "2":
					crearLineaFactura();
					break;
				case "3": 
					verFacturas();
					break;
				case "4": 
					verLineasFactura();
					break;
				case "5":
					editarFactura();
					break;
				case "6":	
					borrarFactura();
					break;		
				case "7":
					borrarLineaFactura();
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

	private void borrarLineaFactura() {
		// TODO Auto-generated method stub
		
	}

	private void borrarFactura() {
		// TODO Auto-generated method stub
		
	}

	private void editarFactura() {
		// TODO Auto-generated method stub
		
	}

	private void verLineasFactura() {
		// TODO Auto-generated method stub
		
	}

	private void verFacturas() {
		// TODO Auto-generated method stub
		
	}

	private void actualizarCliente() {
		// TODO Auto-generated method stub
		
	}

	private void crearLineaFactura() {
		// TODO Auto-generated method stub
		
	}

	private void crearFactura() {
		// TODO Auto-generated method stub
		
	}
	

}
