package Clases;
public class Reserva {
 private int IdReserva;
 private String codigo;
 private Usuario usuario;
 private Estado estado;
 private String fecha;
 private String hora;
 private Funcion funcion;
 public Reserva(int IdReserva,String codigo,Usuario usuario,Estado estado,String fecha,String hora,Funcion funcion) {
 super();
 this.IdReserva=IdReserva;
 this.codigo=codigo;
 this.usuario=usuario;
 this.estado=estado;
 this.fecha=fecha;
 this.hora=hora;
 this.funcion=funcion;
 }
public int getIdReserva() {
	return IdReserva;
}
public void setIdReserva(int idReserva) {
	IdReserva = idReserva;
}

public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public Estado getEstado() {
	return estado;
}
public void setEstado(Estado estado) {
	this.estado = estado;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}

public Funcion getFuncion() {
	return funcion;
}
public void setFuncion(Funcion funcion) {
	this.funcion = funcion;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}

}
