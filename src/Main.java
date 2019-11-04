package src; 
import java.util.ArrayList;
import java.util.List;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Producto;
import src.models.comun.DbObject;
import src.models.comun.Tools; 

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
		
		// Hacer el Backup del d�a
		//Backup.getInstance().doBackup();  
		
		 Categoria cat = new Categoria();
		 cat.setNombre("Cat 01");
		 //cat.save();
		 List<DbObject> cats = cat.list();
		 for (DbObject item : cats) {
			Categoria dbCat = (Categoria)item;
			System.out.println(dbCat.toString());
		}
		 
		 Producto prod = new Producto();
		 prod.setId_categoria(1); // TODO: Select de la categoria insertada
		 prod.setNombre("PROD 01");
		 prod.setPrecio(100);
		 prod.setStock(1);
		 
		 prod.save();
		 
		 List<DbObject> productos = prod.list();
		 for (DbObject dbObject : productos) {
			Producto p = (Producto) dbObject;
			//p.delete();
			p.setPrecio(100);
			p.save(); 
		} 
		 
		 Clientes cli = new Clientes();
		 cli.setNombre("Cliente");
		 cli.setDni(""+Tools.getInstance().getRandomNumber());
		 cli.save();
		 
		 
		 Clientes cli01 = (Clientes)new Clientes().getByid(1);
		 System.out.println(cli01);
		
		
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
