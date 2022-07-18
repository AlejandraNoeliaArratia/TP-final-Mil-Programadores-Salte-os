package Clases;

public class Domicilio {
 private int IdDomicilio;
 private String calle;
 private int numero;
 private String ciudad;
 public Domicilio(int IdDomicilio,String calle,int numero,String ciudad) {
 this.setIdDomicilio(IdDomicilio);
 this.setCalle(calle);
 this.setCiudad(ciudad);
 }
public int getIdDomicilio() {
	return IdDomicilio;
}
public void setIdDomicilio(int idDomicilio) {
	IdDomicilio = idDomicilio;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getCiudad() {
	return ciudad;
}
public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}
public String getCalle() {
	return calle;
}
public void setCalle(String calle) {
	this.calle = calle;
}
}
