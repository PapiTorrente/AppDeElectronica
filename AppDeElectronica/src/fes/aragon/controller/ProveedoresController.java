package fes.aragon.controller;

import java.sql.SQLException;

import fes.aragon.mariadb.Conexion;
import fes.aragon.modelo.Proveedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProveedoresController extends ControlGeneral{

	Conexion cn = this.conexionSQL();
	
    @FXML
    private TextField ApMaternoField;

    @FXML
    private TextField ApPaternoField;
    
    @FXML
    private TextField NombreEmpresaField;

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
    	try {
    		Proveedor p = new Proveedor();
    		p.setNombreEmpresa(this.NombreEmpresaField.getText());
        	p.setNombre(this.NombresField.getText());
        	p.setAp_Paterno(this.ApPaternoField.getText());
        	p.setAp_Materno(this.ApMaternoField.getText());
        	p.setTelefono(this.TelefonoField.getText());
        	p.setCorreo(this.CorreoField.getText());
			this.cn.insertarProveedor(p);
		} catch (SQLException e) {
			this.ventanaEmergenteError("Proveedor", "Error al guardar un proveedor!!!");
		}
    	this.cerrar(BtnCrearProveedor);
    	this.abrirVentana("Ventas");
    }

}
