package fes.aragon.mariadb;

import fes.aragon.modelo.Cliente;
import fes.aragon.modelo.Devolucion;
import fes.aragon.modelo.Envio;
import fes.aragon.modelo.Producto;
import fes.aragon.modelo.Proveedor;
import fes.aragon.modelo.Venta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Conexion {
	private String url="jdbc:mariadb://127.0.0.1:3306/ventas?serverTimeZone=UTC";
	private String usuario="root";
	private String clave="112358";
	private Connection conexion;
	
	public Conexion() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		conexion=DriverManager.getConnection(url, usuario, clave);
		
	}

	public ObservableList<Producto> obtenerProductos() throws SQLException {
		String query="select * from productos";
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery(query);
		ObservableList<Producto> datos = FXCollections.observableArrayList();
		while (rs.next()) {
			Producto p = new Producto();
			p.setId_Producto(rs.getInt(1));
			p.setNombre(rs.getString(2));
			p.setPrecio(rs.getInt(3));
			p.setModelo(rs.getString(4));
			p.setCant_Disp(rs.getInt(5));
			p.setId_Proveedor(rs.getInt(6));
			datos.add(p);
		}
		return datos;
	}
	
	public ObservableList<Cliente> obtenerClientes() throws SQLException {
		String query="select * from clientes";
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery(query);
		ObservableList<Cliente> datos = FXCollections.observableArrayList();
		while (rs.next()) {
			Cliente c = new Cliente();
			c.setId_Cliente(rs.getInt(1));
			c.setNombre(rs.getString(2));
			c.setAp_Paterno(rs.getString(3));
			c.setAp_Materno(rs.getString(4));
			c.setDomicilio(rs.getString(5));
			c.setTelefono(rs.getString(6));
			c.setCorreo(rs.getString(7));
			c.setEs_Miembro(rs.getBoolean(8));
			datos.add(c);
		}
		return datos;
	}
	
	public ObservableList<Venta> obtenerVentas() throws SQLException {
		String query="select * from ventas";
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery(query);
		ObservableList<Venta> datos = FXCollections.observableArrayList();
		while (rs.next()) {
			Venta v = new Venta();
			v.setId_Venta(rs.getInt(1));
			v.setId_Producto(rs.getInt(2));
			v.setPrecio(rs.getInt(3));
			v.setCantidad(rs.getInt(4));
			v.setForma_Pago(rs.getString(5));
			v.setId_Cliente(rs.getInt(6));
			v.setFecha_Venta(rs.getString(7));
			v.setNombre_Producto(rs.getString(8));
			datos.add(v);
		}
		return datos;
	}
	
	public ObservableList<Proveedor> obtenerProveedores() throws SQLException {
		String query="select * from proveedores";
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery(query);
		ObservableList<Proveedor> datos = FXCollections.observableArrayList();
		while (rs.next()) {
			Proveedor p = new Proveedor();
			p.setNombre(rs.getString(1));
			p.setAp_Paterno(rs.getString(2));
			p.setAp_Materno(rs.getString(3));
			p.setTelefono(rs.getString(4));
			p.setCorreo(rs.getString(5));
			datos.add(p);
		}
		return datos;
	}
	
	public void insertarVenta(Venta venta) throws SQLException {
		String query="insert into ventas values (null,?,?,?,?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, venta.getId_Producto());
		ps.setInt(2, venta.getPrecio());
		ps.setInt(3, venta.getCantidad());
		ps.setString(4, venta.getForma_Pago());
		ps.setInt(5, venta.getId_Cliente());
		ps.setString(6, venta.getFecha_Venta());
		ps.setString(7, venta.getNombre_Producto());
		ps.execute();
	}
	
	public void insertarEnvio(Envio envio) throws SQLException {
		String query="insert into envios values (null,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, envio.getId_Venta());
		ps.setInt(2, envio.getCosto_Envio());
		ps.setString(3, envio.getFecha_Envio());
		ps.execute();
	}
	
	public void insertarCliente(Cliente cliente) throws SQLException {
		String query="insert into clientes values (null,?,?,?,?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cliente.getNombre());
		ps.setString(2, cliente.getAp_Paterno());
		ps.setString(3, cliente.getAp_Materno());
		ps.setString(4, cliente.getDomicilio());
		ps.setString(5, cliente.getTelefono());
		ps.setString(6, cliente.getCorreo());
		ps.setBoolean(7, cliente.isEs_Miembro());
		ps.execute();
	}
	
	public void insertarProveedor(Proveedor proveedor) throws SQLException {
		String query="insert into proveedores values (null,?,?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, proveedor.getNombre());
		ps.setString(2, proveedor.getAp_Paterno());
		ps.setString(3, proveedor.getAp_Materno());
		ps.setString(4, proveedor.getTelefono());
		ps.setString(5, proveedor.getCorreo());
		ps.execute();
	}
	
	public void insertarDevolucion(Devolucion devolucion) throws SQLException {
		String query="insert into devoluciones values (null,?,?,?,?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, devolucion.getId_Producto());
		ps.setInt(2, devolucion.getPrecio());
		ps.setInt(3, devolucion.getCantidad());
		ps.setString(4, devolucion.getForma_Devol());
		ps.setString(5, devolucion.getMotivo());
		ps.setInt(6, devolucion.getId_Cliente());
		ps.setString(7, devolucion.getForma_Devol());
		ps.execute();
		ps.close();
	}

}
