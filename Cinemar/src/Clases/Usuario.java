package Clases;
public class Usuario {
 private int idUsuario;
 private String nombre;
 private String apellido;
 private int dni;
 private String email;
 private String fechanacimiento;
 private Rol rol;
 private String usuario;
 private String password;
 private int descuento;
 private Domicilio domicilio;
 public Usuario(int idUsuario,String nombre,String apellido,int dni,String email,String fechanacimiento,Rol rol,String usuario,String password,int descuento,Domicilio domicilio) {
	super();
	this.setIdUsuario(idUsuario);
	this.setNombre(nombre);
	this.setApellido(apellido);
	this.setDni(dni);
	this.setEmail(email);
	this.setFechanacimiento(fechanacimiento);
	this.setRol(rol);
	this.setUsuario(usuario);
	this.setPassword(password);
	this.setDescuento(descuento);
	this.setDomicilio(domicilio);
 }
public Usuario(int int1, String string, String string2, String string3, String string4, String string5, String string6,
		int int2, int int3, int int4) {
	// TODO Auto-generated constructor stub
}
public int getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getDni() {
	return dni;
}
public void setDni(int dni) {
	this.dni = dni;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Rol getRol() {
	return rol;
}
public void setRol(Rol rol) {
	this.rol = rol;
}
public 	String  getFechanacimiento() {
	return fechanacimiento;
}
public void setFechanacimiento(String fechanacimiento) {
	this.fechanacimiento = fechanacimiento;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getDescuento() {
	return descuento;
}
public void setDescuento(int descuento) {
	this.descuento = descuento;
}
public Domicilio getDomicilio() {
	return domicilio;
}
public void setDomicilio(Domicilio domicilio) {
	this.domicilio = domicilio;
}
}
	