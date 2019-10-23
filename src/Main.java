package src;
import java.sql.Connection; 

import src.models.Categoria;
import src.models.comun.DbSqlite;

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del día
		Backup.getInstance().doBackup();
		
		// Comprobar que la base de datos existe
		DbSqlite db = DbSqlite.getInstance();
		Connection con = db.getConnection();
		
		// Arrancar
		
		 
		Categoria.saveDb(con, "Categoria 02");
		
		
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
