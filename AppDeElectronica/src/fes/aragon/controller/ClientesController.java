package fes.aragon.controller;

import java.sql.SQLException;

import fes.aragon.mariadb.Conexion;
import fes.aragon.modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ClientesController extends ControlGeneral{
	
	Conexion cn = this.conexionSQL();

    @FXML
    private TextField ApMaternoField;

    @FXML
    private TextField ApPaternoField;

    @FXML
    private Button BtnAgregarCliente;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CorreoField;

    @FXML
    private TextField DomicilioField;

    @FXML
    private RadioButton NoBtn;

    @FXML
    private TextField NombresField;

    @FXML
    private RadioButton SiBtn;

    @FXML
    private TextField TelefonoField;

    @FXML
    private Label txtApMaterno;

    @FXML
    private Label txtApPaterno;

    @FXML
    private Label txtCorreo;

    @FXML
    private Label txtDomicilio;

    @FXML
    private Label txtEsCliente;

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
    void insertarCliente(ActionEvent event) {
    	try {
    		Cliente c = new Cliente();
        	c.setNombre(this.NombresField.getText());
        	c.setAp_Paterno(this.ApPaternoField.getText());
        	c.setAp_Materno(this.ApMaternoField.getText());
        	c.setDomicilio(this.DomicilioField.getText());
        	c.setTelefono(this.TelefonoField.getText());
        	c.setCorreo(this.CorreoField.getText());
        	if (this.SiBtn.isSelected()) {
        		c.setEs_Miembro(true);
    		} else {
    			c.setEs_Miembro(false);
    		}
			this.cn.insertarCliente(c);
		} catch (SQLException e) {
			this.ventanaEmergenteError("Cliente", "Error en al guardar un Cliente!!!");
		}
    	this.cerrar(BtnAgregarCliente);
    }
}
