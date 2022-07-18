package Datos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Clases.Domicilio;
import Clases.Estado;
import Clases.Funcion;
import Clases.Pelicula;
import Clases.Rol;
import Clases.Sala;
import Clases.TipoPelicula;
import Clases.Usuario;
public class Menu_Admin  {
	Scanner t=new Scanner(System.in);
	Conexion conn=new Conexion();
	private String[][] matrizResultado;
	public Menu_Admin(usuario u) throws SQLException {
		System.out.println("Menu Administrador");
		System.out.println("1 Ver listado Salas");
		System.out.println("2 Crear una sala con la película.");
		System.out.println("3 Modificar una sala");
		System.out.println("4 Eliminar una sala.");
		System.out.println("5 Ver reservas de todos los clientes.");
		System.out.println("6 Ver reservas de un cliente en particular.");
		System.out.println("7 Modificar descuentos.");
		int op=t.nextInt();
		switch(op) {
		case 1:
			this.verSalas();
			break;
		case 2:
			this.crearFuncion();
			break;
		case 3:
			this.modificarSala();
			break;
		case 4: 
			this.eliminarSala();
			break;
		case 5: 
			this.verReservastodoslosclientes();
			break;
		case 6:
			this.verReservasclienteparticular();
			break;
		case 7:
			this.ModificarDescuentos();
			break;
		}
		
	}
	
