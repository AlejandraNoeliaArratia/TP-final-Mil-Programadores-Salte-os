package Clases;

public class Rol {
 private int IdRol;
 private String tipo;
 public Rol(int IdRol,String tipo) {
 super();
 this.setIdRol(IdRol) ;
 this.setTipo(tipo);
 }
public int getIdRol() {
	return IdRol;
}
public void setIdRol(int idRol) {
	IdRol = idRol;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
}
