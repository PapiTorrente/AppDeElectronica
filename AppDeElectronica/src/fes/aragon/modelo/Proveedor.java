package fes.aragon.modelo;

public class Proveedor {
	private int Id_Proveedor;
	private String nombreEmpresa;
	private String Nombre;
	private String Ap_Paterno;
	private String Ap_Materno;
	private String Telefono;
	private String Correo;
	
	public Proveedor() {
		super();
	}

	public Proveedor(String Nombre, String Ap_Paterno, String Ap_Materno, String Telefono, String Correo) {
		this.Nombre = Nombre;
		this.Ap_Paterno = Ap_Paterno;
		this.Ap_Materno = Ap_Materno;
		this.Telefono = Telefono;
		this.Correo = Correo;
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

	public int getId_Proveedor() {
		return Id_Proveedor;
	}

	public void setId_Proveedor(int id_Proveedor) {
		Id_Proveedor = id_Proveedor;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	@Override
	public String toString() {
		return this.Id_Proveedor + " - " + this.Nombre;
	}
	
	
}
