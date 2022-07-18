package Datos;

public class usuario {
	private int idUsuario;
	private String Nombre;
	private String Apellido;
	private String dni;
	private String email;
	private String pass;
	private String fechadenacimiento;
	private int idRol;
	private int idDomicilio;
	private int Descuento;
	public usuario() {		
	}
	
	public usuario(int idUsuario, String Nombre, String Apellido, String dni, String email, String pass,String fechadenacimiento, int Descuento,
			int idRol, int idDomicilio) {
		super();
		this.idUsuario = idUsuario;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.dni = dni;
		this.email = email;
		this.pass = pass;
		this.Descuento = Descuento;
		this.idRol = idRol;
		this.idDomicilio = idDomicilio;
		this.setFechadenacimiento(fechadenacimiento);
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public  int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}
	public int getDescuento() {
		return Descuento;
	}
	public void setDescuento(int Descuento) {
		this.Descuento = Descuento;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	public String getFechadenacimiento() {
		return fechadenacimiento;
	}
	public void setFechadenacimiento(String fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}
}



