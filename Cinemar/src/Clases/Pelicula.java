package Clases;
import java.util.ArrayList;
public class Pelicula {
 private int IdPelicula;
 private String nombre;
 private String genero;
 private String director;
 private ArrayList<String> reparto;
 private String sinopsis;
 private double duracion;
 private TipoPelicula tipopelicula;
 public Pelicula(int IdPelicula,String nombre,String genero,String director,ArrayList<String>reparto,String sinopsis,double duracion,TipoPelicula tipopelicula) {
	 super();
	 this.setIdPelicula(IdPelicula);
	 this.setNombre(nombre);
	 this.setGenero(genero);
	 this.setDirector(director);
	 this.setReparto(reparto);
	 this.setSinopsis(sinopsis);
	 this.setDuracion(duracion);
	 this.setTipo(tipopelicula);

  }
public int getIdPelicula() {
	return IdPelicula;
}
public void setIdPelicula(int idPelicula) {
	IdPelicula = idPelicula;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public ArrayList<String> getReparto() {
	return reparto;
}
public void setReparto(ArrayList<String> reparto) {
	this.reparto = reparto;
}
public String getSinopsis() {
	return sinopsis;
}
public void setSinopsis(String sinopsis) {
	this.sinopsis = sinopsis;
}
public double getDuracion() {
	return duracion;
}
public void setDuracion(double duracion) {
	this.duracion = duracion;
}
public TipoPelicula getTipo() {
	return tipopelicula;
}
public void setTipo(TipoPelicula tipopelicula) {
	this.tipopelicula = tipopelicula;
}
}