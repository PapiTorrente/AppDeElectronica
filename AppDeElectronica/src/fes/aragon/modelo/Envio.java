package fes.aragon.modelo;

public class Envio {
	private int Id_Envio;
	private int Id_Venta;
	private int Costo_Envio;
	private String Fecha_Envio;
	
	public Envio(int Id_Envio, int Id_Venta, int Costo_Envio, String Fecha_Envio) {
		this.Id_Envio = Id_Envio;
		this.Id_Venta = Id_Venta;
		this.Costo_Envio = Costo_Envio;
		this.Fecha_Envio = Fecha_Envio;
	}

	public int getId_Envio() {
		return Id_Envio;
	}

	public void setId_Envio(int id_Envio) {
		Id_Envio = id_Envio;
	}

	public int getId_Venta() {
		return Id_Venta;
	}

	public void setId_Venta(int id_Venta) {
		Id_Venta = id_Venta;
	}

	public int getCosto_Envio() {
		return Costo_Envio;
	}

	public void setCosto_Envio(int costo_Envio) {
		Costo_Envio = costo_Envio;
	}

	public String getFecha_Envio() {
		return Fecha_Envio;
	}

	public void setFecha_Envio(String fecha_Envio) {
		Fecha_Envio = fecha_Envio;
	}

	@Override
	public String toString() {
		return "Envio [Id_Envio=" + Id_Envio + ", Id_Venta=" + Id_Venta + ", Costo_Envio=" + Costo_Envio
				+ ", Fecha_Envio=" + Fecha_Envio + "]";
	}
	
	
}
