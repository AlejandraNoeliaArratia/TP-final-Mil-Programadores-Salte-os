package Clases;

public class Pago {
 private int IdPago ;
 private String tipopago;
 private double precio;
 private Descuento descuento;
 private Reserva reserva;
 public Pago(int IdPago,String tipopago,double precio,Reserva reserva,Descuento descuento) {
 super();
 this.setIdPago(IdPago);
 this.setTipopago(tipopago);
 this.setPrecio(precio);
 this.setReserva(reserva);
 this.setDescuento(descuento);
 }
public int getIdPago() {
	return IdPago;
}
public void setIdPago(int idPago) {
	IdPago = idPago;
}
public String getTipopago() {
	return tipopago;
}
public void setTipopago(String tipopago) {
	this.tipopago = tipopago;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public Reserva getReserva() {
	return reserva;
}
public void setReserva(Reserva reserva) {
	this.reserva = reserva;
}
public Descuento getDescuento() {
	return descuento;
}
public void setDescuento(Descuento descuento) {
	this.descuento = descuento;
}
 
}
