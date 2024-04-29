package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProveedoresController extends ControlGeneral{

    @FXML
    private TextField ApMaternoField;

    @FXML
    private TextField ApPaternoField;

    @FXML
    private Button BtnCrearProveedor;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CorreoField;

    @FXML
    private TextField NombresField;

    @FXML
    private TextField TelefonoField;

    @FXML
    private Label txtApMaterno;

    @FXML
    private Label txtApPaterno;

    @FXML
    private Label txtCorreo;

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtTelefono;

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    	abrirVentana("Ventas");
    }

    @FXML
    void crearProveedor(ActionEvent event) {

    }

}
