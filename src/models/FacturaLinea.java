package src.models;

import java.util.Date;

import src.models.comun.DbObject;

public class FacturaLinea extends DbObject{

	private Integer id;
	private Date created;
	private Integer id_factura;
	private String nombre;
	private Integer precio; // 100 = 1,00€
	
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
	public Integer getId_factura() {
		return id_factura;
	}
	public void setId_factura(Integer id_factura) {
		this.id_factura = id_factura;
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
	@Override
	public String getTable() {
		return "facturas_linea";
	}
	@Override
	public String getCampos() {
		return "id_factura, nombre, precio";
	}
	@Override
	public String getValues() {
		return "'"+id_factura+"','"+nombre+"','"+precio+"'";
	}
	
	
}
