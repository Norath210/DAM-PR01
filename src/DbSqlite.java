import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 


public class DbSqlite {
	private static DbSqlite instance;
	private Connection conn = null;

	private DbSqlite() {
		this.init();		
	}

	public static DbSqlite getInstance() {
		if (instance == null) {
			instance = new DbSqlite();
		}
		return instance;
	}
	
	private void checkDbFiles() {
		boolean fileExist = false;
		File path = new File(Config.PATH_DB);
		if(!path.exists()) {
			path.mkdirs();
		}
		try {
		File db = new File(path,Config.DBNAME);
		if( db.createNewFile());
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if (fileExist) {
				System.out.println("Base de Datos, Creada");
			}
		}
	}
	
	private Connection init() {
		
		Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+Config.PATH_DB;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.checkDbFiles();
        } 
		return conn;
	}
}
	

