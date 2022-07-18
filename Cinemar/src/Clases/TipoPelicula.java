package Clases;

public class TipoPelicula {
 private int IdTipopelicula;
 private String formato;
 private String idioma;
 private int subtitulada;
 public TipoPelicula(int IdTipopelicula,String formato,String idioma,int subtitulada) {
	super();
	this.setIdTipopelicula(IdTipopelicula);
	this.setFormato(formato);
	this.setIdioma(idioma);
	this.setSubtitulada(subtitulada);
 }
public String getFormato() {
	return formato;
}
public void setFormato(String formato) {
	this.formato = formato;
}
public String getIdioma() {
	return idioma;
}
public void setIdioma(String idioma) {
	this.idioma = idioma;
}
public int isSubtitulada() {
	return subtitulada;
}
public void setSubtitulada(int subtitulada) {
	this.subtitulada = subtitulada;
}
public int getIdTipopelicula() {
	return IdTipopelicula;
}
public void setIdTipopelicula(int idTipopelicula) {
	IdTipopelicula = idTipopelicula;
}
}
