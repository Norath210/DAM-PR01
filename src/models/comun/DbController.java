package src.models.comun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbController {
	
	private Connection con;
	
	private static DbController instance;
	 
	private DbController() { 
		DbSqlite db = DbSqlite.getInstance();
		con = db.getConnection();
	}

	public static DbController getInstance() {
		if (instance == null) {
			instance = new DbController();
		}
		return instance;
	}
	
	public boolean saveDb(DbObject obj) {  
		
		String TABLA = obj.getTable();
		String campos = obj.getCampos();
		String valor = obj.getValues();
		 
		String sqlIns = "INSERT INTO "+TABLA+" ("+campos+") VALUES ("+valor+");";
		System.out.println(sqlIns);
		
		try {
			
			Statement statemnt = this.con.createStatement(); 
			statemnt.execute(sqlIns);
		 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		System.out.println("Objeto "+TABLA+" - "+valor+" Insertada");
		return true;
	}

}
