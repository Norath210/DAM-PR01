
public class Main {
	public static void main(String[] args) {
	// Hacer el backup del d�a
	
	Backup.getInstance().doBackup();
	
	//Comprobar que la base de datos existe
	DbSqlite db = DbSqlite.getInstance();
	//Arrancar
	}
	
}