	public void eliminarSala() throws SQLException {
		int id=0;
		int confirmacion=0;
		String sql="select idFuncion,idPelicula,Fecha,Hora,idSala from funcion  inner\n"
				+ "join pelicula using(idPelicula);";
		
		ResultSet r=conn.devolverConsulta(sql);
		System.out.println("idFuncion|\t idPelicula|\t Fecha|\t Hora|\t idSala|\t Nombre|\t Genero|\t Director|\t Reparto|\t Sinopsis|\t Duracion|\t idTipo_Pelicula");
	
		while(r.next()) {
			
			System.out.println(r.getInt("idFuncion")+"\t");
			System.out.println(r.getString("idPelicula")+"\t");
			System.out.println(r.getString("Fecha")+"\t");
			System.out.println(r.getString("Hora")+"\t");
			System.out.println(r.getInt("idSala")+"\t");
			System.out.println(r.getString("Nombre")+"\t");
			System.out.println(r.getString("Genero")+"\t");
			System.out.println(r.getString("Director")+"\t");
			System.out.println(r.getString("Reparto")+"\t");
			System.out.println(r.getString("Sinopsis")+"\t");
			System.out.println(r.getString("Duracion")+"\t");
			System.out.println(r.getString("idTipo_Pelicula")+"\t");
			
		}
		System.out.println("Seleccione el id de la funcion a eliminar");
		id=t.nextInt();
		System.out.println("Esta seguro de eliminar 1-SI 0-NO");
		confirmacion=t.nextInt();
		if(confirmacion==1) {
			sql="delete from funcion where idFuncion"+id+";";
			conn.EjecutarConsulta(sql);
			System.out.print("Funcion eliminada con exito");
		}
	}
	public void modificarSala() throws SQLException {
		
		int id=0;
		int idPelicula=0;
		String sql="select idFuncion,idPelicula,Fecha,Hora,idSala from funcion inner\n"
				+ "join Peliculas using(idPelicula);";
		
		ResultSet r=conn.devolverConsulta(sql);
		System.out.println("idFuncion|\t idPelicula|\t Fecha|\t Hora|\t idSala|\t Nombre|\t Genero|\t Director|\t Reparto|\t Sinopsis|\t Duracion|\t idTipo_Pelicula");
		
		while(r.next()) {
			System.out.println(r.getInt("idFuncion")+"\t");
			System.out.println(r.getString("idPelicula")+"\t");
			System.out.println(r.getString("Fecha")+"\t");
			System.out.println(r.getString("Hora")+"\t");
			System.out.println(r.getInt("idSala")+"\t");
			System.out.println(r.getString("Nombre")+"\t");
			System.out.println(r.getString("Genero")+"\t");
			System.out.println(r.getString("Director")+"\t");
			System.out.println(r.getString("Reparto")+"\t");
			System.out.println(r.getString("Sinopsis")+"\t");
			System.out.println(r.getString("Duracion")+"\t");
			System.out.println(r.getString("idTipo_Pelicula")+"\t");
			
		}
		
		System.out.println("Seleccione el id de la funcion a modificar");
		id=t.nextInt();
		
		System.out.print("Seleccione la pelicula nueva");
		
		r=conn.devolverConsulta("select * from pelicula;");
		System.out.println("idPelicula|\t Nombre|\t Genero|\t Director|\t Reparto|\t Sinopsis|\tDuracion |\t idTipo_Pelicula");
		
		while(r.next()) {
			
			System.out.print(r.getInt("idPelicula")+"\n");
			System.out.print(r.getString("Nombre")+"\n");
			System.out.print(r.getString("Genero")+"\n");
			System.out.print(r.getString("Director")+"\n");
			System.out.print(r.getString("Reparto")+"\n");
			System.out.print(r.getString("Sinopsis")+"\n");
			System.out.print(r.getString("Duracion")+"\n");
			System.out.print(r.getString("idTipo_Pelicula")+"\n");
			
		}
		System.out.println("Ingrese el id de la nueva Pelicula");
		idPelicula=t.nextInt();
		
		
		sql="UPDATE `cinemar`.`funcion` SET `idPelicula` = "+idPelicula +" WHERE (`idFuncion` = "+id+");";
		conn.EjecutarConsulta(sql);
		
		System.out.print("Funcion actualizada");
		
	}
	public void verReservasclienteparticular() throws SQLException{
	int id=0;
	System.out.println("Ingrese el id del usuario");
	id=t.nextInt();
	ResultSet r=conn.devolverConsulta("select from reserva where (`idUsuario`= " +id+")  inner join estado_reserva using(idEstado_Reserva) WHERE (`Estado`= 1);" );
	System.out.println("idReserva|\t Codigo|\t Usuario|\t Estado|\t Fecha|\t Hora|\t idFuncion|\t");
	System.out.print(r.getString("idUsuario")+"\t");
	while(r.next()) {
		System.out.print(r.getInt("idReserva")+"\t");
		System.out.print(r.getString("Codigo")+"\t");
		System.out.print(r.getString("idEstado_Reserva")+"\t");
		System.out.print(r.getString("Fecha")+"\t");
		System.out.print(r.getString("Hora")+"\t");
		System.out.print(r.getString("idFuncion")+"\t");
		
	}
	}
	public void verReservastodoslosclientes() throws SQLException{
	ResultSet r =conn.devolverConsulta("select idReserva,Codigo,Usuario,idEstado_Reserva,Fecha,Hora,idFuncion from reserva inner join estado_reserva using (idEstado_Reserva) WHERE Estado=1 ");
	while(r.next()) {
		System.out.print(r.getInt("idReserva")+"\t");
		System.out.print(r.getString("Codigo")+"\t");
		System.out.print(r.getString("idUsuario")+"\t");
		System.out.print(r.getString("idEstado_Reserva")+"\t");
		System.out.print(r.getString("Fecha")+"\t");
		System.out.print(r.getString("Hora")+"\t");
		System.out.print(r.getString("idFuncion")+"\t");

	}
	}
	
	
	public void crearFuncion() throws SQLException {
		String fecha=null;
		int idSala=0;
		int idPelicula=0;
		String hora=null;
		System.out.println("Esta por crear una cartelera");
		System.out.println("Seleccione la sala");
		ResultSet r=conn.devolverConsulta("select idSala,Numero,Capacidad,idTipo_Sala from sala inner join tipo_sala using(idTipo_Sala));");
		System.out.println("idSala|\t Numero|\t Capacidad|\t idTipo_Sala\t|\t Formato\t");
		while(r.next()) {
			System.out.print(r.getInt("idSala")+"\t");
			System.out.print(r.getString("Numero")+"\t");
			System.out.print(r.getString("Capacidad")+"\t");
			System.out.print(r.getString("idTipo_Sala")+"\t");
			System.out.print(r.getString("Formato")+"\t");
			System.out.print(r.getString("\n"));
		}
		System.out.println("Ingrese el id de la sala");
		idSala=t.nextInt();
		System.out.println("Seleccione la pelicula");
		r=conn.devolverConsulta("select idPelicula,Nombre,Genero,Director,Reparto,Sinopsis,Duracion,idTipo_Pelicula from pelicula inner join tipo_pelicula using(idTipo_Pelicula);");
		System.out.println("idPelicula|\t Nombre|\t Genero|\t Director|\t Reparto|\t Sinopsis|\t Duracion|\t idTipo_Pelicula|\t Formato|\t Idioma|\t Subtitulada");
		while(r.next()) {
			System.out.print(r.getInt("idPelicula")+"\t");
			System.out.print(r.getString("Nombre")+"\t");
			System.out.print(r.getString("Genero")+"\t");
			System.out.print(r.getString("Director")+"\t");
			System.out.print(r.getString("Reparto")+"\t");
			System.out.print(r.getString("Sinopsis")+"\t");
			System.out.print(r.getString("Duracion")+"\t");
			System.out.print(r.getString("idTipo_Pelicula")+"\t");
			System.out.print(r.getString("Formato")+"\t");
			System.out.print(r.getString("Idioma")+"\t");
			System.out.print(r.getString("Subtitulada")+"\t");
		}

		System.out.println("selecciona el id de la pelicula");
		idPelicula=t.nextInt();
		System.out.println("Ingrese la fecha");
		fecha=t.next();
		System.out.println("Ingrese el horario");
		hora=t.next();
		String sql="insert into Funcion values (null,"+ idPelicula +"," + fecha + "," + hora + ","+idSala+");";
		conn.EjecutarConsulta(sql);
		System.out.println("Funcion creada con exito");
		
	}
	
