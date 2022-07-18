package Datos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Principal {
   static Scanner t=new Scanner(System.in);
   static Conexion conn;
   public Principal() {
   }
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
	conn=new Conexion();
	System.out.println("MENU");
	System.out.println("1 Registrarse");
	System.out.println("2 Iniciar sesion");
	int op=t.nextInt();
	switch(op) {
	case 1:
		RegistrarUsuario();
		break;
	default:
		IniciarSesion();
	}	
	}
	public static void RegistrarUsuario() throws SQLException {
		System.out.println("Registrarse");
		System.out.println("Ingrese su nombre");
		String nombre=t.next();
		System.out.println("Ingrese su Apellido");
		String apellido=t.next();
		System.out.println("Ingrese su Dni");
		String dni=t.next();
		System.out.println("Ingrese su email");
		String email=t.next();
		System.out.println("Ingrese su Contraseña");
		String pass=t.next();
		System.out.println("Ingrese nuevamente su Contraseña");
		String passv=t.next();
		System.out.println("Ingrese su fecha de nacimiento");
		String fecha=t.next();
		
		if(nombre.isEmpty()==false&&apellido.isEmpty()&&email.isEmpty()&&dni.isEmpty()&& pass.equals(passv)) {
			ArrayList<String> listValores=new ArrayList<>();
			listValores.add(nombre);
			listValores.add(apellido);
			listValores.add(email);
			listValores.add(dni);
			listValores.add(pass);
			listValores.add(fecha);
			listValores.add("0");
			listValores.add("2");
			listValores.add("0");
			conn.AgregarUsuario(listValores);
		}
	}

	public static void IniciarSesion() throws SQLException {
		
		System.out.println("Ingrese el correo");
		String email=t.next();
		System.out.println("Ingrese contraseña");
		String pass=t.next();
		Login login=new Login(email,pass);
		ResultSet r=login.verificarIngreso();
		if(r.next()) {
			System.out.println("Ingresando..");
			if(r.getInt("idRol")==1) {
				System.out.println("Bienvenido: \t"+r.getString("Nombre").concat("\t").concat(r.getString("Apellido")));					
				usuario u=new usuario(r.getInt("idUsuario"),r.getString("Nombre"),r.getString("Apellido"),
						r.getString("dni"),r.getString("email"),r.getString("pass"),r.getString("fechadenacimiento"),r.getInt("Descuento"),r.getInt("idRol"),
						r.getInt("idDomicilio"));
			
				Menu_Admin menuA= new Menu_Admin(u);
			}else {
				System.out.println("Cliente");
				usuario u=new usuario(r.getInt("idUsuario"),r.getString("Nombre"),r.getString("Apellido"),
						r.getString("dni"),r.getString("email"),r.getString("pass"),r.getString("fechadenacimiento"),r.getInt("Descuento"),r.getInt("idRol"),
						r.getInt("idDomicilio"));
				Menu_Usuario menuU= new Menu_Usuario(u);
			}
		}else {
			
			System.out.print("Usuario y/o contraseña incorrecto");
		}
		
	}

}

	
	



	
	
	
	
	
	
	
	
	
	
    