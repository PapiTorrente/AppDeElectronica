package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnviosController extends ControlGeneral {

    @FXML
    private Button BtnHacerEnvio;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CostoEnvioField;

    @FXML
    private DatePicker FechaPicker;

    @FXML
    private ComboBox<?> VentaBox;

    @FXML
    private Label txtCostoEnvio;

    @FXML
    private Label txtFechaEnvio;

    @FXML
    private Label txtVenta;

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    }

}
