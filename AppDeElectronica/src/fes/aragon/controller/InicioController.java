package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class InicioController extends ControlGeneral{

    @FXML
    private Button BtnAgregarProducto;

    @FXML
    private Button BtnHacerVenta;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CantidadField;

    @FXML
    private ComboBox<?> ClienteBox;

    @FXML
    private DatePicker FechaPicker;

    @FXML
    private TextField FormaPagoField;

    @FXML
    private ListView<?> Lista;

    @FXML
    private ComboBox<?> ProductoBox;

    @FXML
    private Menu mnuCliente;

    @FXML
    private MenuItem mnuDevolución;

    @FXML
    private MenuItem mnuEnvio;

    @FXML
    private Menu mnuOpciones;

    @FXML
    private Menu mnuProveedor;

    @FXML
    private Label txtCantidad;

    @FXML
    private Label txtCliente;

    @FXML
    private Label txtFechaVenta;

    @FXML
    private Label txtFormaPago;

    @FXML
    private Label txtProducto;

    @FXML
    void abrirClientes(ActionEvent event) {
    	this.nuevaVentana("Clientes");
    }

    @FXML
    void abrirEnvios(ActionEvent event) {
    	this.nuevaVentana("Envios");
    }
    
    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    }
}
