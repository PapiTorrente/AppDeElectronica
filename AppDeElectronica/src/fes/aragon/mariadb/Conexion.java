package fes.aragon.mariadb;

import fes.aragon.modelo.Cliente;
import fes.aragon.modelo.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
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

}
