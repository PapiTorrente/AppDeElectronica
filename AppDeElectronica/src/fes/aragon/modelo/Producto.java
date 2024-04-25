package fes.aragon.modelo;

public class Producto {
	private int Id_Producto;
	private String Nombre;
	private int Precio;
	private String Modelo;
	private int Cant_Disp;
	private int Id_Proveedor;
	
	public Producto(String Nombre, int Precio, String Modelo, int Cant_Disp, int Id_Proveedor) {
		this.Nombre = Nombre;
		this.Precio = Precio;
		this.Modelo = Modelo;
		this.Cant_Disp = Cant_Disp;
		this.Id_Proveedor = Id_Proveedor;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public int getCant_Disp() {
		return Cant_Disp;
	}

	public void setCant_Disp(int cant_Disp) {
		Cant_Disp = cant_Disp;
	}

	public int getId_Proveedor() {
		return Id_Proveedor;
	}

	public void setId_Proveedor(int id_Proveedor) {
		Id_Proveedor = id_Proveedor;
	}

	@Override
	public String toString() {
		return "Producto [Id_Producto=" + Id_Producto + ", Nombre=" + Nombre + ", Precio=" + Precio + ", Modelo="
				+ Modelo + ", Cant_Disp=" + Cant_Disp + ", Id_Proveedor=" + Id_Proveedor + "]";
	}
	
	
}
