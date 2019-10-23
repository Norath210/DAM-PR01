package src.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Categoria {

	private Integer id;
	private Date created;
	private String nombre;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public static boolean saveDb(Connection con, String nombre) { 
		
		try {
			
			Statement statemnt = con.createStatement();
			
			String sql = "select * from categorias where nombre = '"+nombre+"'";
			ResultSet res = statemnt.executeQuery(sql);
			if (res.next()) {
				System.out.println("Categoria "+nombre+" Ya Existe");
				return false;
			}
			
			String insertar = "INSERT INTO 'categorias' ('nombre') VALUES ('"+nombre+"');";
			statemnt.execute(insertar);
		 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		System.out.println("Categoria "+nombre+" Insertada");
		return true;
	}
	
	
	
}
