package Datos;
import Datos.usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Clases.Descuento;
import Clases.Estado;
import Clases.Estado_Butaca;
import Clases.Funcion;
import Clases.Pelicula;
import Clases.Reserva;
import Clases.Sala;
import Clases.TipoPelicula;
import Clases.TipoSala;
import Clases.Usuario;
public class Menu_Usuario {
 Scanner t=new Scanner(System.in);
 Conexion conn=new Conexion();
 private String [][] matrizResultado;
 private usuario u;
	public Menu_Usuario(usuario u) throws SQLException {
		this.u=u;
		System.out.println("Menu Usuario");
		System.out.println("1 Crear una reserva.");
		System.out.println("2 Modificar una reserva.");
		System.out.println("3 Observar mis reservas.");
		System.out.println("4 Ver el histórico de mis entradas."); 
		int op=t.nextInt();
		switch(op) {
		case 1:
			this.crearReserva();
			break;
		case 2:
			this.modificarReserva();
			break;
		case 3:
			this.observarReservas();
			break;
		case 4: 
			this.verHistorico();
			break;	
		}
		
	}
	
	public void crearReserva() throws SQLException {
		System.out.println("FUNCIONES DISPONIBLES");
		int id=0;
		int idSala=0;
		int idReserva=0;
	
		String sql="select IdFuncion,idPelicula,Fecha,Hora,idSala from funcion inner join pelicula \n"
				+ "using(IdPelicula) inner join sala using(IdSala);";
		ResultSet r=conn.devolverConsulta(sql);
		System.out.println("IdFuncion|\t idPelicula|\t Fecha|\t Hora|\t IdSala|\t Nombre|\t Genero|\t Director|\t Reparto|\t Sinopsis|\t Duracion|\t idTipo_Pelicula|\t Numero|\t Capacidad|\t");
		while(r.next()) {
			
			System.out.print(r.getInt("IdFuncion")+"\t");
			System.out.print(r.getInt("idPelicula")+"\t");
			System.out.print(r.getString("Fecha")+"\t"); 
			System.out.print(r.getString("Hora")+"\t");
			System.out.print(r.getInt("idSala")+"\t");
			System.out.print(r.getString("Nombre")+"\t");
			System.out.print(r.getString("Genero")+"\t");
			System.out.print(r.getString("Director")+"\t");
			System.out.print(r.getString("Reparto")+"\t");
			System.out.print(r.getString("Sinopsis")+"\t");
			System.out.print(r.getString("Duracion")+"\t");
			System.out.print(r.getInt("idTipo_Pelicula")+"\t");
			System.out.print(r.getInt("Numero")+"\t");
			System.out.print(r.getInt("Capacidad")+"\t");
		}
		System.out.println("seleccione el id de la Funcion elegida");
		id=t.nextInt();
		String add="insert into reserva values(null,"+u.getIdUsuario()+","+1+","+1+","+id+");";
		conn.EjecutarConsulta(add);
		System.out.println("Ingrese la cantidad de entradas que desea reservar");
		int cant=t.nextInt();
		r=conn.devolverConsulta("select Max(idReserva) as max from reserva where idUsuario="+u.getIdUsuario()+";");
		idReserva= r.getInt("max");
		r=conn.devolverConsulta("select idSala from funcion where idFuncion="+id+";");
		if(r.next()) {
			idSala=r.getInt("idSala");
		}
		for(int i=1;i<=cant;i++) 
		r=conn.devolverConsulta("select idButaca,Nombre,idSala,Modelo,idEstado_Butaca from butaca where idSala="+idSala+" inner join estado_butaca using (idEstado_Butaca) where  (`idUsuario`= " +id+")");
		System.out.println(" idButaca|\t Nombre|\t idSala|\t Modelo|\t idEstado_Butaca|\t Estado_Butaca|\t");
		while(r.next()) {
			System.out.print(r.getInt("idButaca")+"\t");
			System.out.print(r.getString("Nombre"));
			System.out.print(r.getInt("idSala"));
			System.out.print(r.getString("Modelo"));
			System.out.print(r.getInt("idEstado_Butaca"));
			System.out.print(r.getInt("Estado_Butaca"));
		}
		System.out.println("Ingrese el id del estado de la butaca");
       int idEstadob=t.nextInt();
   	System.out.println("Ingrese el id  de la butaca");
   	  int idButaca=t.nextInt();
		//cambio butaca a no disponible
		conn.EjecutarConsulta("UPDATE `cinemar`.`estado_butaca` SET `Estado_Butaca` = '1' WHERE (`idEstado_Butaca`="+idEstadob+");");
		conn.EjecutarConsulta("insert into reserva_x_butaca values("+idButaca+","+idReserva+")");
	}
	
