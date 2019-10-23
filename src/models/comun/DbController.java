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
	
	public boolean saveDb(String TABLA, String campo, String valor) { 
		
		String sqlExist = "select * from '"+TABLA+"' where '"+campo+"' = '"+valor+"'";
		String sqlIns = "INSERT INTO "+TABLA+" ('"+campo+"') VALUES ('"+valor+"');";
		
		try {
			
			Statement statemnt = this.con.createStatement();
			
			
			ResultSet res = statemnt.executeQuery(sqlExist);
			if (res.next()) {
				System.out.println("Objeto "+TABLA+" - "+valor+" Ya Existe");
				return false;
			} 
			
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
