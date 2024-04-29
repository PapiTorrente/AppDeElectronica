package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import fes.aragon.mariadb.Conexion;
import fes.aragon.modelo.Envio;
import fes.aragon.modelo.Venta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnviosController extends ControlGeneral implements Initializable{
	
	Conexion cn = this.conexionSQL();

    @FXML
    private Button BtnHacerEnvio;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CostoEnvioField;

    @FXML
    private DatePicker FechaPicker;

    @FXML
    private ComboBox<Venta> VentaBox = new ComboBox<Venta>();

    @FXML
    private Label txtCostoEnvio;

    @FXML
    private Label txtFechaEnvio;

    @FXML
    private Label txtVenta;

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    	abrirVentana("Ventas");
    }
    
    @FXML
    void insertarEnvio(ActionEvent event) {
    	try {
    		Envio e = new Envio();
        	e.setId_Venta(this.VentaBox.getSelectionModel().getSelectedItem().getId_Venta());
        	e.setCosto_Envio(Integer.parseInt(this.CostoEnvioField.getText()));
        	e.setFecha_Envio(String.valueOf(this.FechaPicker.getValue()));
			this.cn.insertarEnvio(e);
		} catch (SQLException e1) {
			this.ventanaEmergenteError("Envio", "Error al guardar un Envio!!!");
		}
    	this.cerrar(BtnHacerEnvio);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			this.VentaBox.getItems().addAll(this.cn.obtenerVentas());
			this.VentaBox.getSelectionModel().select(0);
			//-----------------------------------------------------
			this.FechaPicker.setValue(LocalDate.now());
		} catch (SQLException e) {
		}
	}

}