	public void verSalas() throws SQLException {
		String sql="select * from sala inner join tipo_sala using(idTipo_Sala);";
		ResultSet r=conn.devolverConsulta(sql);
		System.out.println("idSala| \t Numero|\t Capacidad|\t Tipo|\t Formato");
		while(r.next()) {
			System.out.println(r.getInt("idSala")+"\t"+r.getString("Numero")+"\t"+
			r.getInt("Capacidad")+"\t"+r.getString("idTipo_Sala")+"\t"+r.getString("Formato"));
		}
	}
	public void ModificarDescuentos() throws SQLException {
		int id=0;
		int porcentaje=0;
		int op=0;
		do {
		String sql="select idDescuento,Dias,Porcentaje from descuento";
		ResultSet r=conn.devolverConsulta(sql);	
		System.out.println("idDescuento|\t Dias|\t Porcentaje");
        while(r.next()) {
			System.out.print(r.getInt("idDescuento")+"\n");
			System.out.print(r.getString("Dias")+"\n");
			System.out.print(r.getString("Porcentaje")+"\n");
        }
        System.out.println("Ingrese el id del grupo de dias al cual quiere modificarle el porcentaje de descuento");
        id=t.nextInt();
        sql="UPDATE `cinemar`.`descuento` SET `Porcentaje` = "+porcentaje+" WHERE (`idDescuento` = "+id+");";
		conn.EjecutarConsulta(sql);
		System.out.print("Descuento actualizado");
        System.out.println("¿Desea modificar otro descuento? 0-SI 1-NO");
        op=t.nextInt();
		}while(op==0);
	}
}
		
		
		
		
		
		
		
