<<<<<<< HEAD
package src.models;

import java.util.Date;

public class Producto {

	private Integer id;
	private Date created;
	private String nombre;
	private Integer precio; // 100 = 1,00
	private Integer stock;
	
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
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	
}
=======
package src.models;

import java.util.Date;

import src.models.comun.DbObject;

public class Producto extends DbObject {

	private Integer id;
	private Date created;
	private String nombre;
	private Integer precio; // 100 = 1,00
	private Integer stock;
	private Integer id_categoria;
	
	
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
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	
	@Override
	public String getTable() {
		return "producto";
	}
	@Override
	public String getCampos() {
		String campos = ""; 
		campos = getCorrectCampos(campos, "nombre", this.nombre);
		campos = getCorrectCampos(campos, "precio", this.precio);
		campos = getCorrectCampos(campos, "stock" , this.stock);
		campos = getCorrectCampos(campos, "id_categoria" , this.id_categoria);  
		return campos;
	}
	@Override
	public String getValues() {
		String value = ""; 
		value = getCorrectValues(value, this.nombre);
		value = getCorrectValues(value, this.precio); 
		value = getCorrectValues(value, this.stock);
		value = getCorrectValues(value, this.id_categoria); 
		return value;		
	}
	
	
}
>>>>>>> e
