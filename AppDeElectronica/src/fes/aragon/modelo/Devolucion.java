package fes.aragon.modelo;

public class Devolucion {
	private int Id_Devol;
	private int Id_Producto;
	private int Precio;
	private int Cantidad;
	private String Forma_Devol;
	private String Motivo;
	private int Id_Cliente;
	private String Fecha_Venta;
	
	public Devolucion() {
		super();
	}

	public Devolucion(int id_Producto, int precio, int cantidad, String forma_Devol, String motivo, int id_Cliente,
			String fecha_Venta) {
		super();
		Id_Producto = id_Producto;
		Precio = precio;
		Cantidad = cantidad;
		Forma_Devol = forma_Devol;
		Motivo = motivo;
		Id_Cliente = id_Cliente;
		Fecha_Venta = fecha_Venta;
	}

	public int getId_Devol() {
		return Id_Devol;
	}

	public void setId_Devol(int id_Devol) {
		Id_Devol = id_Devol;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public String getForma_Devol() {
		return Forma_Devol;
	}

	public void setForma_Devol(String forma_Devol) {
		Forma_Devol = forma_Devol;
	}

	public String getMotivo() {
		return Motivo;
	}

	public void setMotivo(String motivo) {
		Motivo = motivo;
	}

	public int getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}

	public String getFecha_Venta() {
		return Fecha_Venta;
	}

	public void setFecha_Venta(String fecha_Venta) {
		Fecha_Venta = fecha_Venta;
	}

	@Override
	public String toString() {
		return "Devolucion [Id_Devol=" + Id_Devol + ", Id_Producto=" + Id_Producto + ", Precio=" + Precio
				+ ", Cantidad=" + Cantidad + ", Forma_Devol=" + Forma_Devol + ", Motivo=" + Motivo + ", Id_Cliente="
				+ Id_Cliente + ", Fecha_Venta=" + Fecha_Venta + "]";
	}
	
	
}
