package fes.aragon.modelo;

public class Venta {
	private int Id_Venta;
	private int Id_Producto;
	private int Precio;
	private int Cantidad;
	private String Forma_Pago;
	private int Id_Cliente;
	private String Fecha_Venta;
	private	String Nombre_Producto;
	
	public Venta() {
		super();
	}
	public Venta(int id_Producto, int precio, int cantidad, String forma_Pago, int id_Cliente, String fecha_Venta) {
		super();
		Id_Producto = id_Producto;
		Precio = precio;
		Cantidad = cantidad;
		Forma_Pago = forma_Pago;
		Id_Cliente = id_Cliente;
		Fecha_Venta = fecha_Venta;
	}
	public String getNombre_Producto() {
		return Nombre_Producto;
	}
	public void setNombre_Producto(String nombre_Producto) {
		Nombre_Producto = nombre_Producto;
	}
	public int getId_Cliente() {
		return Id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}
	public int getId_Producto() {
		return Id_Producto;
	}
	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}
	public int getId_Venta() {
		return Id_Venta;
	}
	public void setId_Venta(int id_Venta) {
		Id_Venta = id_Venta;
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
	public String getFecha_Venta() {
		return Fecha_Venta;
	}
	public void setFecha_Venta(String fecha_Venta) {
		Fecha_Venta = fecha_Venta;
	}
	@Override
	public String toString() {
		return this.Nombre_Producto + " - " + this.Cantidad;
	}
	
	
}
