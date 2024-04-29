package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DevolucionesController extends ControlGeneral {

    @FXML
    private Button BtnAgregarProducto;

    @FXML
    private Button BtnHacerDevolucion;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CantidadField;

    @FXML
    private ComboBox<?> ClienteBox;

    @FXML
    private DatePicker FechaPicker;

    @FXML
    private TextField FormaReenvolso;

    @FXML
    private ListView<?> Lista;

    @FXML
    private TextField MotivoField;

    @FXML
    private ComboBox<?> ProductoBox;

    @FXML
    private Label txtCantidad;

    @FXML
    private Label txtCliente;

    @FXML
    private Label txtFechaDevolucion;

    @FXML
    private Label txtFormaPago;

    @FXML
    private Label txtMotivo;

    @FXML
    private Label txtProducto;

    @FXML
    void agregarProducto(ActionEvent event) {

    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    	abrirVentana("Ventas");
    }

    @FXML
    void hacerDevolución(ActionEvent event) {

    }

}
