package Clases;
public class Funcion {
	 private int IdFuncion;
	 private Pelicula pelicula;
	 private String fecha;
	 private String hora;
	 private Sala sala;
 public Funcion(int IdFuncion,Pelicula pelicula,String fecha,Sala sala,String hora) {
 super();
 this.setIdFuncion(IdFuncion);
 this.setPelicula(pelicula);
 this.setFecha(fecha);
 this.setSala(sala);
 this.setHora(hora);
 }
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public int getIdFuncion() {
	return IdFuncion;
}
public void setIdFuncion(int idFuncion) {
	IdFuncion = idFuncion;
}
public Pelicula getPelicula() {
	return pelicula;
}
public void setPelicula(Pelicula pelicula) {
	this.pelicula = pelicula;
}
public Sala getSala() {
	return sala;
}
public void setSala(Sala sala) {
	this.sala = sala;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
}
	
	