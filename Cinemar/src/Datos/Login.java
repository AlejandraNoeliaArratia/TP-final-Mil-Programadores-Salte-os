package Datos;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	private String email;
	
	private String pass;

	private Conexion conn;
	public String getEmail() {
		return email;
	}

	public void setCorreo(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Login() {
		
	}
	public Login(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
		this.conn=new Conexion();
	}
	
	public ResultSet Ingresar() throws SQLException {
		
		String sql="select * from usuario where email="+"'"+this.email+"'"+" and pass="+"'"+this.pass+"'"+";";
		
		ResultSet r=this.conn.devolverConsulta(sql);
		
		return r;
		
	}
     public ResultSet verificarIngreso() throws SQLException {
		
		String sql="select * from usuario where email="+"'"+this.email+"'"+ " and pass="+"'"+this.pass+"'"+";";
		
		ResultSet rs=conn.devolverConsulta(sql);
		
		return rs;
	}
	
	
	
}