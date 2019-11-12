package src.menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.models.Factura;
import src.models.FacturaLinea;
import src.models.comun.DbObject;

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
				"7.Borrar una linea de una factura \n"+
				
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
		Factura fac = (Factura)new Factura().seleccionarObjeto();
		List<DbObject> listFl = new FacturaLinea().getByCampos("id_factura",fac.getId()+"");
		for(DbObject obj: listFl) {
			System.out.println(obj.getId()+" "+obj);
		}
		FacturaLinea fl = (FacturaLinea) new FacturaLinea().seleccionarObjeto();
		fl.delete();
		
	}

	private void borrarFactura() {
		Factura fac = (Factura) new Factura().seleccionarObjeto();
		List<DbObject> listFl = new FacturaLinea().getByCampos("id_factura",fac.getId()+"");
		for(DbObject obj: listFl) {
			obj.delete();
		}
		
		fac.delete();
		
	}

	private void editarFactura() {
		
		Factura fac = (Factura)new Factura().seleccionarObjeto();
		
		System.out.println("Introduzca la fecha de la factura, (formato yyyy/MM/dd) ");
		fac.setFecha(validarFecha());		
		System.out.println("Introduzca la serie de la factura,  ");
		fac.setSerie(Integer.valueOf(campoValido("^\\d+$")));
		System.out.println("Elija un cliente al que asignar la factura");
		fac.setId_cliente(Integer.valueOf(campoValido("^\\d+$")));
			
		
	}
		
	

	private void verLineasFactura() {
		Factura fac = (Factura)new Factura().seleccionarObjeto();
		
		List<DbObject> listFl = new FacturaLinea().getByCampos("id_factura",fac.getId()+"");
		for(DbObject obj: listFl) {
			System.out.println(obj.getId()+" "+obj);
		}
				
				
		
	}

	private void verFacturas() {
		List<DbObject> facList = new Factura().list();
		
		for(DbObject obj: facList ) {
			System.out.println(obj.getId()+ " " +obj.toString());
		}
		
	}

	
	private void crearLineaFactura() {
		Factura fac = (Factura)new Factura().seleccionarObjeto();
		
	}

	private void crearFactura() {
		
		Factura fac = new Factura();
		
		System.out.println("Introduzca la fecha de la factura, (formato yyyy/MM/dd) ");
		fac.setFecha(validarFecha());		
		System.out.println("Introduzca la serie de la factura,  ");
		fac.setSerie(Integer.valueOf(campoValido("^\\d+$")));
		System.out.println("Elija un cliente al que asignar la factura");
		fac.setId_cliente(Integer.valueOf(campoValido("^\\d+$")));
			
		
	}
	
	private Date validarFecha() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Scanner keyboard = new Scanner(System.in);	
		Date fecha = new Date();
		String datos;
		boolean validado = false;
		
		datos = keyboard.nextLine();
		
		while(!validado) {
			try {
				fecha = sdf.parse(datos);
				validado = true;
			} catch (ParseException e) {
				System.err.println("Error: el formato de la fecha debe ser: yyyy/MM/dd");
				e.printStackTrace();
			}
		}
		keyboard.close();
		return fecha;
	}

	private String campoValido(String regexp) {
		Pattern pattern = Pattern.compile(regexp);
		
		
		
		String datos;
		boolean valido = false;
		Scanner keyboard = new Scanner(System.in);	
		
		datos = keyboard.nextLine();
		Matcher matcher = pattern.matcher(datos);
		while (matcher.find() ) {		
				System.out.println("El campo intoducido debe validar la expresion regular"
						+ " '"+ regexp +"', introduzca un valor válido");
				datos = keyboard.nextLine();
				matcher = pattern.matcher(datos);
											
		}
		keyboard.close();
		return datos;
	}

}
