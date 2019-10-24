package src.models.comun;

public abstract class DbObject {

	public abstract String getTable();	 //Devuelve el nombre de la tabla
	public abstract String getCampos();  //Devuelve el nombre de los campos que se rellenan en la BD (todo salvo ID y fecha de inserción
	public abstract String getValues();	 //Recuperar los valores de los campos de la BD
	
	public void save() {
		DbController.getInstance().saveDb(this);
	}
	public String formatCampo(String lCampos,String nombreCampo, Object Valor) {
		
	}
}
