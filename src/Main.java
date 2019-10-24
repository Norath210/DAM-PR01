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
