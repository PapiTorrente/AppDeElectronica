package fes.aragon.controller;

import java.io.IOException;
import java.sql.SQLException;

import fes.aragon.mariadb.Conexion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControlGeneral {

	public void abrirVentana(String archivo) {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/" + archivo + ".fxml"));
			Scene scene = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(scene);
			escenario.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarVentana(String archivo) {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/" + archivo + ".fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void test (Button button) {
		Stage stage = (Stage) button.getScene().getWindow();
		System.out.println(stage);
	}
	
	public void cerrar(Button button) {
		Stage stage = (Stage) button.getScene().getWindow();
		stage.close();
	}	
	
	public void ventanaEmergenteError(String encabezado, String contenido) {
		Alert alerta;
		alerta = new Alert(AlertType.ERROR);
		alerta.setTitle("Error");
		alerta.setHeaderText(encabezado);
		alerta.setContentText(contenido);
		alerta.showAndWait();
	}
	
	public Conexion conexionSQL() {
			try {
				return new Conexion();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
			}
			return null;
	}
}
