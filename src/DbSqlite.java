import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 


public class DbSqlite {
	private static DbSqlite instance;

	private DbSqlite() {

		this.init();
		
	}

	public static DbSqlite getInstance() {
		if (instance == null) {
			instance = new DbSqlite();
		}
		return instance;
	}
	
	
	public void init() {
		String path = "C:/DAM2/AD/Practicas/Pr01/";
		Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+path+"miTienda.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
		
	}
	

	public static void main(String[] args) {
		DbSqlite db = DbSqlite.getInstance();
	}

}
