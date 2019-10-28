<<<<<<< HEAD
package src; 
import src.models.Clientes; 

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del día
		//Backup.getInstance().doBackup();  
		
		Clientes client = new Clientes();
		client.setNombre("cliente 02");
		client.setEmail("user02@user.com");
		client.setDni("1234");
		client.setTelefono("1234567");
		  
		client.save();
		
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
=======
package src; 
import src.models.Categoria;
import src.models.Clientes;
import src.models.Producto; 

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del día
		//Backup.getInstance().doBackup();  
		
		 Categoria cat = new Categoria();
		 cat.setNombre("Cat 01");
		 
		 Producto prod = new Producto();
		 prod.setId_categoria(1); // TODO: Select de la categoria insertada
		 prod.setNombre("PROD 01");
		 prod.setPrecio(100);
		 prod.setStock(1);
		 
		 prod.save();
		
		
		
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
>>>>>>> e
