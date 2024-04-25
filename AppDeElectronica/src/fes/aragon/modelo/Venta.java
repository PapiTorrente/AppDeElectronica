package fes.aragon.modelo;

public class Venta {
	private int Id_Venta;
	private int Id_Producto;
	private int Precio;
	private int Cantidad;
	private String Forma_Pago;
	private int Id_Cliente;
	private String Fecha_Venta;
	
	public Venta(int id_Producto, int precio, int cantidad, String forma_Pago, int id_Cliente, String fecha_Venta) {
		super();
		Id_Producto = id_Producto;
		Precio = precio;
		Cantidad = cantidad;
		Forma_Pago = forma_Pago;
		Id_Cliente = id_Cliente;
		Fecha_Venta = fecha_Venta;
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
	public String getForma_Pago() {
		return Forma_Pago;
	}
	public void setForma_Pago(String forma_Pago) {
		Forma_Pago = forma_Pago;
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
		return "Venta [Id_Venta=" + Id_Venta + ", Id_Producto=" + Id_Producto + ", Precio=" + Precio + ", Cantidad="
				+ Cantidad + ", Forma_Pago=" + Forma_Pago + ", Id_Cliente=" + Id_Cliente + ", Fecha_Venta="
				+ Fecha_Venta + "]";
	}
	
	
}
