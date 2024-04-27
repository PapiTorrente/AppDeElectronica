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
	
	public Cliente() {
		
	}

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

	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public String getAp_Paterno() {
		return Ap_Paterno;
	}



	public void setAp_Paterno(String ap_Paterno) {
		Ap_Paterno = ap_Paterno;
	}



	public String getAp_Materno() {
		return Ap_Materno;
	}



	public void setAp_Materno(String ap_Materno) {
		Ap_Materno = ap_Materno;
	}



	public String getDomicilio() {
		return Domicilio;
	}



	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}



	public String getTelefono() {
		return Telefono;
	}



	public void setTelefono(String telefono) {
		Telefono = telefono;
	}



	public String getCorreo() {
		return Correo;
	}



	public void setCorreo(String correo) {
		Correo = correo;
	}



	public boolean isEs_Miembro() {
		return Es_Miembro;
	}



	public void setEs_Miembro(boolean es_Miembro) {
		Es_Miembro = es_Miembro;
	}

	public int getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}

	@Override
	public String toString() {
		return this.Correo;
	}
	
	
}
