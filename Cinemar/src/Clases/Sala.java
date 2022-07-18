package Clases;

public class Sala {
 private int IdSala;
 private int numero;
 private int capacidad;
 private TipoSala tiposala;
  public Sala(int IdSala,int numero,int capacidad,TipoSala tiposala) {
  super();
  this.IdSala=IdSala;
  this.numero=numero;
  this.capacidad=capacidad;
  this.setTiposala(tiposala);
  }
  
  public int getNumero() {
		return numero;
	}
   public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIdSala() {
		return IdSala;
	}
	public void setIdSala(int idSala) {
		IdSala = idSala;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public TipoSala getTiposala() {
		return tiposala;
	}

	public void setTiposala(TipoSala tiposala) {
		this.tiposala = tiposala;
	}

	}
