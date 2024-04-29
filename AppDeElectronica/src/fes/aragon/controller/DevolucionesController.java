package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fes.aragon.mariadb.Conexion;
import fes.aragon.modelo.Cliente;
import fes.aragon.modelo.Devolucion;
import fes.aragon.modelo.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DevolucionesController extends ControlGeneral implements Initializable{

	Conexion cn = this.conexionSQL();
	List<String> productos = new ArrayList<>();
	Integer valor = null;
	
    @FXML
    private Button BtnAgregarProducto;

    @FXML
    private Button BtnHacerDevolucion;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CantidadField;

    @FXML
    private ComboBox<Cliente> ClienteBox;

    @FXML
    private DatePicker FechaPicker;

    @FXML
    private TextField FormaReenvolso;

    @FXML
    private ListView<String> Lista;

    @FXML
    private TextField MotivoField;

    @FXML
    private ComboBox<Producto> ProductoBox;

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
    	String producto = this.CantidadField.getText() + " | " + this.ProductoBox.getValue().getNombre() +
    			" | " + this.ClienteBox.getValue().getNombre();
    	this.productos.add(producto);
    	if(this.valor == null) {
    		this.valor = this.ClienteBox.getSelectionModel().getSelectedIndex();
        	this.Lista.getItems().add(producto);
    	}else {
    		if(this.valor == this.ClienteBox.getSelectionModel().getSelectedIndex()) {
    	    	this.Lista.getItems().add(producto);
    		}else {
    			this.valor = this.ClienteBox.getSelectionModel().getSelectedIndex();
    			this.Lista.getItems().clear();
    			this.Lista.getItems().add(producto);
    		}
    	}
    	
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    	abrirVentana("Ventas");
    }

    @FXML
    void hacerDevolución(ActionEvent event) {
    		try {
    			int indiceEspacio;
    	    	String cantidad;
    	    	for (String producto : this.productos) {
    	    		indiceEspacio = producto.indexOf(' ');
    	    		cantidad = producto.substring(0, indiceEspacio);
    	    		Devolucion d = new Devolucion();
    	    		d.setId_Producto(this.ProductoBox.getValue().getId_Producto());
    	    		d.setPrecio(this.ProductoBox.getValue().getPrecio());
    	    		d.setCantidad(Integer.valueOf(cantidad));
    	    		d.setForma_Devol(this.FormaReenvolso.getText());
    	    		d.setMotivo(this.MotivoField.getText());
    	    		d.setId_Cliente(this.ClienteBox.getValue().getId_Cliente());
    	    		d.setForma_Devol(String.valueOf(this.FechaPicker.getValue()));
				this.cn.insertarDevolucion(d);
    	    	}
    	    	this.CantidadField.clear();
    	    	this.MotivoField.clear();
    	    	this.FechaPicker.setValue(LocalDate.now());
    	    	this.Lista.getItems().clear();
			} catch (SQLException e) {
				this.ventanaEmergenteError("Devolucion", "Error al guardar ua devolucion!!!");
	    		this.cerrar(BtnHacerDevolucion);
			}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			this.ProductoBox.getItems().addAll(this.cn.obtenerProductos());
			this.ProductoBox.getSelectionModel().select(0);
			//-----------------------------------------------------
			this.ClienteBox.getItems().addAll(this.cn.obtenerClientes());
			this.ClienteBox.getSelectionModel().select(0);
			//-----------------------------------------------------
			this.FechaPicker.setValue(LocalDate.now());
		} catch (SQLException e) {
			this.ventanaEmergenteError("Conexion", "Error en la conexion de la BD!!!");
		}
	}

}
