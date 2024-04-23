package fes.aragon.modelo;

public class Cliente {
	private int Id_Cliente;
	private String Nombre;
	private String Ap_Paterno;
	private String Ap_Materno;
	private String Domicilio;
	private String Telefono;
	private String Correo;
	private boolean Es_Miembro;
	
	public Cliente(String Nombre, String Ap_Paterno, String Ap_Materno, String Domicilio, String Telefono, String Correo, boolean Es_Miembro) {
		super();
		
		this.Nombre = Nombre;
		this.Ap_Paterno = Ap_Paterno;
		this.Ap_Materno = Ap_Materno;
		this.Domicilio = Domicilio;
		this.Telefono = Telefono;
		this.Correo = Correo;
		this.Es_Miembro = Es_Miembro;
	}
	
	/* GETTERS */
	public int getID_Cliente() {
		return Id_Cliente;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getAp_Paterno() {
		return Ap_Paterno;
	}
	public String getAp_Materno() {
		return Ap_Materno;
	}
	public String getDomicilio() {
		return Domicilio;
	}
	public String getTelefono() {
		return Telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public boolean Es_Miembro() {
		return Es_Miembro;
	}
	
	/* SETTERS */
	public void setID_Cliente(int Id_Cliente) {
		this.Id_Cliente = Id_Cliente;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public void setAp_Paterno(String Ap_Paterno) {
		this.Ap_Paterno = Ap_Paterno;
	}
	public void setAp_Materno(String Ap_Materno) {
		this.Ap_Materno = Ap_Materno;
	}
	public void setDomicilio(String Domicilio) {
		this.Domicilio = Domicilio;
	}
	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}
	public void setCorreo(String Correo) {
		this.Correo = Correo;
	}
	public void setEs_Miembro(boolean Es_Miembro) {
		this.Es_Miembro = Es_Miembro;
	}

	@Override
	public String toString() {
		return "Cliente [Id_Cliente=" + Id_Cliente + ", Nombre=" + Nombre + ", Ap_Paterno=" + Ap_Paterno
				+ ", Ap_Materno=" + Ap_Materno + ", Domicilio=" + Domicilio + ", Telefono=" + Telefono + ", Correo="
				+ Correo + ", Es_Miembro=" + Es_Miembro + "]";
	}
	
	
}