	public void modificarReserva() {
		System.out.println("RESERVAS");
		String sql="select idReserva,Codigo,idUsuario,idEstado_Reserva,Fecha,Hora,idFuncion from reserva";
		ResultSet r=conn.devolverConsulta(sql);
		while(r.next()) {
			System.out.print(r.getInt("idReserva"));
			System.out.print(r.getString("Codigo"));
			System.out.print(r.getInt("idusuario"));
			System.out.print(r.getString("idEstado_Reserva"));
			System.out.print(r.getInt("Fecha"));
			System.out.print(r.getInt("Hora"));
			System.out.println(r.getInt("idFuncion"));
		}
		System.out.println("Ingrese el id de la funcion de la reserva que quiere modificar");
        int idf=t.nextInt();
        r=conn.devolverConsulta("select idFuncion,idPelicula,Fecha,Hora,idSala from funcion where (`idFuncion`="+idf+")");
		System.out.println("idFuncion|\t idPelicula|\t Fecha|\t Hora|\t idSala");
		while(r.next()) {
			System.out.print(r.getInt("idFuncion"));
			System.out.print(r.getString("idPelicula"));
			System.out.print(r.getString("Fecha"));
			System.out.print(r.getString("Hora"));
			System.out.print(r.getInt("idSala"));}
        System.out.println("Ingrese la fecha de la funcion en formato yyyy|mm|dd");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");     
        String f=t.next();
        System.out.println("Ingrese la hora de la funcion en formato hh:mm:ss");
        String h=t.next();
        LocalDate hoy=LocalDate.now();
       String hoy1=hoy.toString();
        Date date1=formatter.parse(f);
        Date date2=formatter.parse(hoy1);
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
       String hora1= formateador.format(hora1);
       Boolean bool1 = date1.after(date2);
       Boolean bool2 = date1.equals(date2);
       Boolean bool3=hora1.before(h);
        if(bool1||bool2&&bool3) {
        	crearReserva();
        	int id=0;
    		int idSala=0;
    		int idReserva=0;
    		System.out.println("Ingrese la cantidad de entradas que desea modificar");
    		int cant=t.nextInt();
    		r=conn.devolverConsulta("select Max(idReserva) as max from reserva where idUsuario="+u.getIdUsuario()+";");
    		idReserva= r.getInt("max");
    		r=conn.devolverConsulta("select idSala from funcion where idFuncion="+id+";");
    		if(r.next()) {
    			idSala=r.getInt("idSala");
    		}
    		for(int i=1;i<=cant;i++) 
    		r=conn.devolverConsulta("select idButaca,Nombre,idSala,Modelo,idEstado_Butaca from butaca where idSala="+idSala+" inner join estado_butaca using (idEstado_Butaca) where  (`idUsuario`= " +id+")");
    		System.out.println(" idButaca|\t Nombre|\t idSala|\t Modelo|\t idEstado_Butaca|\t Estado_Butaca|\t");
    		while(r.next()) {
    			System.out.print(r.getInt("idButaca")+"\t");
    			System.out.print(r.getString("Nombre"));
    			System.out.print(r.getInt("idSala"));
    			System.out.print(r.getString("Modelo"));
    			System.out.print(r.getInt("idEstado_Butaca"));
    			System.out.print(r.getInt("Estado_Butaca"));
    		}
    		System.out.println("Ingrese el id del estado de la butaca");
           int idEstadob=t.nextInt();
       	   System.out.println("Ingrese el id  de la butaca");
       	   int idButaca=t.nextInt();
    		//cambio butaca a  disponible
    		conn.EjecutarConsulta("UPDATE `cinemar`.`estado_butaca` SET `Estado_Butaca` = '0' WHERE (`idEstado_Butaca`="+idEstadob+");");
    		conn.EjecutarConsulta("delete from reserva_x_butaca values("+idButaca+","+idReserva+")");
    		
    	}
        else {
        	System.out.println("No puede modificar su reserva");
        }
		}
   

	public void observarReservas() throws SQLException {
	int id=u.getIdUsuario();
		System.out.println("RESERVAS ACTIVAS");	
		String sql="select idReserva,Codigo,idUsuario,idEStado_Reserva,Fecha,Hora,idFuncion from reserva where(`idUsuario`= " +id+") inner join estado_reserva using(idEstado_Reserva) where (`Estado`= 1)";
		ResultSet r=conn.devolverConsulta(sql);
		System.out.println("IdReserva|\t Codigo|\t idUsuario|\t idEstado_Reserva|\t Fecha|\t Hora|\t idFuncion|\t Estado|\t");			
		while(r.next()) {
			
			System.out.print(r.getInt("IdReserva")+"\t");
			System.out.print(r.getString("Codigo")+"\t");
			System.out.print(r.getInt("idUsuario")+"\t");
			System.out.print(r.getInt("idEstado_Reserva")+"\t");
			System.out.print(r.getString("Fecha")+"\t");
			System.out.print(r.getString("Hora")+"\t");
			System.out.print(r.getString("idFuncion")+"\t");
			
		}
	}
	public void verHistorico() throws SQLException {
		int id=u.getIdUsuario();
			System.out.println("MIS ENTRADAS");
			String sql="select idReserva,Codigo,idUsuario,idEStado_Reserva,Fecha,Hora,idFuncion from reserva where(`idUsuario`= " +id+") inner join estado_reserva using(idEstado_Reserva) ";
			ResultSet r=conn.devolverConsulta(sql);
			System.out.println("IdReserva|\t Codigo|\t idUsuario|\t idEstado_Reserva|\t Fecha|\t Hora|\t idFuncion|\t Estado|\t");			
			while(r.next()) {
				
				System.out.print(r.getInt("IdReserva")+"\t");
				System.out.print(r.getString("Codigo")+"\t");
				System.out.print(r.getInt("idUsuario")+"\t");
				System.out.print(r.getInt("idEstado_Reserva")+"\t");
				System.out.print(r.getString("Fecha")+"\t");
				System.out.print(r.getString("Hora")+"\t");
				System.out.print(r.getString("idFuncion")+"\t");
				
			}
			
		}

}