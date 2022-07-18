package Clases;

public class TipoSala {
 private int IdTiposala;
 private String formato;
 public TipoSala(int IdTiposala,String formato) {
 super();
 this.setIdTiposala(IdTiposala);
 this.formato=formato;
}
public String getFormato() {
	return formato;
}

public void setFormato(String formato) {
	this.formato = formato;
}
public int getIdTiposala() {
	return IdTiposala;
}
public void setIdTiposala(int idTiposala) {
	IdTiposala = idTiposala;
}
}
