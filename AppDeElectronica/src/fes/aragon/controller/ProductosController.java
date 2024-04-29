package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ProductosController extends ControlGeneral{

    @FXML
    private Button BtnAgregarProductSistema;

    @FXML
    private Button BtnAgregarProducto;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CantidadField;

    @FXML
    private ListView<?> Lista;

    @FXML
    private TextField ModeloField;

    @FXML
    private TextField NombreField;

    @FXML
    private TextField PrecioField;

    @FXML
    private ComboBox<?> ProveedorBox;

    @FXML
    private Label txtCantidad;

    @FXML
    private Label txtModelo;

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtPrecio;

    @FXML
    private Label txtProveedor;

    @FXML
    void AgregarProductProveedor(ActionEvent event) {

    }

    @FXML
    void AgregarProductSistema(ActionEvent event) {

    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    	abrirVentana("Ventas");
    }

}
