<<<<<<< HEAD
package src.models;

import java.util.Date;

import src.models.comun.DbObject;

public class Factura extends DbObject {

	private Integer id;
	private Date created;
	private Date fecha;
	private Integer serie;
	private Integer id_cliente;
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getSerie() {
		return serie;
	}
	public void setSerie(Integer serie) {
		this.serie = serie;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getTable() {
		return "facturas";
	}
	@Override
	public String getCampos() {
		return "fecha, serie, id_cliente";
	}
	@Override
	public String getValues() {
		return "'"+this.fecha+"','"+this.serie+"','"+this.id_cliente+"'";				
	}
	
	
}
=======
package src.models;

import java.util.Date;

import src.models.comun.DbObject;

public class Factura extends DbObject{

	private Integer id;
	private Date created;
	private Date fecha;
	private Integer serie; 
	private Integer id_cliente;
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getSerie() {
		return serie;
	}
	public void setSerie(Integer serie) {
		this.serie = serie;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	@Override
	public String getTable() {
		return "facturas";
	}
	@Override
	public String getCampos() {
		String campos = "";
		campos = getCorrectCampos(campos, "fecha"     , this.fecha);
		campos = getCorrectCampos(campos, "serie"     , this.serie);
		campos = getCorrectCampos(campos, "id_cliente", this.id_cliente); 
		return campos;
	}
	@Override
	public String getValues() {
		String value = "";
		value = getCorrectValues(value, this.fecha);
		value = getCorrectValues(value, this.serie);
		value = getCorrectValues(value, this.id_cliente); 
		return value;		
	}
	
	
}
>>>>>>> e
