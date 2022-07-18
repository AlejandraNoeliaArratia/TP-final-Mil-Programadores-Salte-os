package Clases;

public class Butaca {
 private int IdButaca;
 private String nombre;
 private Sala sala;
 private String modelo;
 private Estado_Butaca estadobutaca;
 public Butaca(int IdButaca,String nombre,Sala sala,String modelo) {
 super();
 this.setIdButaca(IdButaca);
 this.setNombre(nombre);
 this.setSala(sala);
 this.setModelo(modelo);
 }
public int getIdButaca() {
	return IdButaca;
}
public void setIdButaca(int idButaca) {
	IdButaca = idButaca;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Sala getSala() {
	return sala;
}
public void setSala(Sala sala) {
	this.sala = sala;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public Estado_Butaca getEstadobutaca() {
	return estadobutaca;
}
public void setEstadobutaca(Estado_Butaca estadobutaca) {
	this.estadobutaca = estadobutaca;
}
}
