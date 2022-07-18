package Clases;

public class Reservaxbutacas {
 private int IdReserva;
 private int IdButaca;
 public Reservaxbutacas(int IdReserva,int IdButaca) {
	 super();
	 this.setIdReserva(IdReserva);
	 this.setIdButaca(IdButaca);

 }
public int getIdReserva() {
	return IdReserva;
}
public void setIdReserva(int idReserva) {
	IdReserva = idReserva;
}
public int getIdButaca() {
	return IdButaca;
}
public void setIdButaca(int idButaca) {
	IdButaca = idButaca;
}

}
