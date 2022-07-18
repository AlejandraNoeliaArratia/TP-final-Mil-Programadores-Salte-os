package Clases;

public class Estado {
 private int IdEstado;
 private int estado;
 public Estado(int IdEstado,int estado) {
 super();
 this.setIdEstado(IdEstado);
 this.setEstado(estado);
 }
public int getIdEstado() {
	return IdEstado;
}
public void setIdEstado(int idEstado) {
	IdEstado = idEstado;
}
public int isEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
}
