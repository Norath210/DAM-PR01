package src.models.comun;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public abstract class DbObject {

	
	public abstract Integer getId();
	public abstract String getTable();
	public abstract String getCampos();
	public abstract String getValues();
	public abstract DbObject getDbObject(ResultSet res) throws SQLException;
	
	public abstract void verTodos(); 
	public abstract void ver();
	public abstract DbObject crearPorTeclado();
	public abstract void editarPorTeclado();
	
	
	
	/**
	@return todos los campos del DbObject en cuestión
	*/
	public abstract String getAllCampos();
	
	
	public void save() {
		DbController.getInstance().saveDb(this);
	}
	
	public List<DbObject> list() {
		return DbController.getInstance().list(this);
	}
	
	public void delete() { 
		DbController.getInstance().deleteDb(this);
	}
	
	public DbObject getByid(Integer id) {
		return DbController.getInstance().getByid(this, id);
	}
	
	
	private boolean isNullOrEmpty(Object value) {
		if (value == null) {
			return true;
		} 
		
		if (value instanceof String) {
			if (( (String)value ).trim().isEmpty() ) {
				return true;
			}
		}
		
		return false;
	}
	
	public String getCorrectCampos(String data, String campo, Object value) {
		if (isNullOrEmpty(data)) {
			data = "";
		}
		if (isNullOrEmpty(value)) {
			return data;
		}
		
		if (data.isEmpty()) {
			return ""+campo;
		} 
		
		return data+","+campo;
	}
	
	
	public String getCorrectValues(String data, Object value) {
		if (isNullOrEmpty(data)) {
			data = "";
		}
		if (isNullOrEmpty(value)) {
			return data;
		}
		
		if (data == null || data.isEmpty()) {
			return "'"+value+"'";
		} 
		
		return data+",'"+value+"'";
	}
	
	public DbObject seleccionarObjeto() {
		
		Scanner keyboardScanner= new Scanner(System.in);
		int id=-1;
		List<DbObject> tabla = DbController.getInstance().list(this);
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}
		for(DbObject obj: tabla ) {	
			System.out.println(obj.getId()+" "+obj.toString());
		}
		System.out.println("Introduzca la ID del objeto de "+this.getTable()+ " que quiera seleccionar ");
		try {
		id = Integer.parseInt(keyboardScanner.nextLine());
		}catch(Exception ex){
			
		}
		DbObject pedido = this.getByid(id);
		return pedido; 
	}
	
	
	
	
	
	
	
		
}
