package fes.aragon.mariadb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import fes.aragon.modelo.Pelicula;

public class Conexion {
	private String url="jdbc:mariadb://127.0.0.1:3306/videoclub?serverTimeZone=UTC";
	private String usuario="prog1";
	private String clave="234";
	private Connection conexion;
	
	
	
	public Conexion() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		conexion=DriverManager.getConnection(url, usuario, clave);
		
	}



	@SuppressWarnings("deprecation")
	public void insertarPelicula(Pelicula pelicula) throws SQLException {
		String query="insert into pelicula(titulo,"
				+ "anio,id_genero,id_director) values(?,?,?,?)";
		PreparedStatement pr=conexion.prepareStatement(query);
		pr.setString(1, pelicula.getTitulo());
		pr.setInt(2,pelicula.getAnno() );
		pr.setInt(3, pelicula.getId_Genero());
		pr.setInt(4, pelicula.getId_Director());
		pr.execute();
		conexion.close();
		
	}

}
