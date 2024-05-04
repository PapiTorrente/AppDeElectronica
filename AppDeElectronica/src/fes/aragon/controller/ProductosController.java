package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fes.aragon.mariadb.Conexion;
import fes.aragon.modelo.Producto;
import fes.aragon.modelo.Proveedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ProductosController extends ControlGeneral implements Initializable{

	Conexion cn = this.conexionSQL();
	List<String> productos = new ArrayList<>();
	Integer valor = null;
	
    @FXML
    private Button BtnAgregarProductSistema;

    @FXML
    private Button BtnAgregarProducto;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CantidadField;

    @FXML
    private ListView<String> Lista;

    @FXML
    private TextField ModeloField;

    @FXML
    private TextField NombreField;

    @FXML
    private TextField PrecioField;

    @FXML
    private ComboBox<Proveedor> ProveedorBox;

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
    	String producto = this.ProveedorBox.getValue().getId_Proveedor() +
    			" | " + this.ProveedorBox.getValue().getNombre() + " | " + this.NombreField.getText();
    	System.out.println(this.ProveedorBox.getValue().getId_Proveedor());
    	this.productos.add(producto);
    	if(this.valor == null) {
    		this.valor = this.ProveedorBox.getSelectionModel().getSelectedIndex();
        	this.Lista.getItems().add(producto);
    	}else {
    		if(this.valor == this.ProveedorBox.getSelectionModel().getSelectedIndex()) {
    	    	this.Lista.getItems().add(producto);
    		}else {
    			this.valor = this.ProveedorBox.getSelectionModel().getSelectedIndex();
    			this.Lista.getItems().clear();
    			this.Lista.getItems().add(producto);
    		}
    	}
    }

    @FXML
    void AgregarProductSistema(ActionEvent event) {
    	try {
    		if(this.productos.size() != 0){
			int indiceEspacio;
	    	String idProveedor;
	    	for (String producto : this.productos) {
	    		indiceEspacio = producto.indexOf(' ');
	    		idProveedor = producto.substring(0, indiceEspacio);
	    		Producto p = new Producto();
	    		p.setNombre(this.NombreField.getText());
	    		p.setPrecio(Integer.parseInt(this.PrecioField.getText()));
	    		p.setModelo(this.ModeloField.getText());
	    		p.setCant_Disp(Integer.parseInt(this.CantidadField.getText()));
	    		p.setId_Proveedor(Integer.parseInt(idProveedor));
			this.cn.insertarProducto(p);
	    	}
	    	this.NombreField.clear();
	    	this.ModeloField.clear();
	    	this.PrecioField.clear();
	    	this.CantidadField.clear();
	    	this.Lista.getItems().clear();
	    	this.productos.clear();
    		}else {
    			this.NombreField.clear();
    	    	this.ModeloField.clear();
    	    	this.PrecioField.clear();
    	    	this.CantidadField.clear();
    	    	this.Lista.getItems().clear();
    	    	this.productos.clear();
    		}
		} catch (SQLException e) {
			this.ventanaEmergenteError("Productos", "Error al guardar un producto!!!");
		}
    	this.cerrar(BtnAgregarProductSistema);
    	this.abrirVentana("Ventas");
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    	abrirVentana("Ventas");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			this.ProveedorBox.setItems(this.cn.obtenerProveedores());
			this.ProveedorBox.getSelectionModel().select(0);
		} catch (SQLException e) {
			this.ventanaEmergenteError("Conexion", "Error en la conexion de la BD!!!");
		}
	}

}
